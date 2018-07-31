package tr.com.argela.containermanager.Model;

import java.util.Objects;

public class DockerInfo {
    private String ip;
    private String status;


    public DockerInfo() {
    }

    public String getIp() {
        return ip;

    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DockerInfo that = (DockerInfo) o;
        return Objects.equals(ip, that.ip) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ip, status);
    }

    @Override
    public String toString() {
        return "DockerInfo{" + "ip='" + ip + '\'' + ", status='" + status + '\'' + '}';
    }
}

