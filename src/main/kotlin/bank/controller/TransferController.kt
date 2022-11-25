package bank.controller

import bank.controller.model.*
import bank.repository.TransferRepository
import bank.repository.model.PaymentDBModel
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/transfer")
class TransferController(val repository: TransferRepository) {

    @PostMapping("/new")
    fun newTransfer(@RequestBody transactionModel: TransactionModel) {
        repository.save(transactionModel.convertToDBModel())
    }

    @GetMapping("/all")
    fun getAllTransfers(): List<OverviewTransactionModel> {
        return repository.findAll().map { it.convertToOverviewTransactionModel() }
    }

    @DeleteMapping("/delete/{id}")
    fun deleteTransaction(@PathVariable("id") txnId: Long){
        repository.deleteById(txnId)
    }

    @PutMapping("/update/{id}")
    fun updateTransaction(@PathVariable("id") txnId: Long, @RequestBody transaction: TransactionModel) {
        if (repository.existsById(txnId)) {
            val updatedTxn = PaymentDBModel(transaction.targetAccount, transaction.value, transaction.description)
            updatedTxn.txnId = txnId
            updatedTxn.date = Date()
            repository.save(updatedTxn)
        }
    }

}