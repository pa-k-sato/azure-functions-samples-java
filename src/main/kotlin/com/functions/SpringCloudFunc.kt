package com.functions

import com.functions.model.Greeting
import com.functions.model.User
import com.functions.service.MyService
import com.microsoft.azure.functions.ExecutionContext
import com.microsoft.azure.functions.HttpMethod
import com.microsoft.azure.functions.HttpRequestMessage
import com.microsoft.azure.functions.HttpResponseMessage
import com.microsoft.azure.functions.HttpStatus
import com.microsoft.azure.functions.annotation.AuthorizationLevel
import com.microsoft.azure.functions.annotation.FunctionName
import com.microsoft.azure.functions.annotation.HttpTrigger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.function.adapter.azure.AzureSpringBootHttpRequestHandler
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler
import java.util.*

class SpringCloudFunc: AzureSpringBootRequestHandler<User, Greeting>() {
    @Autowired
    lateinit var myService: MyService

    @FunctionName("hello")
    fun ktAzure(
        @HttpTrigger(
            name = "req",
            methods = [HttpMethod.GET, HttpMethod.POST],
            authLevel = AuthorizationLevel.ANONYMOUS)
        request: HttpRequestMessage<User>,
        context: ExecutionContext
    ): HttpResponseMessage {
        context.logger.info("Spring Cloud Function HTTP trigger processed a request. for ${request.body.name}")
        context.logger.info("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
         context.logger.info(handleRequest(request.body, context).message)
        context.logger.info(myService.hello("oops!")) // Spring Application を Java で書くと AutoWiredもできる。ただし先に↑のhandleRequest を呼ぶ必要あり
        context.logger.info("cccccccccccccccccccccccccccccccccccccccccccccccccc")

        return request
            .createResponseBuilder(HttpStatus.OK)
            .body(handleRequest(request.body, context))
            .header("COntent-Type", "application/json")
            .build()
    }
}
