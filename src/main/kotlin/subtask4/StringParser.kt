package subtask4


class StringParser {

    fun getResult(inputString: String): Array<String> {

        val ans1 = mutableListOf<Pair<Char, Int>>()
        val ans2 = mutableListOf<Pair<Char, Int>>()
        for (i in 0..inputString.length-1)
            if (inputString[i] == '<' || inputString[i] == '[' || inputString[i] == '(' ||
                inputString[i] == '>' || inputString[i] == ']' || inputString[i] == ')')
                ans1.add(inputString[i] to i)

        val openOnly=ans1.filter { isOpen(it.first) }
        val result = MutableList(openOnly.size){""}
        for (i in 0..ans1.size-1){
            if(isOpen(ans1[i].first)){
                ans2.add(ans1[i])
            }
            if (isClosed(ans1[i].first)){
                var j=ans2.size-1
                while (j >=0){
                    if(ans2[j].first==convert(ans1[i].first)){
                        val index=openOnly.indexOfFirst { it.second==ans2[j].second }
                        result[index]=(inputString.slice(ans2[j].second+1..ans1[i].second-1))
                        ans2.removeAt(j)
                        break
                    }
                    j--
                }
            }
        }

        return result.toTypedArray()
    }
    private fun convert(c: Char): Char {
        return when (c) {
            '>' -> '<'
            ')' -> '('
            ']' -> '['
            else -> '-'
        }
    }
    private fun isOpen(c: Char):Boolean{
        return '('== c || '[' == c || '<' == c
    }
    private fun isClosed(c: Char):Boolean{
        return ')'== c || ']' == c || '>' == c
    }
}