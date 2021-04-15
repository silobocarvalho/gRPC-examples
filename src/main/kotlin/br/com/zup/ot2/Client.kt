package br.com.zup.ot2

import io.grpc.ManagedChannelBuilder

fun main(){

    val channel = ManagedChannelBuilder
                    .forAddress("localhost", 50051)
                    .usePlaintext()
                    .build()

    val request = EmployeeRequest.newBuilder()
        .setName("Sidartha")
        .setActive(true)
        .setRole(Role.DEV)
        .setCpf("12345678909")
        .setSalary(2500.00)
        .addAddress(EmployeeRequest.Address.newBuilder()
            .setStreet("Zupper street")
            .setZipcode("63907-004")
            .build()
        ).build()

    val client = EmployeeServiceGrpc.newBlockingStub(channel)

    val response = client.add(request)

    println(response)
}