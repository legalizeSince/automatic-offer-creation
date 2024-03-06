package com.sendMail.mail.repository

import com.sendMail.mail.domain.Confirmation
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ConfirmationRespository:JpaRepository<Confirmation, UUID> {

    fun findByToken(token:String):Confirmation
}