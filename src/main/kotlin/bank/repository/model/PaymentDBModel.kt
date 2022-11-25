package bank.repository.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class PaymentDBModel(
    val accountIdentifier: String,
    val amount: Double,
    val description: String = "",
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var txnId: Long ? = null

    var date: Date = Date()
}