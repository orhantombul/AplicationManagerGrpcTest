import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tr.com.argela.containermanager.Common.ApplicationManager;
import tr.com.argela.containermanager.Controller.ApplicationControllerUtil;

import java.io.InputStream;
import java.util.Map;

public class TestGrpc {
    ApplicationManager applicationManager;


    @Before
    public void setup() {
        applicationManager = ApplicationManager.getApplicationManager();
        //GRPCStateNotifier grpcStateNotifier = GRPCStateNotifier.getGrpcStateNotifier();
        //when(grpcStateNotifier.update(any(),any()),)
        //GRPCStateNotifier.getGrpcStateNotifier();
        //grpcStateNotifier.startObserving(applicationManager);

    }

    @Test
    public void testReadFile(){
        // Map<String,String> containerMap = ApplicationControllerUtil.parse();
        // Assert.assertEquals(con);
    }


    @Test
    public void testAppManager(){
        addMockData();
        Assert.assertEquals(3,applicationManager.getContainers().size());
        Assert.assertEquals(applicationManager.getContainer("192.168.1.2").getDockerlist().size(),3);
    }

    private void addMockData() {
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker1","192.168.28.55","PASS");
// 1.container 2. docker
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.1","Docker2","192.168.28.56","PASS");
// 2.container 1.docker
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker3","192.168.28.57","FAIL");
// 2.container 2.docker
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.2","Docker4","192.168.28.58","FAIL");
// 3.container 1.docker
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.3","Docker5","192.168.28.59","PASS");
// 3.container 2.docker
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.3","Docker6","192.168.28.60","FAIL");
// 3.container 3.docker
        ApplicationControllerUtil.addDockerToAppManager("192.168.1.3","Docker7","192.168.28.61","PASS");
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
        containerMap.forEach((s, stringStringMap) -> {System.out.println(s);
            stringStringMap.forEach((s1, s2) -> System.out.println(s1 +" : " +s2));
        }
        );
    }


}
