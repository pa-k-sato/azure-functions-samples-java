package com.functions

import com.microsoft.azure.functions.ExecutionContext
import com.microsoft.azure.functions.HttpMethod
import com.microsoft.azure.functions.HttpRequestMessage
import com.microsoft.azure.functions.HttpResponseMessage
import com.microsoft.azure.functions.HttpStatus
import com.microsoft.azure.functions.annotation.AuthorizationLevel
import com.microsoft.azure.functions.annotation.FunctionName
import com.microsoft.azure.functions.annotation.HttpTrigger
import java.util.*

class KtFunction {
    @FunctionName("KtHttpExample")
    fun ktAzure(
        @HttpTrigger(
            name = "req",
            methods = [HttpMethod.GET, HttpMethod.POST],
            authLevel = AuthorizationLevel.ANONYMOUS)
        request: HttpRequestMessage<Optional<String>>,
        context: ExecutionContext
    ): HttpResponseMessage {
        context.logger.info("Kotlin HTTP trigger processed a request.")


        // Parse query parameter
        val query = request.queryParameters["name"]
        val name = request.body.orElse(query)

        return request.createResponseBuilder(HttpStatus.OK).body("Hello, $name. with Kotlin").build()
    }
}
