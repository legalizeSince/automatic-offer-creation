package com.sendMail.mail.repository

import com.sendMail.mail.domain.Pdf
import com.sendMail.mail.domain.PdfSave
import com.sendMail.mail.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface PdfRepository:JpaRepository<PdfSave,UUID> {


}