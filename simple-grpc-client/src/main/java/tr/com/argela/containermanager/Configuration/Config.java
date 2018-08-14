package tr.com.argela.containermanager.Configuration;

import java.io.FileReader;
import java.util.Properties;

public class Config
{
    public static Properties configReader(){
        Properties properties = new Properties();
        try(FileReader reader = new FileReader("/home/orhan/ApplicationManagerGrpcTest/simple-grpc-client/src/main/resources/app.conf")){
            properties.load(reader);
        }catch (Exception e){
            e.printStackTrace();
        }
    return properties;
    }

}