package com.sendMail.mail.domain

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import java.sql.Blob
import java.time.LocalDateTime
import java.util.UUID


@Entity
data class PdfSave(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id:UUID? = UUID.randomUUID(),


    var pdf:ByteArray,

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    var createdAt: LocalDateTime? = LocalDateTime.now(),

    @OneToOne(targetEntity = User::class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    var user:User
)
