package tr.com.argela.containermanager.Common;

import tr.com.argela.containermanager.Model.Container;
import tr.com.argela.containermanager.Model.Docker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


public class ApplicationManager {
    private final ConcurrentHashMap<String, Container> containerHashMap = new ConcurrentHashMap<String, Container>();
    private static final ApplicationManager applicationManager= new ApplicationManager();

    private ApplicationManager() {
    }

    public static ApplicationManager getApplicationManager() {
        return applicationManager;
    }

    public void setContainer(String ip,Container container){
        if(ip == null || container == null) {
            return;
        }
        this.containerHashMap.put(ip,container);

    }

    public Container getContainer(String ip){
        if(ip == null ) {
            return null;
        }
      return this.containerHashMap.get(ip);
    }

    public Container createDockerWithContainerIp(String ip){
        if(ip == null || this.containerHashMap.get(ip) != null) {
            return null;
        }
        Container container = new Container();
        container.setIp(ip);

        List<Docker> docker_list = new ArrayList<>();
        container.setDockerlist(docker_list);
        this.containerHashMap.put(ip,container);
        return container;
    }

    public void addDockerByContainerIp(String ip,Docker docker){
        if(ip == null || docker == null) {
            return;
        }
        Container container =this.containerHashMap.get(ip);
        if(container == null)
        {
            container = createDockerWithContainerIp(ip);

        }
        List<Docker> docker_list = container.getDockerlist();
        docker_list.add(docker);

    }

    public Docker getDocker(String container_ip, String docker_ip){
        if(container_ip == null || docker_ip == null) {
            return null;
        }
        Container container = this.containerHashMap.get(container_ip);
       List<Docker> docker_list = container.getDockerlist();


       for (Docker docker : docker_list){
           if(docker.getInfo().getIp().equals(docker_ip)) return docker;
       }
        return null;
    }

    public ConcurrentHashMap<String, Container> getContainers(){
        return this.containerHashMap;
    }

    public void clearAll(){
        this.containerHashMap.clear();
    }


}
