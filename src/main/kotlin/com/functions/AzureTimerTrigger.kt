package com.functions

import com.microsoft.azure.functions.ExecutionContext
import com.microsoft.azure.functions.annotation.FunctionName
import com.microsoft.azure.functions.annotation.TimerTrigger

class AzureTimerTrigger {
    @FunctionName("keepAlive")
    fun test(
        @TimerTrigger(name = "keepAliveTrigger", schedule = "0 */1 * * * *") timerInfo: String,
        context: ExecutionContext
    ) {
        context.logger.info("Timer is triggered: $timerInfo" )
    }
}
