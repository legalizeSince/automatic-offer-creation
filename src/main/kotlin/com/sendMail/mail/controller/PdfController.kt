package com.sendMail.mail.controller

import com.sendMail.mail.domain.Pdf
import com.sendMail.mail.service.GeneratePdfService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/pdf/generate")
class PdfController(@Autowired val generatePdfService: GeneratePdfService) {



    @PostMapping
    fun generatePdf(@RequestBody pdf: Pdf){

        pdf.let {
            generatePdfService.generatePDF(it)
        }



    }
}