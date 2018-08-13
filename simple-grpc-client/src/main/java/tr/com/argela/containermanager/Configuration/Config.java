package tr.com.argela.containermanager.Configuration;

import java.util.*;
import java.util.Properties;
/*
public class Config
{

    Properties configFile;
    public Config()
    {
        configFile = new java.util.Properties();
        try {
            configFile.load(this.getClass().getClassLoader().
                    getResourceAsStream("/simple-grpc-client/src/test/resources/app.conf"));
        }catch(Exception eta){
            eta.printStackTrace();
        }
    }

    public String getProperty(String key)
    {
        String value = this.configFile.getProperty(key);
        return value;
    }
}

//usage of config
/*      Config config = new Config();
        ApplicationControllerUtil.server_ip_addr=config.getProperty("server_ip_addr");
        ApplicationControllerUtil.server_port_addr = Integer.valueOf(config.getProperty("server_port_addr"));
        ApplicationControllerUtil.firstMailAddr =config.getProperty("firstMailAddr");
*/