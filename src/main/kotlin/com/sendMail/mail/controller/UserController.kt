package com.sendMail.mail.controller

import com.sendMail.mail.domain.HttpResponse
import com.sendMail.mail.domain.User
import com.sendMail.mail.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/users")
class UserController(@Autowired val userService: UserService) {

    @PostMapping
    fun createUser(@RequestBody user:User):  ResponseEntity<HttpResponse>{

        val newUser = userService.saveUser(user)

        val response = HttpResponse(
            timestamp = LocalDateTime.now().toString(),
            daten = mapOf("user" to newUser),
            message = "User created",
            status = HttpStatus.CREATED,

            statusCode = HttpStatus.CREATED.value(),
        )


        return ResponseEntity.created(URI.create(""))
            .body(response)
    }



    @GetMapping
    fun confirmNewUserAccount(@RequestParam token:String):ResponseEntity<HttpResponse>{

        val user = userService.verifyToken(token)

        val response =  HttpResponse(
            timestamp = LocalDateTime.now().toString(),
            daten = mapOf("User" to user),
            message = "Account verified!",
            status = HttpStatus.OK,
            statusCode = HttpStatus.OK.value())

        return ResponseEntity.ok().body(response)

    }
}