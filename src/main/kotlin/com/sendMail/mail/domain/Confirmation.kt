package com.sendMail.mail.domain

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import lombok.experimental.SuperBuilder
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import java.util.*



@Entity
@Table(name = "confirmation")
data class Confirmation(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID = UUID.randomUUID(),
    var token:String = UUID.randomUUID().toString(),

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @OneToOne(targetEntity = User::class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    var user:User

)

