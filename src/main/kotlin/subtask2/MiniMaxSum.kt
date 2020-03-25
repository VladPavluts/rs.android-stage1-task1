package subtask2



class MiniMaxSum {

    fun getResult(input: IntArray): IntArray {

        input.sort()
        var sum=0
        for(i in 0..input.size-2){
            sum+=input[i]
        }
        val min=sum
        sum=0
        for(i in 1..input.size-1){
            sum+=input[i]
        }
        val max=sum
        val result=mutableListOf<Int>()
        result.add(min)
        result.add(max)

        return result.toIntArray()
    }
}
