package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {
        val happyArray=sadArray.toMutableList()
        if(happyArray.size<3)
            return happyArray.toIntArray()
        while(true){
            if(isHappy(happyArray))
                return happyArray.toIntArray()
            else
                done(happyArray)
        }
        return happyArray.toIntArray()
    }

    private fun isHappy(sadArray: MutableList<Int>):Boolean{
        for(i in 1..sadArray.size-2){
            val sum=sadArray[i-1]+sadArray[i+1]
            if(sum<sadArray[i])
                return false
        }
        return true
    }
    private fun done(sadArray: MutableList<Int>){
            for(i in 1..sadArray.size-2){
                val sum=sadArray[i-1]+sadArray[i+1]
                if(sum<sadArray[i]){
                    sadArray.removeAt(i)
                    break
                }
            }
    }

}
