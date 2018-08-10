package tr.com.argela.containermanager.Controller;

import tr.com.argela.containermanager.Common.ApplicationManager;
import tr.com.argela.grpcserver.Container;
import tr.com.argela.grpcserver.Docker;
import tr.com.argela.grpcserver.DockerInfo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ApplicationControllerUtil {

    private static Integer FIRST_CHAR = 0;
    private static Integer SECOND_CHAR = 1;
    public static final String PREFIX_ETESHARE = "GLOBAL_INJECTED_";
    public static final String POSTIX_ETESHARE = "_IP_ADDR";
    public static final String DOUBLE_QUOTES = "\"";
    public static final String BASIC = "Basic";
    public static final String HEALTH_CHECK = "Health Check";
    public static final String EQUAL = "=";
    public static final String IP_POOL_ADDRESS = "simple-grpc-client/src/main/resources/container_ip.txt";
    public static final String ROBOT_IP_ADDRESS = "simple-grpc-client/src/main/resources/eteshare/config/vm_properties.py";
    public static final String NEW_LINE = "\n";
    public static final String ROBOT_SCRIPT_FILE_ADDRESS = "simple-grpc-client/src/main/resources/ete.sh health";

    private ApplicationControllerUtil() {
    }

    public static DockerInfo getGrpcDockerInfoByControllerDockerInfo(tr.com.argela.containermanager.Model.DockerInfo dockerInfo) {
        return DockerInfo.newBuilder().setIp(dockerInfo.getIp()).setStatus(dockerInfo.getStatus()).build();
    }

    public static Docker getGrpcDockerByControllerDocker(tr.com.argela.containermanager.Model.Docker docker) {
        return Docker.newBuilder().setInfo(getGrpcDockerInfoByControllerDockerInfo(docker.getInfo())).setName(docker.getName()).build();
    }

    public static List<Docker> getGrpcDockerListByControllerDockerList(List<tr.com.argela.containermanager.Model.Docker> dockerList) {
        List<Docker> grpcDockerList = new ArrayList<>();

        for (tr.com.argela.containermanager.Model.Docker docker : dockerList) {
            grpcDockerList.add(getGrpcDockerByControllerDocker(docker));
        }
        return grpcDockerList;
    }

    public static Container getGrpcContainerByControllerContainer(tr.com.argela.containermanager.Model.Container container) {
        List<tr.com.argela.containermanager.Model.Docker> dockerlist = container.getDockerlist();
        return Container.newBuilder().setIp(container.getIp()).
                addAllDockerlist(getGrpcDockerListByControllerDockerList(dockerlist)).build();
    }

    public static tr.com.argela.containermanager.Model.DockerInfo createDockerInfo(String dockerIp, String status) {
        tr.com.argela.containermanager.Model.DockerInfo dockerInfo = new tr.com.argela.containermanager.Model.DockerInfo();
        dockerInfo.setIp(dockerIp);
        dockerInfo.setStatus(status);
        return dockerInfo;
    }

    public static tr.com.argela.containermanager.Model.Docker createDocker(String dockerName, tr.com.argela.containermanager.Model.DockerInfo dockerInfo) {
        tr.com.argela.containermanager.Model.Docker docker = new tr.com.argela.containermanager.Model.Docker();
        docker.setName(dockerName);
        docker.setInfo(dockerInfo);
        return docker;
    }

    public static tr.com.argela.containermanager.Model.Container createContainer(String ip, List<tr.com.argela.containermanager.Model.Docker> dockerList) {
        tr.com.argela.containermanager.Model.Container container = new tr.com.argela.containermanager.Model.Container();
        container.setIp(ip);
        container.setDockerlist(dockerList);

        return container;
    }

    public static void addDockerToAppManager(String containerIp, String dockerName, String dockerIp, String dockerStatus) {
        ApplicationManager applicationManager = ApplicationManager.getApplicationManager();
        tr.com.argela.containermanager.Model.DockerInfo dockerInfo = createDockerInfo(dockerIp, dockerStatus);
        tr.com.argela.containermanager.Model.Docker docker = createDocker(dockerName, dockerInfo);
        applicationManager.addDockerByContainerIp(containerIp, docker);
    }

    public static String buildKeyNameForEteshare(String moduleName) {
        return new StringBuilder().append(PREFIX_ETESHARE).append(moduleName.toUpperCase().trim()).append(POSTIX_ETESHARE).toString();
    }

    public static String buildValueNameForEteshare(String ip) {
        return new StringBuilder().append(DOUBLE_QUOTES).append(ip.trim()).append(DOUBLE_QUOTES).toString();
    }

    public static AbstractMap.SimpleEntry<String,String> parseProceccessedLine(String  line) {
        String moduleName = null;
        String status = null;
        if (line.startsWith(BASIC)) {
            String[] splittedLine = line.split("\\|");
            moduleName = splittedLine[0].substring(splittedLine[0].indexOf(BASIC) +
                    BASIC.length(), splittedLine[0].indexOf(HEALTH_CHECK)).trim();
            status = splittedLine[1].trim();
        }
        return  new AbstractMap.SimpleEntry<>(moduleName,status);
    }

    private static List<String> readLines(String filePath){
        Path path = Paths.get(filePath);
        if(!Files.exists(path) || !Files.isReadable(path)){
            return null;
        }
        List<String> lines = null;
        try {
            lines = Files.readAllLines(path);

            if (lines == null) {
                return null;
            }
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            return lines;
        }
    }

    public static Map<String,Map<String, String>>  parseContainer (String filepath, String parsingChar){

            List<String> lines = readLines(filepath);
            if(lines == null)
                return null;
            Map<String, Map<String, String>> mappedLines = new HashMap<>();
            Integer counter = 0;
            Map<String, String> dockerMap = new HashMap<>();
            String currentDockerIp = null;
            for (String line : lines){
                String [] parsedLine =line.split(parsingChar);
                if(parsedLine.length == 2 &&
                        null != parsedLine[FIRST_CHAR]  &&
                        null != parsedLine[SECOND_CHAR] &&
                        null == mappedLines.get(parsedLine[FIRST_CHAR])){
                    if(counter == 0 ){
                        mappedLines.put(parsedLine[SECOND_CHAR],new HashMap<>());
                        currentDockerIp =parsedLine[SECOND_CHAR];
                        dockerMap = new HashMap<>();
                    }
                    else{
                        Map<String,String> parsedDocker = parseDocker(parsedLine);
                        if(parsedDocker==null)
                            continue;
                        dockerMap.putAll(parsedDocker);
                    }
                    counter++;
                }
                else{
                    counter =0;
                    if(currentDockerIp==null)
                        continue;
                    Map<String,String > currentDockerMap =mappedLines.get(currentDockerIp);
                    currentDockerMap.putAll(dockerMap);
                }

            }
            Map<String,String > currentDockerMap =mappedLines.get(currentDockerIp);
            currentDockerMap.putAll(dockerMap);

            return mappedLines;
    }

    private static Map<String,String> parseDocker(String[] parsedLine) {
        if(null != parsedLine[FIRST_CHAR] &&
                null != parsedLine[SECOND_CHAR]){
            Map<String,String> dockerMap =new HashMap<>();
            dockerMap.put(parsedLine[FIRST_CHAR],parsedLine[SECOND_CHAR]);
            return dockerMap;
        }
        return null;
    }

    public static String convertTestModuleNameToContainerName(String testModuleName)
    {
        testModuleName = testModuleName.toUpperCase();
        if (testModuleName.equals("A&AI"))
            return "AAI1";
        else if(testModuleName.contains("AAF"))
            return "AAF";
        else if(testModuleName.equals("DMAAP Message Router".toUpperCase()))
            return "MR";
        else if(testModuleName.equals("External API NBI".toUpperCase()))
            return "NBI";
        else if(testModuleName.equals("Microservice Bus".toUpperCase()) || testModuleName.contains("VFC") ||
                testModuleName.contains("Multicloud".toUpperCase())
                || testModuleName.contains("UseCaseUI".toUpperCase()))
            return "OPENO";
        else if(testModuleName.contains("OOF"))
            return "OOF";
        else
            return testModuleName;
    }


    public static void addStringDockerInfoToStringBuilder(StringBuilder stringBuilder, String docker_name, String docker_status) {
        docker_name = buildKeyNameForEteshare(docker_name);
        docker_status = buildValueNameForEteshare(docker_status);
        stringBuilder.append(docker_name);
        stringBuilder.append(" "+EQUAL+" ");
        stringBuilder.append(docker_status);
        stringBuilder.append(NEW_LINE);
    }

    public static tr.com.argela.containermanager.Model.Docker createDockerFromNameToIpEntry(AbstractMap.SimpleEntry<String,String> dockerNameToIpEntry, Map<String,String> dockerMap) {
        if(dockerNameToIpEntry == null || dockerMap == null)
            return null;
        tr.com.argela.containermanager.Model.DockerInfo dockerInfo = new tr.com.argela.containermanager.Model.DockerInfo();

        if (dockerNameToIpEntry.getKey() != null) {
            tr.com.argela.containermanager.Model.Docker docker = ApplicationControllerUtil.createDocker(dockerNameToIpEntry.getKey(), dockerInfo);
            if (dockerNameToIpEntry.getValue() != null) {
                dockerInfo.setStatus(dockerNameToIpEntry.getValue());

                String moduleName = dockerNameToIpEntry.getKey();
                moduleName = ApplicationControllerUtil.convertTestModuleNameToContainerName(moduleName);
                String dockerIp = dockerMap.get(moduleName);
                if (dockerIp != null) dockerInfo.setIp(dockerIp);
                return docker;
            }
        }
        return null;
    }
}
