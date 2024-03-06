package com.sendMail.mail.domain

import com.fasterxml.jackson.annotation.JsonInclude
import lombok.Data
import lombok.experimental.SuperBuilder
import org.springframework.http.HttpStatus
import java.time.LocalDateTime


data class HttpResponse (
     var timestamp:String?= LocalDateTime.now().toString(),
     var statusCode:Int?=null,
     var status: HttpStatus? = null,
     var message:String?="",
     var developerMessage:String="",
     var path:String="",
     var requestMethod:String = "",
     var daten:Map<Any,Any>

)