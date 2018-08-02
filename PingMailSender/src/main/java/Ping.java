import org.icmp4j.IcmpPingRequest;
import org.icmp4j.IcmpPingResponse;
import org.icmp4j.IcmpPingUtil;


public class Ping implements Runnable{

    private String ipAddress;
    private String[] to;


    public Ping(String ipAddress,String[] to) {
        this.ipAddress = ipAddress;
        this.to=to;
    }

    @Override
    public void run() {

        try {

            final IcmpPingRequest request = IcmpPingUtil.createIcmpPingRequest();
            request.setHost(ipAddress);
            final IcmpPingResponse response = IcmpPingUtil.executePingRequest(request);
            final String formattedResponse = IcmpPingUtil.formatResponse(response);
            System.out.println(formattedResponse);

            boolean controlFlag = response.getSuccessFlag();
            System.out.println(controlFlag);

            if(controlFlag){
                //String[] to = { "canori3414@gmail.com" }; // list of recipient email addresses
                String subject = "Java send mail example";
                String body = "Mission Completed !!!";
                MailService.sendFromGMail("testdeneme2338@gmail.com","Aa123456.",to,subject,body);
                System.out.println("Send Message Successfully");
            }
            else{
                //String[] to = { "canori3414@gmail.com" }; // list of recipient email addresses
                String subject = "Java send mail example";
                String body = "Mission Not Completed !!!";
                MailService.sendFromGMail("testdeneme2338@gmail.com","Aa123456.",to,subject,body);
                System.out.println("Send Error Message ");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}