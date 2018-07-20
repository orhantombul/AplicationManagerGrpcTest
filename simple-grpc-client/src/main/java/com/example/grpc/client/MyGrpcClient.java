/*
 * Copyright 2016 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.grpc.client;


import com.example.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * Created by rayt on 5/16/16.
 */
public class MyGrpcClient {
  public static void main(String[] args) throws InterruptedException {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8082)
        .usePlaintext(true)
        .build();

    GreetingServiceGrpc.GreetingServiceBlockingStub stub =
        GreetingServiceGrpc.newBlockingStub(channel);


    DockerInfo dockerInfo = DockerInfo.newBuilder().setDockerStatus("true").setDockerIp("192.168.18.15").build();
    Docker docker = Docker.newBuilder().setDockerInfo(dockerInfo).setDockerName("Docker1").build();
    Container container = Container.newBuilder()
            .setContainerIp("1.1.1.1").addDockerlist(docker).build();
    ContainerBook helloResponse = stub.greeting(container);

    System.out.println(helloResponse);
    channel.shutdown();
  }
}
