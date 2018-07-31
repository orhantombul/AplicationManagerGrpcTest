package tr.com.argela.containermanager.Model;


import java.util.Objects;

public class Docker {
    private String name;
    private DockerInfo info;

    public Docker(String name, DockerInfo info) {
        this.name = name;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DockerInfo getInfo() {
        return info;
    }

    public void setInfo(DockerInfo info) {
        this.info = info;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Docker docker = (Docker) o;
        return Objects.equals(name, docker.name) && Objects.equals(info, docker.info);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, info);
    }

    @Override
    public String toString() {
        return "Docker{" + "name='" + name + '\'' + ", info=" + info + '}';
    }
}
