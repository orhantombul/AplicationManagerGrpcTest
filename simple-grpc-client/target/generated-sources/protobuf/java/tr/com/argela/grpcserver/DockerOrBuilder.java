// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ContainerServer.proto

package tr.com.argela.grpcserver;

public interface DockerOrBuilder extends
    // @@protoc_insertion_point(interface_extends:tr.com.argela.grpcserver.Docker)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string name = 1;</code>
   */
  java.lang.String getName();
  /**
   * <code>string name = 1;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>.tr.com.argela.grpcserver.DockerInfo info = 2;</code>
   */
  boolean hasInfo();
  /**
   * <code>.tr.com.argela.grpcserver.DockerInfo info = 2;</code>
   */
  tr.com.argela.grpcserver.DockerInfo getInfo();
  /**
   * <code>.tr.com.argela.grpcserver.DockerInfo info = 2;</code>
   */
  tr.com.argela.grpcserver.DockerInfoOrBuilder getInfoOrBuilder();
}