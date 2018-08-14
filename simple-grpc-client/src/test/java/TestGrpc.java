import org.junit.Before;
import org.junit.Test;
import tr.com.argela.containermanager.Common.ApplicationManager;
import tr.com.argela.containermanager.Configuration.Config;
import tr.com.argela.containermanager.Controller.ApplicationControllerUtil;
import tr.com.argela.containermanager.Model.Container;
import tr.com.argela.containermanager.Model.Docker;
import tr.com.argela.containermanager.Model.DockerInfo;
import tr.com.argela.containermanager.Notifier.GRPCStateNotifier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class TestGrpc {
    ApplicationManager applicationManager;
    String BasicString = "Basic";
    String healthCheckString = "Health Check";


    @Before
    public void setup() {
        applicationManager = ApplicationManager.getApplicationManager();
        GRPCStateNotifier grpcStateNotifier = GRPCStateNotifier.getGrpcStateNotifier();
        GRPCStateNotifier.getGrpcStateNotifier();
        grpcStateNotifier.startObserving(applicationManager);

    }

    @Test
    public void testReadFile(){
        // Map<String,String> containerMap = ApplicationControllerUtil.parse();
        // Assert.assertEquals(con);
    }


    @Test
    public void testAppManager(){
        //Properties config = Config.configReader();
        //ApplicationControllerUtil.firstMailAddr=config.getProperty("firstMailAddr");

        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker11","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker71","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker72","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker73","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker74","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker75","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker73","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker76","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker77","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker78","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker79","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker80","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker81","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker1","192.168.28.55","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker7","192.168.28.55","FAIL");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker8","192.168.28.55","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker9","192.168.28.55","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker10","192.168.28.55","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker11","192.168.28.55","FAIL");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker12","192.168.28.55","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker13","192.168.28.55","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker14","192.168.28.55","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker15","192.168.28.55","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker16","192.168.28.55","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker17","192.168.28.55","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker18","192.168.28.55","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker19","192.168.28.55","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker20","192.168.28.55","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker21","192.168.28.55","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker22","192.168.28.55","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker23","192.168.28.55","PASS");


// 1.container 2. docker
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker2","192.168.28.56","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker11","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker71","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker72","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker73","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker74","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker75","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker73","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker76","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker77","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker78","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker79","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker80","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker81","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker1","192.168.28.55","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker7","192.168.28.55","FAIL");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker8","192.168.28.55","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker9","192.168.28.55","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker10","192.168.28.55","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker11","192.168.28.55","FAIL");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker12","192.168.28.55","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker13","192.168.28.55","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker14","192.168.28.55","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker15","192.168.28.55","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker16","192.168.28.55","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker17","192.168.28.55","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker18","192.168.28.55","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker19","192.168.28.55","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker20","192.168.28.55","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker21","192.168.28.55","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker22","192.168.28.55","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker23","192.168.28.55","PASS");
// 2.container 1.docker
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker3","192.168.28.57","FAIL");
// 2.container 2.docker
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker4","192.168.28.58","FAIL");
// 3.container 1.docker
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.3","Docker5","192.168.28.59","PASS");
// 3.container 2.docker
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.3","Docker6","192.168.28.60","FAIL");
// 3.container 3.docker
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.3","Docker11","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.3","Docker71","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.3","Docker72","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.3","Docker73","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.3","Docker74","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.3","Docker75","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.3","Docker73","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.3","Docker76","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.3","Docker77","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.3","Docker78","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.3","Docker79","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.3","Docker80","192.168.28.61","PASS");
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.3","Docker81","192.168.28.61","PASS");

        //    System.out.println(applicationManager.getContainers());
    }

    @Test
    public void parseTestFile() throws Exception {
        String respath = "/container_ip.txt";
        InputStream in = TestGrpc.class.getResourceAsStream(respath);
        if ( in == null )
            throw new Exception("resource not found: " + respath);
        System.out.println(in);
        System.out.println(respath);
    }

    @Test
    public void parseContainer(){
        Map<String,Map<String,String>> containerMap=
                ApplicationControllerUtil.parseContainer("src/test/resources/container_ip.txt","=");
        StringBuilder stringBuilder = new StringBuilder();
        containerMap.forEach((s, stringStringMap) -> stringStringMap.forEach((s1, s2) -> {
            s1 = ApplicationControllerUtil.buildKeyNameForEteshare(s1);
            s2 = ApplicationControllerUtil.buildValueNameForEteshare(s2);
            stringBuilder.append(s1);
            stringBuilder.append(" = ");
            stringBuilder.append(s2);
            stringBuilder.append("\n");
        }));

        System.out.println(stringBuilder.toString());

    }


    @Test
    public void testUnderscore(){
         final String str = "GLOBAL_INJECTED_AAI1_IP_ADDR";
         String[] parsedStr = str.split("_");

        System.out.println(parsedStr[2]);
    }
    @Test
    public void testFileReader() throws IOException {
       // ApplicationControllerUtil.fileReader("src/test/resources/container_ip.txt");
    }


    @Test
    public void givenUsingJava7_whenWritingToFile_thenCorrect()
            throws IOException {
        String readFilename = "src/test/resources/container_ip.txt";
        Path readfilepath = Paths.get(readFilename);
        List<String> lines = Files.readAllLines(readfilepath);
        if(lines==null)return;

        String writeFilename ="src/test/resources/deneme.txt";
        Path writePath = Paths.get(writeFilename);
        /*for (String line : lines){
            String str = line.toUpperCase();
            Files.write(writePath, Collections.singleton(str));
        }
        */
        Files.write(writePath, lines);

        String read = Files.readAllLines(writePath).get(0);

    }
    @Test
    public void readProcess(){
        applicationManager= ApplicationManager.getApplicationManager();
        try {
            String line;
            Process p = Runtime.getRuntime().exec
                    ("src/test/resources/ete_c.sh health");

            BufferedReader input =
                    new BufferedReader
                            (new InputStreamReader(p.getInputStream()));
            Container container = new Container();
            container.setIp("192.168.10.11");
            List<Docker > dockerList = new ArrayList<>();
            container.setDockerlist(dockerList);
            while ((line = input.readLine()) != null) {
                AbstractMap.SimpleEntry<String ,String> dockerSimpleEntry =
                        ApplicationControllerUtil.parseProceccessedLine(line);
                Docker docker= new Docker();
                DockerInfo dockerInfo = new DockerInfo();
                docker.setName(dockerSimpleEntry.getKey());
                dockerInfo.setStatus(dockerSimpleEntry.getValue());
                docker.setInfo(dockerInfo);
                System.out.println(dockerSimpleEntry.getKey());

                if(dockerSimpleEntry.getKey() !=null) {
                    docker.setName(dockerSimpleEntry.getKey());
                    if(dockerSimpleEntry.getValue() !=null) {
                        dockerInfo.setStatus(dockerSimpleEntry.getValue());
                        dockerInfo.setIp("192.168.1.1");
                        dockerList.add(docker);
                        applicationManager.addDockerByContainerIp("192.168.10.11", docker);
                    }
                }
            }

            input.close();
        }
        catch (Exception err) {
            err.printStackTrace();
        }
    }

    @Test
    public void reallyTest(){
        Map<String,Map<String,String>> containerMap=
                ApplicationControllerUtil.parseContainer("src/main/resources/container_ip.txt","=");

        containerMap.forEach((s, dockerMap) -> {
                    StringBuilder stringBuilder = new StringBuilder();

                    dockerMap.forEach((s1, s2) -> {
                        s1 = ApplicationControllerUtil.buildKeyNameForEteshare(s1);
                        s2 = ApplicationControllerUtil.buildValueNameForEteshare(s2);
                        stringBuilder.append(s1);
                        stringBuilder.append(" = ");
                        stringBuilder.append(s2);
                        stringBuilder.append("\n");
                    });
                    //TODO:write to file (env file)

            String writeFilename ="src/test/resources/deneme.txt";
            Path writePath = Paths.get(writeFilename);
            try {
                Files.write(writePath, Collections.singleton(stringBuilder.toString()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}