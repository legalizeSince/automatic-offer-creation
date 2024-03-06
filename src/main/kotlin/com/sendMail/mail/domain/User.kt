package com.sendMail.mail.domain

import jakarta.persistence.*
import java.util.*



@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:UUID? = UUID.randomUUID(),
    var name:String,
    var email:String,
    var info:EnergyTyp,
    var isEnabled:Boolean
)
