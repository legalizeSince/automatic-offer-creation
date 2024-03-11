package com.sendMail.mail.domain

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import java.util.UUID


data class Pdf(

    var postalCode:String,
    var cityId_:Int,
    var cityName:String,
    var productCode:String,
    var campaignIdentifier:String,
    var usage:Int,
    var energyType:EnergyTyp,
    var anrede: String,
    var email: String,
    var kundenName: String

)
