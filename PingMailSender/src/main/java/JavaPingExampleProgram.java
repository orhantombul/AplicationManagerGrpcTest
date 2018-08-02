public class JavaPingExampleProgram
{
    public static void main(String args[])
         //   throws IOException
    {
            String ipAddress = "8.8.8.8";
            Ping ping = new Ping(ipAddress, new String[]{"canori3414@gmail.com"});
            PingSender pingSender = new PingSender(2,4);
            pingSender.CreateTimer(ping);
            ping.run();
    }
}