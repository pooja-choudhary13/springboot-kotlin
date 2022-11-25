package bank.controller.model

import bank.repository.model.PaymentDBModel

class TransactionModel (
    val targetAccount: String,
    val value: Double,
    val description: String = ""
)

fun TransactionModel.convertToDBModel() = PaymentDBModel(
    accountIdentifier = this.targetAccount,
    amount = this.value,
    description = this.description
)