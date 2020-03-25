package subtask3

class BillCounter {
    private val fairlySplit = "bon appetit"
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        val result=bill.toMutableList()
        result.removeAt(k)
        val resSum=result.sum()
        val ans=b-resSum/2
        return if(ans==0)
                fairlySplit
            else
                return ans.toString()

    }
}
