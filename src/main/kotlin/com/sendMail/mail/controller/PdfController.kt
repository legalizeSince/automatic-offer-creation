package com.sendMail.mail.controller

import com.sendMail.mail.domain.*
import com.sendMail.mail.service.GeneratePdfService
import com.sendMail.mail.service.SavePdfIntoDatabase
import com.sendMail.mail.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/pdf/generate")
class PdfController(@Autowired val generatePdfService: GeneratePdfService,
    @Autowired val savePdfIntoDatabase: SavePdfIntoDatabase,
    @Autowired val userService: UserService) {



    @PostMapping
    fun generatePdf(@RequestBody brevo: Brevo):Boolean{
        val encodedPdf:ByteArray
        val userFound = userService.getUserByEmail(brevo.email)

        val userToken = userService.findUser(userFound.id!!)

        val success:Boolean
        userToken.let {


            //encodedPdf = generatePdfService.generatePDF(brevo,userToken.token)

          success = generatePdfService.withItext(brevo,userToken.token)
        }



        return success

    }
}