package tr.com.argela.grpcserver;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.13.1)",
    comments = "Source: ContainerServer.proto")
public final class SendServiceGrpc {

  private SendServiceGrpc() {}

  public static final String SERVICE_NAME = "tr.com.argela.grpcserver.SendService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<tr.com.argela.grpcserver.ContainerListRequest,
      tr.com.argela.grpcserver.ContainerListResponse> getContlistMethod;

  public static io.grpc.MethodDescriptor<tr.com.argela.grpcserver.ContainerListRequest,
      tr.com.argela.grpcserver.ContainerListResponse> getContlistMethod() {
    io.grpc.MethodDescriptor<tr.com.argela.grpcserver.ContainerListRequest, tr.com.argela.grpcserver.ContainerListResponse> getContlistMethod;
    if ((getContlistMethod = SendServiceGrpc.getContlistMethod) == null) {
      synchronized (SendServiceGrpc.class) {
        if ((getContlistMethod = SendServiceGrpc.getContlistMethod) == null) {
          SendServiceGrpc.getContlistMethod = getContlistMethod = 
              io.grpc.MethodDescriptor.<tr.com.argela.grpcserver.ContainerListRequest, tr.com.argela.grpcserver.ContainerListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "tr.com.argela.grpcserver.SendService", "contlist"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  tr.com.argela.grpcserver.ContainerListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  tr.com.argela.grpcserver.ContainerListResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SendServiceMethodDescriptorSupplier("contlist"))
                  .build();
          }
        }
     }
     return getContlistMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SendServiceStub newStub(io.grpc.Channel channel) {
    return new SendServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SendServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SendServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SendServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SendServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class SendServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void contlist(tr.com.argela.grpcserver.ContainerListRequest request,
        io.grpc.stub.StreamObserver<tr.com.argela.grpcserver.ContainerListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getContlistMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getContlistMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                tr.com.argela.grpcserver.ContainerListRequest,
                tr.com.argela.grpcserver.ContainerListResponse>(
                  this, METHODID_CONTLIST)))
          .build();
    }
  }

  /**
   */
  public static final class SendServiceStub extends io.grpc.stub.AbstractStub<SendServiceStub> {
    private SendServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SendServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SendServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SendServiceStub(channel, callOptions);
    }

    /**
     */
    public void contlist(tr.com.argela.grpcserver.ContainerListRequest request,
        io.grpc.stub.StreamObserver<tr.com.argela.grpcserver.ContainerListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getContlistMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SendServiceBlockingStub extends io.grpc.stub.AbstractStub<SendServiceBlockingStub> {
    private SendServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SendServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SendServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SendServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public tr.com.argela.grpcserver.ContainerListResponse contlist(tr.com.argela.grpcserver.ContainerListRequest request) {
      return blockingUnaryCall(
          getChannel(), getContlistMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SendServiceFutureStub extends io.grpc.stub.AbstractStub<SendServiceFutureStub> {
    private SendServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SendServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SendServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SendServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<tr.com.argela.grpcserver.ContainerListResponse> contlist(
        tr.com.argela.grpcserver.ContainerListRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getContlistMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CONTLIST = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SendServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SendServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CONTLIST:
          serviceImpl.contlist((tr.com.argela.grpcserver.ContainerListRequest) request,
              (io.grpc.stub.StreamObserver<tr.com.argela.grpcserver.ContainerListResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SendServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SendServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return tr.com.argela.grpcserver.ContainerServer.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SendService");
    }
  }

  private static final class SendServiceFileDescriptorSupplier
      extends SendServiceBaseDescriptorSupplier {
    SendServiceFileDescriptorSupplier() {}
  }

  private static final class SendServiceMethodDescriptorSupplier
      extends SendServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SendServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SendServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SendServiceFileDescriptorSupplier())
              .addMethod(getContlistMethod())
              .build();
        }
      }
    }
    return result;
  }
}
