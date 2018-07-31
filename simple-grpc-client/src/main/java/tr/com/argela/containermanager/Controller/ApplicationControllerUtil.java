package tr.com.argela.containermanager.Controller;

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

    private static List<Docker> getGrpcDockerListByControllerDockerList
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
}
