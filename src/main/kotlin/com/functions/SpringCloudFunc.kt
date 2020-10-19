package com.functions

import com.functions.model.Greeting
import com.functions.model.User
import com.microsoft.azure.functions.ExecutionContext
import com.microsoft.azure.functions.HttpMethod
import com.microsoft.azure.functions.HttpRequestMessage
import com.microsoft.azure.functions.HttpResponseMessage
import com.microsoft.azure.functions.HttpStatus
import com.microsoft.azure.functions.annotation.AuthorizationLevel
import com.microsoft.azure.functions.annotation.FunctionName
import com.microsoft.azure.functions.annotation.HttpTrigger
import org.springframework.cloud.function.adapter.azure.AzureSpringBootHttpRequestHandler
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler
import java.util.*

class SpringCloudFunc: AzureSpringBootRequestHandler<User, Greeting>() {
    @FunctionName("hello")
    fun ktAzure(
        @HttpTrigger(
            name = "req",
            methods = [HttpMethod.GET, HttpMethod.POST],
            authLevel = AuthorizationLevel.ANONYMOUS)
        request: HttpRequestMessage<Optional<User>>,
        context: ExecutionContext
    ): HttpResponseMessage {
        context.logger.info("Spring Cloud Function HTTP trigger processed a request.")


        return request
            .createResponseBuilder(HttpStatus.OK)
            .body(handleRequest(request.body.get(), context))
            .header("COntent-Type", "application/json")
            .build()
    }
}
