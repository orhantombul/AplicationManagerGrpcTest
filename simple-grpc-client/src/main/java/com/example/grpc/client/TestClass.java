package com.example.grpc.client;

import tr.com.argela.containermanager.Common.ApplicationManager;
import tr.com.argela.containermanager.Controller.ApplicationControllerUtil;
import tr.com.argela.containermanager.Edge.GRPCStateNotifier;

public class TestClass {

    public static void main(String[] args) {
        ApplicationManager applicationManager = ApplicationManager.getApplicationManager();
        GRPCStateNotifier grpcStateNotifier = GRPCStateNotifier.getGrpcStateNotifier();
        grpcStateNotifier.startObserving(applicationManager);
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
}
