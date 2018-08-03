package tr.com.argela.containermanager.Controller;

import tr.com.argela.containermanager.Common.ApplicationManager;
import tr.com.argela.grpcserver.Container;
import tr.com.argela.grpcserver.Docker;
import tr.com.argela.grpcserver.DockerInfo;

import java.util.ArrayList;
import java.util.List;

public class ApplicationControllerUtil {

    private ApplicationControllerUtil() {
    }

    public static DockerInfo getGrpcDockerInfoByControllerDockerInfo(
            tr.com.argela.containermanager.Model.DockerInfo dockerInfo)
    {
       return DockerInfo.newBuilder().setIp(dockerInfo.getIp()).setStatus(dockerInfo.getStatus()).build();
    }

    public static Docker getGrpcDockerByControllerDocker(
            tr.com.argela.containermanager.Model.Docker docker)
    {
        return Docker.newBuilder().setInfo(getGrpcDockerInfoByControllerDockerInfo(docker.getInfo()))
                .setName(docker.getName()).build();
    }

    public static List<Docker> getGrpcDockerListByControllerDockerList
            (List<tr.com.argela.containermanager.Model.Docker > dockerList){
        List<Docker> grpcDockerList = new ArrayList<>();

        for (tr.com.argela.containermanager.Model.Docker docker : dockerList)
        {
            grpcDockerList.add(getGrpcDockerByControllerDocker(docker));
        }
        return grpcDockerList;
    }

    public static Container getGrpcContainerByControllerContainer(
            tr.com.argela.containermanager.Model.Container container)
    {
        List<tr.com.argela.containermanager.Model.Docker> dockerlist = container.getDockerlist();
        return Container.newBuilder().setIp(container.getIp()).
                addAllDockerlist(getGrpcDockerListByControllerDockerList(dockerlist)).build();
    }
    public static tr.com.argela.containermanager.Model.DockerInfo createDockerInfo(String dockerIp, String status)
    {
        tr.com.argela.containermanager.Model.DockerInfo dockerInfo = new tr.com.argela.containermanager.Model.DockerInfo();
        dockerInfo.setIp(dockerIp);
        dockerInfo.setStatus(status);
        return dockerInfo;
    }

    public static tr.com.argela.containermanager.Model.Docker createDocker(String dockerName, tr.com.argela.containermanager.Model.DockerInfo dockerInfo)
    {
        tr.com.argela.containermanager.Model.Docker docker = new tr.com.argela.containermanager.Model.Docker();
        docker.setName(dockerName);
        docker.setInfo(dockerInfo);
        return docker;
    }
    public static tr.com.argela.containermanager.Model.Container createContainer(String ip, List<tr.com.argela.containermanager.Model.Docker> dockerList){
        tr.com.argela.containermanager.Model.Container container = new tr.com.argela.containermanager.Model.Container();
        container.setIp(ip);
        container.setDockerlist(dockerList);

        return container;
    }
    public static void addDockerToAppManager(String containerIp, String dockerName, String dockerIp, String dockerStatus){
        ApplicationManager applicationManager = ApplicationManager.getApplicationManager();
        tr.com.argela.containermanager.Model.DockerInfo dockerInfo = createDockerInfo(dockerIp,dockerStatus);
        tr.com.argela.containermanager.Model.Docker docker = createDocker(dockerName,dockerInfo);
        applicationManager.addDockerByContainerIp(containerIp,docker);
    }



}
