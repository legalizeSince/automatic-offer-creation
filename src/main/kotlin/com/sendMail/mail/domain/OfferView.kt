package de.stromee.microservice.offer

import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import java.util.*

class OfferView(
    val id: UUID,
    val createdAt: LocalDateTime,

    val postalCode: String,
    val cityId: String,
    val cityName: String,
    val productCode: String,
    val campaignIdentifier: String,
    val usage: String,
    val energyType: String
)