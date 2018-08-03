package tr.com.argela.containermanager.Edge;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import tr.com.argela.containermanager.Common.ApplicationManager;
import tr.com.argela.containermanager.Controller.ApplicationControllerUtil;
import tr.com.argela.containermanager.Model.Container;
import tr.com.argela.grpcserver.ContainerListRequest;
import tr.com.argela.grpcserver.ContainerListResponse;
import tr.com.argela.grpcserver.SendServiceGrpc;

import java.util.*;

public class GRPCStateNotifier implements Observer {
    ContainerListRequest containerListRequest;
    static GRPCStateNotifier grpcStateNotifier;
    private GRPCStateNotifier()
    {
    }

    public static GRPCStateNotifier getGrpcStateNotifier()
    {
        if(grpcStateNotifier == null)
            grpcStateNotifier = new GRPCStateNotifier();
        return grpcStateNotifier;
    }

    public void startObserving(ApplicationManager applicationManager){
        System.out.println(applicationManager);
        applicationManager.addObserver(grpcStateNotifier);
    }
    public void stopObserving(ApplicationManager applicationManager){
        applicationManager.deleteObserver(grpcStateNotifier);
    }

    @Override
    public void update(Observable observable, Object o) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5016).usePlaintext(true)
                .build();

        SendServiceGrpc.SendServiceBlockingStub sendServiceBlockingStub = SendServiceGrpc.newBlockingStub(channel);

        System.out.println("updating ... ");
        if(!(observable instanceof ApplicationManager)){return;}
        ApplicationManager applicationManager = ApplicationManager.getApplicationManager();
        Map<String, Container> containerMap =applicationManager.getContainers();
        List<tr.com.argela.grpcserver.Container>containerlist = new ArrayList<>();
        for(Container container: containerMap.values()){
            tr.com.argela.grpcserver.Container container1 =ApplicationControllerUtil.getGrpcContainerByControllerContainer(container);
            containerlist.add(container1);
        }
        System.out.println("sending");
        containerListRequest = ContainerListRequest.newBuilder().addAllContainerlist(containerlist).build();
        System.out.println("send");
        ContainerListResponse response = sendServiceBlockingStub.contlist(containerListRequest);
        System.out.println(response);
    }

}
