package khalid.com.yorubacalculator.translator

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
    fun translateRoundedNumbers(operatorOrNo: Int, prefix: String) : String{
        return when(operatorOrNo){
            in 100..999-> translate100to999(operatorOrNo, prefix)
            1000 -> "ẹgbẹ̀rún"
            in 1000..1099 -> "ẹgbẹ̀rún ó lé " + translate1000To1099(operatorOrNo, prefix)
            1100 -> "Ẹgbẹrunlelọgọrun"
            in 1101..1199 -> "ẹgbẹ̀rún ó lé"+ translate100to999(getThelast3digitsOfA4digitNumber(operatorOrNo), prefix)
            1200 -> "ẹgbẹ̀fà"
            in 1201..1299 -> "ẹgbẹ̀fà ó lé"+ translate100to999(getThelast3digitsOfA4digitNumber(operatorOrNo), prefix)
            1300 -> "Ẹdẹgbeje"
            in 1301..1399-> "ẹ̀ẹ̀dẹ́gbèje ó lé" + translate100to999(getThelast3digitsOfA4digitNumber(operatorOrNo), prefix)
            1400 -> "egbèje"
            in 1401..1499 -> "egbèje ó lé" + translate100to999(getThelast3digitsOfA4digitNumber(operatorOrNo), prefix)
            1500 -> "ẹ̀ẹ̀dẹ́gbẹ̀jọ"
            in 1501..1599 -> "ẹ̀ẹ̀dẹ́gbẹ̀jọ ó lé"  + translate100to999(getThelast3digitsOfA4digitNumber(operatorOrNo), prefix)
            1600 -> "ẹgbẹ̀jọ"
            in 1601..1699 -> "ẹgbẹ̀jọ ó lé" + translate100to999(getThelast3digitsOfA4digitNumber(operatorOrNo), prefix)
            1700 -> "Ẹdẹgbẹsan"
            in 1701..1799 -> "ẹ̀ẹ̀dẹ́gbẹ̀sán ó lé" + translate100to999(getThelast3digitsOfA4digitNumber(operatorOrNo), prefix)
            1800 -> "ẹgbẹ̀sàn"
            in 1801..1899-> "ẹgbẹ̀sàn ó lé" + translate100to999(getThelast3digitsOfA4digitNumber(operatorOrNo), prefix)
            1900 -> "ẹ̀ẹ̀dẹ́gbàà"
            in 1901..1999 -> "ẹ̀ẹ̀dẹ́gbàà ó lé" + translate100to999(getThelast3digitsOfA4digitNumber(operatorOrNo), prefix)

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
           in 111..119 -> translateSomeComplexOnes(no,"àádọ́fà")
           in 121..129 -> translateSomeComplexOnes(no, getTranslationFor120To180(120))
           in 131..139 -> translateSomeComplexOnes(no, "àádóje")
           in 141..149 -> translateSomeComplexOnes(no, getTranslationFor120To180(140))
           in 151..159 -> translateSomeComplexOnes(no, "àádọ́jọ")
           in 161..169 -> translateSomeComplexOnes(no, getTranslationFor120To180(160))
           in 171..179 -> translateSomeComplexOnes(no, "àádọ́sán")
           in 181..189 -> translateSomeComplexOnes(no, getTranslationFor120To180(180))
           in 191..199-> translateSomeComplexOnes(no, "ààdọ́wá")
           110 -> "àádọ́fà"
           130 -> "àádóje"
           150 -> "àádọ́jọ"
           170 -> "àádọ́sán"
           190 -> "ààdọ́wá"
           else -> "Invalid number passed"
       }
    }
    private fun translateNumbersbetweenRounded(no: Int, prefix: String): String{
        val numToArray = no.toString().toCharArray()
        return if (numToArray[1].toInt()==0)  translateNumbersOneToNine(no)
        else translateElevenToNinetyNine(no, prefix)
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
    private fun translate100to999(operatorOrNo: Int, prefix: String) : String{
        return when(operatorOrNo){
            100 -> "Ọgọrun"
            in 101..190 -> translate101To199(operatorOrNo)
            200 -> "Igba"
            in 201..299 -> "Igba ó lé "+ translateNumbersbetweenRounded(operatorOrNo, prefix)
            300 -> "ọ̀ọ́dúrún"
            in 301..399 -> "ọ̀ọ́dúrún ó lé " + translateNumbersbetweenRounded(operatorOrNo, prefix)
            400 -> "irinwó"
            in 401..499 -> "irinwó ó lé " + translateNumbersbetweenRounded(operatorOrNo, prefix)
            500 -> "ẹ̀ẹ́dẹ́gbẹ̀ta"
            in 501..599 ->  "ẹ̀ẹ́dẹ́gbẹ̀ta ó lé " + translateNumbersbetweenRounded(operatorOrNo, prefix)
            600 -> "ẹgbẹ̀ta"
            in 601..699 -> "ẹgbẹ̀ta ó lé " + translateNumbersbetweenRounded(operatorOrNo, prefix)
            700 -> "ẹ̀ẹ́dẹ́gbẹ̀rin"
            in 701..799 -> "ẹ̀ẹ́dẹ́gbẹ̀rin ó lé " + translateNumbersbetweenRounded(operatorOrNo, prefix)
            800 -> "ẹgbẹ̀rin"
            in 801..899 -> "ẹgbẹ̀rin ó lé " + translateNumbersbetweenRounded(operatorOrNo, prefix)
            900 -> "ẹ̀ẹ́dẹ́gbẹ̀rún"
            in 901..999-> "ẹ̀ẹ́dẹ́gbẹ̀rún ó lé " + translateNumbersbetweenRounded(operatorOrNo, prefix)
            else-> "invalidNo"
        }
    }
    private fun translate1000To1099(no: Int, prefix: String) : String{
        val numToArray = no.toString().toCharArray()
        return if (numToArray[2].toInt()==0) translateNumbersOneToNine(no)
        else translateElevenToNinetyNine(no, prefix)
    }
    private fun translateSomeComplexOnes(no: Int, prefix: String): String{
        return  prefix + "lél"+ translateNumbersOneToNine(
            "${no.toString().toCharArray()[1]}${no.toString().toCharArray()[1]}".toInt())
    }
    private fun getThelast3digitsOfA4digitNumber(no: Int): Int{
        val numToArray = no.toString().toCharArray()
        return "${numToArray[1]}${numToArray[2]}${numToArray[1]}}".toInt()
    }
    private fun getLastDigitOfA2DigitNo(no: Int) : Int{
        val numToArray = no.toString().toCharArray()
        return numToArray[2].toInt()
    }
    private fun getPrifixForTwoDigitNo(no: Int) : String{
        val noToArray = no.toString().toCharArray()
        return translateNumbersOneToNine(noToArray[0].toInt())
    }
}