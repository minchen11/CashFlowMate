import com.capstone.cashflowmate.dummy.DummyTransaction

// DummyTransactionManager.kt

object DummyTransactionManager {
    val dummyTransactionList: MutableList<DummyTransaction> = mutableListOf()

    init {
        // Initialize dummy transactions
        dummyTransactionList.apply {
            add(DummyTransaction("1", 1, "Expense 1", "Food", 10.0, System.currentTimeMillis(), "Lunch"))
            add(DummyTransaction("2", 2, "Income 1", "Salary", 1000.0, System.currentTimeMillis(), "Monthly salary"))
            add(DummyTransaction("3", 1, "Expense 2", "Transportation", 20.0, System.currentTimeMillis(), "Bus fare"))
        }
    }

    fun clearTransactions() {
        dummyTransactionList.clear()
    }

    fun addTransaction(
        type: Int,
        title: String,
        category: String,
        amount: Double,
        date: Long,
        note: String
    ) {
        val id = (dummyTransactionList.size + 1).toString()
        val iconCode = if (type == 1) 1 else 2
        dummyTransactionList.add(DummyTransaction(id, iconCode, title, category, amount, date, note))
    }

    fun getTransaction(id: String): DummyTransaction? {
        return dummyTransactionList.find { it.id == id }
    }

    fun child(transactionID: Any): Any {
        return transactionID

    }
}
