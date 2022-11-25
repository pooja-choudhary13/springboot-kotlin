package bank.controller.model

import bank.repository.model.PaymentDBModel
import java.util.*

class OverviewTransactionModel(
    val targetAccount: String,
    val value: Double,
    val description: String,
    val date: Date,
    val id: String
)

fun PaymentDBModel.convertToOverviewTransactionModel() = OverviewTransactionModel(
    targetAccount = this.accountIdentifier,
    value = this.amount,
    description = this.description,
    date = this.date,
    id = this.txnId.toString()
)