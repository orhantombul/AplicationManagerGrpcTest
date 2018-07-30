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
import testpythonwithjava.*;

import java.util.ArrayList;
import java.util.List;

public class MyGrpcClient {
  public static void main(String[] args) {

    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5015).usePlaintext(true)
            .build();

    SentServiceStatusGrpc.SentServiceStatusBlockingStub sentServiceStatusBlockingStub =
            SentServiceStatusGrpc.newBlockingStub(channel);

    List<Docker>  dockerList  =new ArrayList<>();
    DockerInfo dockerInfo = DockerInfo.newBuilder().setDockerip("192.168.1.1").setDockerstatus("PASS").build();
    Docker docker = Docker.newBuilder().setDockername("DOCKER1").setDockerinfo(dockerInfo).build();
    dockerList.add(docker);

    Iterable<Docker> dockerIterable = dockerList;
    Container container = Container.newBuilder().addAllDockerlist(dockerIterable).setContainerip("192.168.3.2").build();
    List<Container> containers = new ArrayList<>();
    containers.add(container);
    ContainerList containerList = ContainerList.newBuilder().addAllContainerlist(containers).build();
    System.out.println("sending");

    Response response = sentServiceStatusBlockingStub.contlist(containerList);
    System.out.println(response);
    //ClientCallStreamObserver<Container> containerClientCallStreamObserver =
    //sentServiceStatusBlockingStub.contlist(containers,);

   }
}


