package com.sendMail.mail.repository

import com.sendMail.mail.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository:JpaRepository<User, UUID> {

   fun findByEmailIgnoreCase(email:String):User
   fun existsByEmail(email: String):Boolean
}