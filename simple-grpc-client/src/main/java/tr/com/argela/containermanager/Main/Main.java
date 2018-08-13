package tr.com.argela.containermanager.Main;

import tr.com.argela.containermanager.Common.ApplicationManager;
import tr.com.argela.containermanager.Controller.ApplicationControllerUtil;
import tr.com.argela.containermanager.Notifier.GRPCStateNotifier;
import tr.com.argela.containermanager.Model.Docker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args){
        ApplicationManager applicationManager = ApplicationManager.getApplicationManager();
        GRPCStateNotifier grpcStateNotifier = GRPCStateNotifier.getGrpcStateNotifier();
        grpcStateNotifier.startObserving(applicationManager);

        Runnable runnable = () -> {
            try {
                Map<String, Map<String, String>> containerMap = ApplicationControllerUtil.parseContainer(ApplicationControllerUtil.IP_POOL_ADDRESS, ApplicationControllerUtil.EQUAL);

                if (containerMap == null || containerMap.isEmpty()) return;

                containerMap.forEach((container_ip, dockerMap) -> {
                    StringBuilder stringBuilder = new StringBuilder();

                    dockerMap.forEach((docker_name, docker_status) -> ApplicationControllerUtil.addStringDockerInfoToStringBuilder(stringBuilder, docker_name, docker_status));

                    Path writePath = Paths.get(ApplicationControllerUtil.ROBOT_IP_ADDRESS);

                    try {
                        Files.write(writePath, Collections.singleton(stringBuilder.toString()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    BufferedReader bufferedReader = processScriptAndGenerateBufferedReader();
                    if (bufferedReader == null) return;
                    String line;
                    try {
                        while ((line = bufferedReader.readLine()) != null) {
                            processScriptOutputLine(container_ip, dockerMap, line);
                        }
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(runnable,1,240,TimeUnit.SECONDS);
    }

    private static BufferedReader processScriptAndGenerateBufferedReader(){
        Process process = null;
        try {
            process = Runtime.getRuntime().exec
                    (ApplicationControllerUtil.ROBOT_SCRIPT_FILE_ADDRESS);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(process == null)
            return null;

        return new BufferedReader(new InputStreamReader(process.getInputStream()));
    }

    private static void processScriptOutputLine(String container_ip,Map<String,String> dockerMap,String line){
        System.out.println(line);
        if(container_ip == null || dockerMap == null || line == null)
            return;
        ApplicationManager applicationManager= ApplicationManager.getApplicationManager();
        AbstractMap.SimpleEntry<String, String> dockerNameToIpEntry = ApplicationControllerUtil.parseProceccessedLine(line);
        Docker docker  = ApplicationControllerUtil.createDockerFromNameToIpEntry(dockerNameToIpEntry,dockerMap);
        if(docker !=  null)
            applicationManager.addDockerByContainerIp(container_ip, docker);
    }

}

