package com.functions.service

import org.springframework.stereotype.Service

@Service
class MyService {
    fun hello(name: String) = "Hello! $name, this service is injected with spring."
}
