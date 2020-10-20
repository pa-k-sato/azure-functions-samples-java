package com.functions

import com.functions.service.MyService
import com.microsoft.azure.functions.ExecutionContext
import com.microsoft.azure.functions.annotation.FunctionName
import com.microsoft.azure.functions.annotation.TimerTrigger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler

class SpringCloudFuncTimerTrigger: AzureSpringBootRequestHandler<Void, String>() {
    @Autowired
    lateinit var myService: MyService

    @FunctionName("scfTimer")
    fun test(
        @TimerTrigger(name = "keepAliveTrigger", schedule = "0 */1 * * * *") timerInfo: String,
        context: ExecutionContext
    ) {
        context.logger.info("Timer is triggered: $timerInfo" )
        val ret = handleRequest(context)
        context.logger.info("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
        context.logger.info(ret)
         context.logger.info(myService.hello("Good Timer!"))
    }
}
