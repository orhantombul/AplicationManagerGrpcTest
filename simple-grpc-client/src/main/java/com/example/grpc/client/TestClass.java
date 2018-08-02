package com.example.grpc.client;

import tr.com.argela.containermanager.Common.ApplicationManager;
import tr.com.argela.containermanager.Model.Container;
import tr.com.argela.containermanager.Model.Docker;
import tr.com.argela.containermanager.Model.DockerInfo;

import java.util.ArrayList;
import java.util.List;

public class TestClass {
    public static DockerInfo createDockerInfo(String dockerIp, String status)
    {
        DockerInfo dockerInfo = new DockerInfo();
        dockerInfo.setIp(dockerIp);
        dockerInfo.setStatus(status);
        return dockerInfo;
    }

    public static Docker createDocker(String dockerName, DockerInfo dockerInfo)
    {
       Docker docker = new Docker();
       docker.setName(dockerName);
       docker.setInfo(dockerInfo);
       return docker;
    }
    public static Container createContainer(String ip, List<Docker> dockerList){
        Container container = new Container();
        container.setIp(ip);
        container.setDockerlist(dockerList);
        return container;
    }
    public static void addDockerToAppManager(String containerIp, String dockerName, String dockerIp, String dockerStatus){
        ApplicationManager applicationManager = ApplicationManager.getApplicationManager();
        DockerInfo dockerInfo = createDockerInfo(dockerIp,dockerStatus);
        Docker docker = createDocker(dockerName,dockerInfo);
        applicationManager.addDockerByContainerIp(containerIp,docker);

    }
    public static void main(String[] args) {
//Create Application Manager

        ApplicationManager applicationManager = ApplicationManager.getApplicationManager();
        List<Container> containers = new ArrayList<>();

// 1.container 1. docker


        addDockerToAppManager("192.168.1.1","Docker1","192.168.28.55","FAIL");

// 1.container 2. docker
        DockerInfo dockerInfo1 = createDockerInfo("192.168.28.56","PASS");
        Docker docker1 = createDocker("Docker2",dockerInfo1);
        dockerList.add(docker1);
        applicationManager.addDockerByContainerIp(container.getIp(),docker1);
        addDockerToAppManager("192.168.1.1","Docker1","192.168.28.55","FAIL");



// 2.container 1.docker
        List<Docker> dockerList2 = new ArrayList<>();

        DockerInfo dockerInfo2 = createDockerInfo("192.168.28.57","FAIL");
        Docker docker2 =createDocker("Docker3",dockerInfo2);
        dockerList2.add(docker2);
        Container container1 = createContainer("192.168.1.2",dockerList2);

// 2.container 2.docker
        DockerInfo dockerInfo3 = createDockerInfo("192.168.28.58","PASS")
        Docker docker3 = createDocker("Docker4",dockerInfo3);
        dockerList2.add(docker3);
        applicationManager.addDockerByContainerIp(container1.getIp(),docker3);



// 3.container 1.docker
        List<Docker> dockerList3 = new ArrayList<>();

        DockerInfo dockerInfo4 = createDockerInfo("192.168.28.59","FAIL");
        Docker docker4 = createDocker("Docker5",dockerInfo4);
        dockerList3.add(docker4);
        Container container2 = createContainer("192.168.1.3",dockerList3);


// 3.container 2.docker
        DockerInfo dockerInfo5 = createDockerInfo("192.168.28.60","FAIL");
        Docker docker5 = createDocker("Docker6",dockerInfo5);
        dockerList3.add(docker5);
        applicationManager.addDockerByContainerIp(container2.getIp(),docker5);

// 3.container 3.docker
        DockerInfo dockerInfo6 = createDockerInfo("192.168.28.60","FAIL");
        Docker docker6 = createDocker("Docker7",dockerInfo6);



        Docker docker7 = new Docker();
        docker7.setName("Docker4");
        docker7.setInfo(dockerInfo7);
        dockerList3.add(docker7);


        applicationManager.setContainer(container1.getIp(),container1);
        applicationManager.setContainer(container2.getIp(),container2);
        applicationManager.setContainer(container3.getIp(),container3);



        System.out.println(applicationManager.getContainers());

/*
ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5015).usePlaintext(true)
            .build();

    SendServiceGrpc.SendServiceBlockingStub sendServiceBlockingStub =
            SendServiceGrpc.newBlockingStub(channel);


  List<Docker>  dockerList  =new ArrayList<>();
    DockerInfo dockerInfo = DockerInfo.newBuilder()
    .setIp("192.168.1.2")
    .setStatus("PASS").build();

    Docker docker = Docker.newBuilder()
    .setName("DOCKER1")
    .setInfo(dockerInfo).build();

    dockerList.add(docker);

    Iterable<Docker> dockerIterable = dockerList;

    Container container = Container.newBuilder()
    .addAllDockerlist(dockerIterable)
    .setIp("192.168.3.3").build();

    List<Container> containers = new ArrayList<>();
    containers.add(container);

    ContainerListRequest containerList = ContainerListRequest.newBuilder().addAllContainerlist(containers).build();

    ContainerListResponse response = sendServiceBlockingStub.contlist(containerList);
    System.out.println(response);
*/



    }
}
