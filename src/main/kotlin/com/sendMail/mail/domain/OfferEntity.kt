package de.stromee.microservice.offer

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import java.util.*

@Entity
class OfferEntity {
    @Id
    @GeneratedValue
    lateinit var id: UUID

    @CreationTimestamp
    lateinit var createdAt: LocalDateTime

    lateinit var postalCode: String
    lateinit var cityId: String
    lateinit var cityName: String
    lateinit var productCode: String
    lateinit var campaignIdentifier: String
    lateinit var usage: String
    lateinit var energyType: String

    fun toOfferView(): OfferView = OfferView(this.id, this.createdAt, this.postalCode, this.cityId, this.cityName, this.productCode, this.campaignIdentifier, this.usage, this.energyType)


    companion object {

    }
}