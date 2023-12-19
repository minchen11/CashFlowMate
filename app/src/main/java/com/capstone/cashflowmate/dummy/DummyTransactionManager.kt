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

    // Add more methods as needed
}
