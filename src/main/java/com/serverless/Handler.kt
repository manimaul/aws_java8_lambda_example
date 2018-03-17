package com.serverless

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.log4j.Logger

private val LOG = Logger.getLogger(Handler::class.java)
private val objectMapper = ObjectMapper()

@Suppress("unused") // lambda function
class Handler : RequestHandler<Map<String, Any>, ApiGatewayResponse> {

    override fun handleRequest(input: Map<String, Any>, context: Context): ApiGatewayResponse {
        LOG.info("received: $input")
        val responseBody = Response("Go Serverless v1.x! Your function executed successfully!", input)
        val body= try {
            objectMapper.writeValueAsString(responseBody)
        } catch (e: JsonProcessingException) {
            null
        }

        return ApiGatewayResponse(200,
                body,
                mapOf("X-Powered-By" to "AWS Lambda & serverless"),
                false)
    }
}
