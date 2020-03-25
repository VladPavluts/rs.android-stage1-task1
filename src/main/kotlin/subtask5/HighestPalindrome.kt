package subtask5

class HighestPalindrome {


    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {

        val list= mutableListOf<Int>()
        val listPair= mutableListOf<Pair<Char,Int>>()
        var countBad=0
        val allList=mutableListOf<Int>()
        for (i in 0..n-1)
            allList.add(digitString[i].toInt())

        for(i in 0 until n/2){
            if(digitString[i]!=digitString[n-i-1]) {
                countBad++
                listPair.add(digitString[i] to i)
                listPair.add(digitString[n-i-1] to n-i-1)
                list.add(digitString[i].toInt())
                list.add(digitString[n-i-1].toInt())
            }
        }
        val max=list.max()

        if (n/2-countBad<=k && n/2-countBad>0){
            for(i in 0 until listPair.size){
                allList[listPair[i].second]=max!!
            }
        }
        else
            return "-1"

        var result=""
        for (i in 0..n-1)
            result+=allList[i].toChar()


        return result
    }
}
