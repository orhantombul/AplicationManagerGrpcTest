package tr.com.argela.containermanager.Common;

import tr.com.argela.containermanager.Controller.ApplicationControllerUtil;
import tr.com.argela.containermanager.Model.Container;
import tr.com.argela.containermanager.Model.Docker;
import tr.com.argela.containermanager.Notifier.MailService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;

import static tr.com.argela.containermanager.Controller.ApplicationControllerUtil.firstMailAddr;
import static tr.com.argela.containermanager.Controller.ApplicationControllerUtil.secondMailAddr;


public class ApplicationManager extends Observable {
    private final Map<String, Container> containerHashMap = new ConcurrentHashMap<String, Container>();
    private static final ApplicationManager applicationManager= new ApplicationManager();

    private ApplicationManager() {
    }

    public static ApplicationManager getApplicationManager() {
        return applicationManager;
    }


    /**
     * sets the container
     * @param ip
     * @param container
     */
    public void setContainer(String ip,Container container){
        if(ip == null || container == null) {
            return;
        }
        this.containerHashMap.put(ip,container);
    }

    /**
     *
     * @param ip
     * @return the container which has  same ip as @{param: ip}
     */
    public Container getContainer(String ip){
        if(ip == null ) {
            return null;
        }
      return this.containerHashMap.get(ip);
    }

    private Container createDockerWithContainerIp(String ip){
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

    public void notifyViaMail(String containerIp,Docker docker)
    {
        String[] mailAddresses={firstMailAddr, secondMailAddr};

        String body = "Machine is  "+ containerIp + ApplicationControllerUtil.NEW_LINE + "Module is "+ docker;
        String subject = "MODULE IS DOWN";
        MailService.sendFromGMail("testdeneme2338@gmail.com","Aa123456.",mailAddresses,subject,body);
        System.out.println("mail sent");
    }

    /**
     * add container ip according to given ip and docker
     * @param ip of container
     * @param docker which will be add to container
     */
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
        for(Docker oldDocker : docker_list) {
            if (oldDocker.equals(docker)){
             return;
            }
            else if( docker.getInfo().getIp().equals(oldDocker.getInfo().getIp()) &&
                    docker.getInfo().getStatus().equals("FAIL") &&
                    oldDocker.getInfo().getStatus().equals("PASS"))
                notifyViaMail(ip,oldDocker);
        }
        docker_list.add(docker);
        notifyGRPC();
    }

    /**
     * fetches the docker according to its container ip and docker ip
     * @param container_ip of the docker
     * @param docker_ip of the docker
     * @return docker
     */
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

    /**
     * @return all the containers
     */
    public Map<String, Container> getContainers(){
        return containerHashMap;
    }

    /**
     * clear all the containers
     */
    public void clearAll(){
        this.containerHashMap.clear();
    }



    private void notifyGRPC()
    {
        setChanged();
        notifyObservers();
        clearChanged();
    }

}
