package br.com.zup.ot2

import com.google.protobuf.Timestamp
import io.grpc.ServerBuilder
import io.grpc.stub.StreamObserver
import java.time.LocalDateTime
import java.time.ZoneId

fun main(){

    val server = ServerBuilder
        .forPort(50051)
        .addService(EmployeeEndpoint())
        .build()

    server.start()

    server.awaitTermination()

}

class EmployeeEndpoint : EmployeeServiceGrpc.EmployeeServiceImplBase(){
    override fun add(request: EmployeeRequest?, responseObserver: StreamObserver<EmployeeResponse>?) {

        val instant = LocalDateTime.now().atZone(ZoneId.of("UTC")).toInstant()


        val response = EmployeeResponse.newBuilder()
            .setName(request?.name)
            .setCreatedAt(Timestamp.newBuilder().setSeconds(instant.epochSecond))
            .build()

        responseObserver?.onNext(response)
        responseObserver?.onCompleted()
    }
}