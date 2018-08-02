import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PingSender {

    private ScheduledExecutorService scheduledExecutorService;
    private int limit;
    private int period;

    public PingSender(int limit, int period) {
        this.limit=limit;
        this.period=period;

        scheduledExecutorService = new ScheduledThreadPoolExecutor(1);
    }

    public static void addOrUpdatePing(PingSender ipAddress) {

    }

    public static void removePing(String ipAddress) {

    }


    public void CreateTimer(Ping ping){
        final ScheduledFuture pingHandle = scheduledExecutorService.scheduleAtFixedRate(ping,1,period,TimeUnit.SECONDS);

        scheduledExecutorService.schedule(new Runnable() {
            public void run() {

                pingHandle.cancel(true);

                scheduledExecutorService.shutdown();
            }},period*(limit),TimeUnit.SECONDS);
    }

}
