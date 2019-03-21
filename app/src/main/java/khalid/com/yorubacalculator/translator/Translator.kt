package khalid.com.yorubacalculator.translator

import android.util.Log
/**
 * Created by ${KhalidToak} on 3/6/2019.
 */
object Translator {
    private fun translateNumbersOneToNine(operatorOrNo : Int)  : String{
        return when(operatorOrNo){
            1 -> "ọ̀kan"
            2 -> "eéji"
            3 -> "ẹẹ́ta"
            4 -> "ẹẹ́rin"
            5 -> "aárùn"
            6 -> "ẹẹ́fà"
            7 -> "eéje"
            8 -> "ẹẹ́jọ"
            9->  "ẹẹ́sàn"
            else -> "Invalid number"
        }
    }
    private fun translateElevenToNinetyNine(operatorOrNo: Int, prefix: String) : String{
        return when(operatorOrNo){
            in 11..14 -> prefix + "lá"
            10,20,30,40,50,60,70,80,90 -> translate10To90(operatorOrNo)
            15, 25 -> "ẹ́ẹd$prefix" //prefix is now a suffix here
            in 16..19 -> prefix + "dílógún"
            in 21..24 -> prefix + "lelogun"
            in 26..29-> prefix + "dinlọgbọn"
            in 31..35-> prefix+ "lelọgbọn"
            in 35..39-> prefix+ "dinlogoji"
            in 41..44 -> prefix + "lelogoji"
            in 45..49 -> prefix + "dinladọta"
            in 51..54 -> prefix + "leladọta"
            in 55..59 -> prefix + "dinlọgọta"
            in 61..64 -> prefix + "lelọgọta"
            in 65..69 -> prefix + "leladọrin"
            in 71..74 -> prefix + "leladọrin"
            in 75..79 -> prefix + "dilọgọrin"
            in 81..84 -> prefix + "lelọgọrin"
            in 85..89 -> prefix + "diladọrun"
            in 91..94 -> prefix+ "leladọrun"
            in 95..99  -> prefix + "dilọgọrun"
            else -> "Invaid String or number"
        }
    }
    private fun translate100to2000(operatorOrNo: Int) : String{
        return when(operatorOrNo){
            in 100..999-> translate100to999(operatorOrNo)
            1000 -> "ẹgbẹ̀rún"
            in 1000..1099 -> "ẹgbẹ̀rún ó lé " + translate1000To1099(operatorOrNo)
            1100 -> "Ẹgbẹrunlelọgọrun"
            in 1101..1199 -> "ẹgbẹ̀rún ó lé"+ translate100to999(getThelast3digitsOfA4digitNumber(operatorOrNo))
            1200 -> "ẹgbẹ̀fà"
            in 1201..1299 -> translate4digitNos(operatorOrNo , "ẹgbẹ̀fà ó lé")
            1300 -> "Ẹdẹgbeje"
            in 1301..1399->  translate4digitNos(operatorOrNo , "ẹ̀ẹ̀dẹ́gbèje ó lé" )
            1400 -> "egbèje"
            in 1401..1499 ->  translate4digitNos(operatorOrNo , "egbèje ó lé" )
            1500 -> "ẹ̀ẹ̀dẹ́gbẹ̀jọ"
            in 1501..1599 -> translate4digitNos(operatorOrNo,"ẹ̀ẹ̀dẹ́gbẹ̀jọ ó lé"  )
            1600 -> "ẹgbẹ̀jọ"
            in 1601..1699 ->   translate4digitNos(operatorOrNo, "ẹgbẹ̀jọ ó lé")
            1700 -> "Ẹdẹgbẹsan"
            in 1701..1799 ->  translate4digitNos(operatorOrNo, "ẹ̀ẹ̀dẹ́gbẹ̀sán ó lé" )
            1800 -> "ẹgbẹ̀sàn"
            in 1801..1899-> translate4digitNos(operatorOrNo, "ẹgbẹ̀sàn ó lé" )
            1900 -> "ẹ̀ẹ̀dẹ́gbàà"
            in 1901..1999 -> translate4digitNos(operatorOrNo,  "ẹ̀ẹ̀dẹ́gbàà ó lé" )

            2000 -> "ẹgbẹ̀wá"
            else -> "Invalid number passed"
        }
    }
    private fun getTranslationFor120To180(no : Int) : String{
        val suffix = no/20
        val suffixTranslation = translateNumbersOneToNine(suffix)
        return if (suffix == 7) "Ogo" + suffixTranslation.removePrefix("eé") else
            "Ọgọ" + suffixTranslation.removePrefix("ẹẹ́")
    }
    private fun translate101To199(no:Int) : String {
       return when(no){
           in 101..109 -> " ọgọ́rún ó lé" + translateNumbersOneToNine(getLastDigitOfA2DigitNo(no))
           120, 140, 160, 180 -> getTranslationFor120To180(no)
           in 111..114 -> translateSomeComplexOnes(no,"àádọ́fà")
           in 115..119 -> translateSomeComplexOnes(no, getTranslationFor120To180(120))
           in 121..124 -> translateSomeComplexOnes(no, getTranslationFor120To180(120))
           in 125..129  -> translateSomeComplexOnes(no, "àádóje")
           in 131..134 -> translateSomeComplexOnes(no, "àádóje")
           in 135..139 ->  translateSomeComplexOnes(no, getTranslationFor120To180(140))
           in 141..144 -> translateSomeComplexOnes(no, getTranslationFor120To180(140))
           in 144..149 ->  translateSomeComplexOnes(no, "àádọ́jọ")
           in 151..154 -> translateSomeComplexOnes(no, "àádọ́jọ")
           in 155..159 -> translateSomeComplexOnes(no, getTranslationFor120To180(160))
           in 161..164 -> translateSomeComplexOnes(no, getTranslationFor120To180(160))
           in 165..169 -> translateSomeComplexOnes(no, "àádọ́sán")
           in 171..174 -> translateSomeComplexOnes(no, "àádọ́sán")
           in 175..179 -> translateSomeComplexOnes(no, getTranslationFor120To180(180))
           in 181..189 -> translateSomeComplexOnes(no, getTranslationFor120To180(180))
           in 191..194-> translateSomeComplexOnes(no, "ààdọ́wá")
           in 195..199 -> translateSomeComplexOnes(no, "rúgba")
           110 -> "àádọ́fà"
           130 -> "àádóje"
           150 -> "àádọ́jọ"
           170 -> "àádọ́sán"
           190 -> "ààdọ́wá"
           else -> "Invalid number passed"
       }
    }
    private fun translateNumbersbetweenRounded(no: Int): String{
        val numToArray = no.toString().map { it.toString().toInt() }.toIntArray()
        return if (numToArray[1]==0)  translateNumbersOneToNine(numToArray[2])
        else translateElevenToNinetyNine("${numToArray[1]}${numToArray[2]}".toInt(), getPrifixForTwoDigitNo(
            (numToArray[1].toDouble() * Math.pow(10.0, Math.log10(numToArray[2].toDouble()) + 1)
                    + numToArray[2]).toInt()))
    }
    private fun translate10To90(no: Int)  : String{
        return when(no){
            10 -> "ẹẹ́wà"
            20 -> "ogún"
            30 -> "ọgbọ̀n"
            40 -> "ogójì"
            50 -> "àádọ́ta"
            60 -> "ọgọ́ta"
            70 -> "àádọ́rin"
            80 -> "ọgọ́rin"
            90 -> "Adọrun"
            else -> "Invalid number passed"
        }
    }
    private fun translate100to999(operatorOrNo: Int) : String{
        return when(operatorOrNo){
            100 -> "Ọgọrun"
            in 101..199 -> translate101To199(operatorOrNo)
            200 -> "Igba"
            in 201..299 -> "Igba ó lé "+ translateNumbersbetweenRounded(operatorOrNo)
            300 -> "ọ̀ọ́dúrún"
            in 301..399 -> "ọ̀ọ́dúrún ó lé " + translateNumbersbetweenRounded(operatorOrNo)
            400 -> "irinwó"
            in 401..499 -> "irinwó ó lé " + translateNumbersbetweenRounded(operatorOrNo)
            500 -> "ẹ̀ẹ́dẹ́gbẹ̀ta"
            in 501..599 ->  "ẹ̀ẹ́dẹ́gbẹ̀ta ó lé " + translateNumbersbetweenRounded(operatorOrNo)
            600 -> "ẹgbẹ̀ta"
            in 601..699 -> "ẹgbẹ̀ta ó lé " + translateNumbersbetweenRounded(operatorOrNo)
            700 -> "ẹ̀ẹ́dẹ́gbẹ̀rin"
            in 701..799 -> "ẹ̀ẹ́dẹ́gbẹ̀rin ó lé " + translateNumbersbetweenRounded(operatorOrNo)
            800 -> "ẹgbẹ̀rin"
            in 801..899 -> "ẹgbẹ̀rin ó lé " + translateNumbersbetweenRounded(operatorOrNo)
            900 -> "ẹ̀ẹ́dẹ́gbẹ̀rún"
            in 901..999-> "ẹ̀ẹ́dẹ́gbẹ̀rún ó lé " + translateNumbersbetweenRounded(operatorOrNo)
            else-> "invalidNo"
        }
    }
    private fun translate1000To1099(no: Int) : String{
        val numToArray = no.toString().map { it.toString().toInt() }.toIntArray()
        return if (numToArray[2]==0) translateNumbersOneToNine(no)
        else translateElevenToNinetyNine(no, getPrifixForTwoDigitNo(no))
    }
    private fun translateSomeComplexOnes(no: Int, prefix: String): String{
        val lastNo = no.toString().map { it.toString().toInt() }.toIntArray()[2]
        Log.d("lastNo", lastNo.toString())
        return if (lastNo >5)
            translateNumbersOneToNine(10-lastNo)+ "dín" + prefix
        else
            translateNumbersOneToNine(
            lastNo) + "lél" + prefix
    }
    private fun getThelast3digitsOfA4digitNumber(no: Int): Int{
        val numToArray = no.toString().map { it.toString().toInt() }.toIntArray()
        return "${numToArray[1]}${numToArray[2]}${numToArray[1]}".toInt()
    }
    private fun getLastDigitOfA2DigitNo(no: Int) : Int{
        val numToArray = no.toString().map { it.toString().toInt() }.toIntArray()
        return numToArray[2]
    }
    private fun getPrifixForTwoDigitNo(no: Int) : String{
        val noToArray = no.toString().map { it.toString().toInt() }.toIntArray()
        return translateNumbersOneToNine(noToArray[0])
    }
    private fun translate4digitNos(no: Int, prefix: String) : String{
        val splitedNo  = no.toString().map {
            it.toString().toInt()
        }.toIntArray()
        return if (splitedNo[1] == 0 && splitedNo[2] == 0){
            prefix + translateNumbersOneToNine(splitedNo[3])
        } else if(splitedNo[1]==0 && splitedNo[2]!=0){
            prefix + translate100to999("${splitedNo[1]}${splitedNo[2]}${splitedNo[3]}".toInt())
        }else{
            prefix + translateElevenToNinetyNine("${splitedNo[2]}${splitedNo[3]}".toInt(),
                getPrifixForTwoDigitNo((splitedNo[2].toDouble() * Math.pow(10.0, Math.log10(splitedNo[3].toDouble()) + 1)
                        + splitedNo[3]).toInt()))
        }
    }
    fun translateAllNumbersToYoruba(no: Int): String{
        return when(no){
            in 1..9 -> translateNumbersOneToNine(no)
            in 10..99 -> translateElevenToNinetyNine(no, getPrifixForTwoDigitNo(no))
            in 100..2000 -> translate100to2000(no)
            else -> "invalid number"
        }
    }
}