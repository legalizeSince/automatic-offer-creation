package com.sendMail.mail.service

import com.sendMail.mail.domain.PdfSave
import com.sendMail.mail.repository.PdfRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SavePdfIntoDatabase(@Autowired private val pdfRepository: PdfRepository) {

    fun savePdf(pdfSave: PdfSave):PdfSave{
         val pdf  = pdfRepository.save(pdfSave)
        return pdf
    }
}