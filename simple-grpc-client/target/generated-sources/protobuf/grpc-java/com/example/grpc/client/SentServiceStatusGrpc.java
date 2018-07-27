package com.example.grpc.client;

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
public final class SentServiceStatusGrpc {

  private SentServiceStatusGrpc() {}

  public static final String SERVICE_NAME = "com.example.grpc.client.SentServiceStatus";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.client.ContainerList,
      com.example.grpc.client.Response> getContlistMethod;

  public static io.grpc.MethodDescriptor<com.example.grpc.client.ContainerList,
      com.example.grpc.client.Response> getContlistMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.client.ContainerList, com.example.grpc.client.Response> getContlistMethod;
    if ((getContlistMethod = SentServiceStatusGrpc.getContlistMethod) == null) {
      synchronized (SentServiceStatusGrpc.class) {
        if ((getContlistMethod = SentServiceStatusGrpc.getContlistMethod) == null) {
          SentServiceStatusGrpc.getContlistMethod = getContlistMethod = 
              io.grpc.MethodDescriptor.<com.example.grpc.client.ContainerList, com.example.grpc.client.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.example.grpc.client.SentServiceStatus", "contlist"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.client.ContainerList.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.client.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new SentServiceStatusMethodDescriptorSupplier("contlist"))
                  .build();
          }
        }
     }
     return getContlistMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SentServiceStatusStub newStub(io.grpc.Channel channel) {
    return new SentServiceStatusStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SentServiceStatusBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SentServiceStatusBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SentServiceStatusFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SentServiceStatusFutureStub(channel);
  }

  /**
   */
  public static abstract class SentServiceStatusImplBase implements io.grpc.BindableService {

    /**
     */
    public void contlist(com.example.grpc.client.ContainerList request,
        io.grpc.stub.StreamObserver<com.example.grpc.client.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getContlistMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getContlistMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.client.ContainerList,
                com.example.grpc.client.Response>(
                  this, METHODID_CONTLIST)))
          .build();
    }
  }

  /**
   */
  public static final class SentServiceStatusStub extends io.grpc.stub.AbstractStub<SentServiceStatusStub> {
    private SentServiceStatusStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SentServiceStatusStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SentServiceStatusStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SentServiceStatusStub(channel, callOptions);
    }

    /**
     */
    public void contlist(com.example.grpc.client.ContainerList request,
        io.grpc.stub.StreamObserver<com.example.grpc.client.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getContlistMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SentServiceStatusBlockingStub extends io.grpc.stub.AbstractStub<SentServiceStatusBlockingStub> {
    private SentServiceStatusBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SentServiceStatusBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SentServiceStatusBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SentServiceStatusBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.grpc.client.Response contlist(com.example.grpc.client.ContainerList request) {
      return blockingUnaryCall(
          getChannel(), getContlistMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SentServiceStatusFutureStub extends io.grpc.stub.AbstractStub<SentServiceStatusFutureStub> {
    private SentServiceStatusFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SentServiceStatusFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SentServiceStatusFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SentServiceStatusFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.client.Response> contlist(
        com.example.grpc.client.ContainerList request) {
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
    private final SentServiceStatusImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SentServiceStatusImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CONTLIST:
          serviceImpl.contlist((com.example.grpc.client.ContainerList) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.client.Response>) responseObserver);
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

  private static abstract class SentServiceStatusBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SentServiceStatusBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.client.ContainerServer.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SentServiceStatus");
    }
  }

  private static final class SentServiceStatusFileDescriptorSupplier
      extends SentServiceStatusBaseDescriptorSupplier {
    SentServiceStatusFileDescriptorSupplier() {}
  }

  private static final class SentServiceStatusMethodDescriptorSupplier
      extends SentServiceStatusBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SentServiceStatusMethodDescriptorSupplier(String methodName) {
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
      synchronized (SentServiceStatusGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SentServiceStatusFileDescriptorSupplier())
              .addMethod(getContlistMethod())
              .build();
        }
      }
    }
    return result;
  }
}
