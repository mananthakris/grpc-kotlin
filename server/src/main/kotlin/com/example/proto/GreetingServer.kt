package com.example.proto

import io.grpc.Server
import io.grpc.ServerBuilder

class GreetingServer {
    fun main(args: Array<String>){
        println("Greeting Server")
        val server: Server = ServerBuilder.forPort(50051).build()
        server.start()
        println("Greeting Server started")
        server.awaitTermination()

        Runtime.getRuntime().addShutdownHook(Thread {
            println("Received Shutdown signal")
            server.shutdown()
            println("Greeting Server shutdown")
        }
        )
    }


}
