package com.sendMail.mail.domain

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "pdfs")
data class Pdf(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id:UUID? = UUID.randomUUID(),
    var postalCode:String,
    var cityId:Int,
    var cityName:String,
    var productCode:String,
    var campaignIdentifier:String,
    var usage:Int,
    var energyType:EnergyTyp,
    var kundenName:String


)
