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

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import tr.com.argela.grpcserver.*;

import java.util.ArrayList;
import java.util.List;

public class GrpcClient {
  public static void main(String[] args) {

   ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5015).usePlaintext(true)
            .build();

    SendServiceGrpc.SendServiceBlockingStub sendServiceBlockingStub =
            SendServiceGrpc.newBlockingStub(channel);

    List<Docker>  dockerList  =new ArrayList<>();
    DockerInfo dockerInfo = DockerInfo.newBuilder().setIp("192.168.1.2").setStatus("PASS").build();
    Docker docker = Docker.newBuilder().setName("DOCKER1").setInfo(dockerInfo).build();
    dockerList.add(docker);

    Iterable<Docker> dockerIterable = dockerList;
    Container container = Container.newBuilder().addAllDockerlist(dockerIterable).setIp("192.168.3.3").build();
    List<Container> containers = new ArrayList<>();
    containers.add(container);
    ContainerListRequest containerList = ContainerListRequest.newBuilder().addAllContainerlist(containers).build();
    System.out.println("sending");




   }
}


