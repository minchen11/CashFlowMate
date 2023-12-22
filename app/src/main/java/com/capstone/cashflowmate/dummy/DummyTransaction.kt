package com.capstone.cashflowmate.dummy

data class DummyTransaction (
    var transactionID: String? =null,
    var type: Int? =null,
    var title: String? =null,
    var category: String? =null,
    var amount: Double? =null,
    var date: Long? =null,
    var note: String? =null,
    var invertedDate: Long?=null
) {
    val id: Any
        get() = transactionID!!
}