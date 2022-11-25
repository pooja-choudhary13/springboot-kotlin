package bank.repository

import bank.repository.model.PaymentDBModel
import org.springframework.data.repository.CrudRepository
import java.util.*

interface TransferRepository: CrudRepository<PaymentDBModel, Long> {
}