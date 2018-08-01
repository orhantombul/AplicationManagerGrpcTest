package tr.com.argela.containermanager.Common;

import tr.com.argela.containermanager.Model.Container;
import tr.com.argela.containermanager.Model.Docker;

import java.util.HashMap;
import java.util.List;
public class ApplicationManager {
    private final HashMap<String, Container> containerHashMap = new HashMap<String, Container>();
    private final ApplicationManager applicationManager= new ApplicationManager();

    private ApplicationManager() {
    }

    public ApplicationManager getApplicationManager() {
        return applicationManager;
    }

    public void setContainer(String ip,Container container){

        this.containerHashMap.put(ip,container);

    }
    //TODO ask here is true ?
    public Container getContainer(String ip){
      return this.containerHashMap.get(ip);
    }

    public void createDockerWithContainerIp(String ip){
        Container container = new Container();
        container.setIp(ip);
        //TODO  Create new dockerlist
        List docker_list = container.getDockerlist();
        container.setDockerlist(docker_list);
        this.containerHashMap.put(ip,container);
    }

    public void addDockerByContainerIp(String ip,Docker docker){
        Container container =this.containerHashMap.get(ip);
        List<Docker> docker_list = container.getDockerlist();
        docker_list.add(docker);
    }

    public Docker getDocker(String container_ip, String docker_ip){
       Container container = this.containerHashMap.get(container_ip);
       List<Docker> docker_list = container.getDockerlist();


       for (Docker docker : docker_list){
           if(docker.getInfo().getIp().equals(docker_ip)) return docker;
       }
        return null;
    }

    public void getContainers(){}

    public void clearAll(){}


}
