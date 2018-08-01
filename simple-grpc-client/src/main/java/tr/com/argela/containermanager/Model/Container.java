package tr.com.argela.containermanager.Model;

import java.util.List;
import java.util.Objects;


public class Container {
    private String ip;
    private List<Docker> dockerlist;

    public Container(String ip, List dockerlist) {
        this.ip = ip;
        this.dockerlist = dockerlist;
    }

    public Container() {
        return;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public List getDockerlist() {
        return dockerlist;
    }

    public void setDockerlist(List dockerlist) {
        this.dockerlist = dockerlist;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Container container = (Container) o;
        return Objects.equals(ip, container.ip) && Objects.equals(dockerlist, container.dockerlist);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ip, dockerlist);
    }

    @Override
    public String toString() {
        return "Container{" + "ip='" + ip + '\'' + ", dockerlist=" + dockerlist + '}';
    }
}