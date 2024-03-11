package com.sendMail.mail.domain

import jakarta.persistence.GeneratedValue
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import java.time.LocalDateTime

data class Brevo(

    @GeneratedValue
    @Temporal(TemporalType.TIMESTAMP)
    var erstelltAm:LocalDateTime?= LocalDateTime.now(),
    var anrede: String,
    var name:String,
    var email:String,
    var workingprice: Number,
    var baseprice:Number,

)
