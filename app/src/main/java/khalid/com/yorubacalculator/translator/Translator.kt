package khalid.com.yorubacalculator.translator

/**
 * Created by ${KhalidToak} on 4/6/2019.
 */
object Translator {
    fun translateoperator(o: String): String{
        return when (o){
            "+" -> "pẹlu"
            "-" -> "o din"
            "*" -> "o na"
            "/" -> "o la"
            "=" -> "o jẹ"
            else -> "o sofo"
        }
    }
    fun translate1to1000000(no: Int): String{
        return when (no){
            in 1..9 -> translate1to9(no)
            in 10..99 -> translate10to99(no)
            in 100..999 -> translate100to999(no)
            in 1000..9999 -> translate1000to9999(no)
            in 10000..99999 -> translate10000to99999(no)
            in 100000..299999 -> "atiabo".translate100000to299999(no)
            in 300000..1000000 -> translate300000to1000000(no)
            else -> "invalid number"
        }
    }

    private fun translate1to9(number: Int): String {
        return when(number){
            1 -> "ọ̀kan"
            2 -> "eéji"
            3 -> "ẹẹ́ta"
            4 -> "ẹẹ́rin"
            5 -> "aárùn"
            6 -> "ẹẹ́fà"
            7 -> "eéje"
            8 -> "ẹẹ́jọ"
            9 -> "ẹẹ́sàn"
            else -> "invalid number"
        }
    }




    private fun translate11to19(number: Int, prefix: String, suffix: String, after: String): String{
        return when(number){
            in 11..14 -> prefix + "lá"
            15 -> "ẹ́ẹd$suffix"
            in 16..19 -> after + "dinlogun"
            else -> "invalid number"
        }
    }

    private fun translate10to99(number: Int): String{
        val sT20 = translateTens(20)
        val sT30 = translateTens(30)
        val sT40 = translate20s(40)
        val sT50 = translateoddtens(50)
        val sT60 = translate20s(60)
        val sT70 = translateoddtens(70)
        val sT80 = translate20s(80)
        val sT90 = translateoddtens(90)
        val sT100 = translate20s(100)
        return when (number){
            10 -> "ẹẹ́wà"
            in 11..19 -> translate11to19(number, translate1to9(number - 10), sT20, translate1to9(20-number))
            20 -> sT20
            in 21..24 -> translate1to9(getLastDigitOf2DigitNo(number)) + "lel$sT20"
            25 -> "eed$sT30"
            in 26..29 -> translate1to9(10- getLastDigitOf2DigitNo(number)) + "dinl$sT30"
            30 -> sT30
            in 31..34 -> translate1to9(getLastDigitOf2DigitNo(number)) + "lel$sT30"
            in 35..39 -> translate1to9(10-getLastDigitOf2DigitNo(number)) + "dinl$sT40"
            in 41..44 -> translate1to9(getLastDigitOf2DigitNo(number)) + "lel$sT40"
            in 45..49 -> translate1to9(10-getLastDigitOf2DigitNo(number)) + "dinl$sT50"
            in 51..54 -> translate1to9(getLastDigitOf2DigitNo(number)) + "lel$sT50"
            in 55..59 -> translate1to9(10-getLastDigitOf2DigitNo(number)) + "dinl$sT60"
            in 61..64 -> translate1to9(number) + "lel$sT60"
            in 65..69 -> translate1to9(10-getLastDigitOf2DigitNo(number)) + "dinl$sT70"
            in 71..74 -> translate1to9(getLastDigitOf2DigitNo(number)) + "lel$sT70"
            in 75..79 -> translate1to9(10-getLastDigitOf2DigitNo(number)) + "dinl$sT80"
            in 81..84 -> translate1to9(getLastDigitOf2DigitNo(number)) + "lel$sT80"
            in 85..89 -> translate1to9(10-getLastDigitOf2DigitNo(number)) + "dinl$sT90"
            in 91..94 -> translate1to9(getLastDigitOf2DigitNo(number)) + "lel$sT90"
            in 95..99 -> translate1to9(10-getLastDigitOf2DigitNo(number)) + "dinl$sT100"
            40,60,80,100 -> translate20s(number)
            50,70,90 -> translateoddtens(number)
            else -> "invalid number"
        }
    }


    private fun translate100to999(number: Int): String{
        return when (number){
            100 -> translate20s(number)
            in 101..199 -> translate101to199(number)
            200 -> translateTens(200)
            in 201..299 -> "lerugba".translate200to299(number)
            in 301..999 -> translate301to999(number)
            else -> "Invalid number"
        }
    }

    private fun translate101to199(number: Int): String{
        return when(number){
            in 101..109 -> getLastDigitOf3digitNo(number, "ọgọrùn", "àádọ́fà")
            110,130,150,170 -> translateoddtens(number)
            120, 140,160,180 -> translate20s(number)
            in 111..119 -> getLastDigitOf3digitNo(number, "àádọ́fà", "ọgọfa")
            in 121..129 -> getLastDigitOf3digitNo(number, "ọgọfa", "àádóje")
            in 131..139 -> getLastDigitOf3digitNo(number, "àádóje", "ọgọje")
            in 141..149 -> getLastDigitOf3digitNo(number, "ọgọje", "àádọ́jọ")
            in 151..159 -> getLastDigitOf3digitNo(number, "àádọ́jọ", "ọgọjọ")
            in 161..169 -> getLastDigitOf3digitNo(number, "ọgọjọ", "àádọ́sán")
            in 171..179 -> getLastDigitOf3digitNo(number, "àádọ́sán", "ọgọsan")
            in 181..189 -> getLastDigitOf3digitNo(number, "ọgọsan", translateTens(190))
            in 191..199 -> getLastDigitOf3digitNo(number, translateTens(190), translateTens(200))
            else -> "invalid number"
        }
    }


    private fun translateTens(number: Int): String{
        return when(number) {
            10 -> "ẹẹ́wà"
            20 -> "ogún"
            30 -> "ọgbọ̀n"
            190 -> "mẹwadinigba"
            200 -> "igba"
            300 -> "ọdunrun"
            1000 -> "ẹgbẹrun"
            20000 -> "ọkẹ́ kán"
            else -> "invalid number"
        }
    }

    private fun String.translate200to299(number: Int): String{
        return when (number){
            in 201..209 -> translate1to9(number - 200) + this
            210 -> translateTens(10) +"lel"+ this
            in 211..219 -> getLastDigitOf3digitNo(
                number,
                translateTens(10) + this,
                translateEven200tens(20, "ugba")
            )
            220,240,260,280 -> translateEven200tens(number - 200, "lugba")
            in 221..229 -> getLastDigitOf3digitNo(
                number,
                translateEven200tens(20, "lugba"),
                translateTens(30) + "wo${this}"
            )
            230 -> translateTens(30) +"wo${this}"
            in 231..239 -> getLastDigitOf3digitNo(
                number,
                translateTens(30) + "wo${this}",
                translateEven200tens(40, "lugba")
            )
            in 241..249 -> getLastDigitOf3digitNo(
                number,
                translateEven200tens(40, "lugba"),
                translateoddtens(50) + this
            )
            in 251..259 -> getLastDigitOf3digitNo(
                number,
                translateoddtens(50) + this,
                translateEven200tens(60, "ugba")
            )
            in 261..269 -> getLastDigitOf3digitNo(
                number,
                translateEven200tens(60, "lugba"),
                translateoddtens(70) + this
            )
            in 271..279 -> getLastDigitOf3digitNo(
                number,
                translateoddtens(70) + this,
                translateEven200tens(80, "ugba")
            )
            in 281..289 -> getLastDigitOf3digitNo(
                number,
                translateEven200tens(80, "lugba"),
                translateoddtens(90) + this
            )
            in 291..299 -> getLastDigitOf3digitNo(
                number,
                translateoddtens(90) + this,
                "lọdunrun"
            )
            250,270,290 -> translateoddtens(number - 200) + this
            else -> "invalid number"
        }
    }

    private fun translate301to999(number:Int): String{
        return when (number){
            in 301..399 -> trySomething(number, "ọdunrun", "irinwo")
            400 -> "irinwo"
            in 401..499 -> trySomething(number, "irinwo", "ẹdẹgbẹta")
            500 -> "ẹdẹgbẹta"
            in 501..599 -> trySomething(number, "ẹdẹgbẹta", "ẹgbẹta")
            600 -> "ẹgbẹta"
            in 601..699 -> trySomething(number, "ẹgbẹta", "ẹdẹgbẹrin")
            700 -> "ẹdẹgbẹrin"
            in 701..799 -> trySomething(number, "ẹdẹgbẹrin", "ẹgbẹrin")
            800 -> "ẹgbẹrin"
            in 801..899 -> trySomething(number, "ẹgbẹrin", "ẹdẹgbẹrun")
            900 -> "ẹdẹgbẹrun"
            in 901..999 -> trySomething(number, "ẹdẹgbẹrun", "ẹgbẹrun")
            else -> "invalid number"
        }
    }

    private fun translate1000to9999(no: Int): String{
        return when (no){
            in 1000..3999 -> translate1000to3999(no)
            in 4000..9999 -> translate4000to19999(no)
            else -> "invalid number"
        }
    }

    private fun translate300000to1000000(no: Int): String{
        return when(no){
            300000,400000,500000,600000,700000,800000 -> translate300000to900000(no, "ẹgbẹrunlọna")
            in 300001..399999 -> translate300000to900000(300000, "ẹgbẹrunlọna") + "le"+ translate6digitNo(no)
            in 400001..499999 -> translate300000to900000(400000, "ẹgbẹrunlọna") + "le"+ translate6digitNo(no)
            in 500001..599999 -> translate300000to900000(500000, "ẹgbẹrunlọna") + "le"+ translate6digitNo(no)
            in 600001..699999 -> translate300000to900000(600000, "ẹgbẹrunlọna") + "le"+ translate6digitNo(no)
            in 700001..799999 -> translate300000to900000(700000, "ẹgbẹrunlọna") + "le"+ translate6digitNo(no)
            in 800001..899999 -> translate300000to900000(800000, "ẹgbẹrunlọna") + "le"+ translate6digitNo(no)
            in 900001..999999 -> translate300000to900000(900000, "ẹgbẹrunlọna") + "le"+ translate6digitNo(no)
            1000000 -> "Ẹgbẹgbẹrun"
            else -> "invalid number"
        }
    }

    private fun translate10000to99999(no: Int): String{
        return when (no){
            in 10001..19999 -> translate4000to19999(no)
            in 20000..99999 -> "atiabo".translate20000to99999(no)
            else -> "invalid number"
        }
    }


    private fun String.translate20000to99999(no: Int): String{
        return when (no){
            20000,40000,60000,80000 -> translate20000(no)
            30000,50000,70000,90000 -> translate20000(no - 10000) + this
            in 20001..29999 -> translate20000(20000) + "le"+ translate4digitNumber(
                no
            )
            in 30001..39999 -> translate20000(20000) + this + "le"+ translate4digitNumber(
                no
            )
            in 40001..49999 -> translate20000(40000) + "le"+ translate4digitNumber(
                no
            )
            in 50001..59999 -> translate20000(40000) + this + "le"+ translate4digitNumber(
                no
            )
            in 60001..69999 -> translate20000(60000) + "le"+ translate4digitNumber(
                no
            )
            in 70001..79999 -> translate20000(60000) + this + "le"+ translate4digitNumber(
                no
            )
            in 80001..89999 -> translate20000(80000) + "le"+ translate4digitNumber(
                no
            )
            in 90001..99999 -> translate20000(80000) + this + "le"+ translate4digitNumber(
                no
            )
            else -> "invalid number"
        }
    }

    private fun String.translate100000to299999(no: Int): String{
        return when (no){
            100000,120000,140000,160000,180000,200000 -> translate20000(no)
            110000,130000,150000,170000,190000,210000 -> translate20000(no - 10000) + this
            220000,240000,260000,280000 -> translate20000(no)
            230000,250000,270000 -> translate20000(no - 10000) + this
            290000 -> translate300000to900000(300000, "ẹgbẹrunlọna") + "dinẹgbàrún"
            in 100001..109999 -> translate20000(100000) + "le"+ translate5digitNo(
                no
            )
            in 110001..119999 -> translate20000(100000) + this + "le"+ translate5digitNo(
                no
            )
            in 120001..129999 -> translate20000(120000) + "le"+ translate5digitNo(
                no
            )
            in 130001..139999 -> translate20000(120000) + this + "le"+ translate5digitNo(
                no
            )
            in 140001..149999 -> translate20000(140000) + "le"+ translate5digitNo(
                no
            )
            in 150001..159999 -> translate20000(140000) + this + "le"+ translate5digitNo(
                no
            )
            in 160001..169999 -> translate20000(160000) + "le"+ translate5digitNo(
                no
            )
            in 170001..179999 -> translate20000(160000) + this + "le"+ translate5digitNo(
                no
            )
            in 180001..189999 -> translate20000(180000) + "le"+ translate5digitNo(
                no
            )
            in 190001..199999 -> translate20000(180000) + this + "le"+ translate5digitNo(
                no
            )
            in 200001..209999 -> translate20000(200000) + "le"+ translate5digitNo(
                no
            )
            in 210001..219999 -> translate20000(200000) + this + "le"+ translate5digitNo(
                no
            )
            in 220001..229999 -> translate20000(100000) + "le"+ translate5digitNo(
                no
            )
            in 230001..239999 -> translate20000(100000) + this + "le"+ translate5digitNo(
                no
            )
            in 240001..249999 -> translate20000(100000) + "le"+ translate5digitNo(
                no
            )
            in 250001..259999 -> translate20000(100000) + this + "le"+ translate5digitNo(
                no
            )
            in 260001..269999 -> translate20000(100000) + "le"+ translate5digitNo(
                no
            )
            in 270001..279999 -> translate20000(100000) + this + "le"+ translate5digitNo(
                no
            )
            in 280001..289999 -> translate20000(100000) + "le"+ translate5digitNo(
                no
            )
            in 290001..299999 -> translate300000to900000(
                300000,
                "ẹgbẹrunlọna"
            ) + "dinẹgbàrún" + "le"+ translate5digitNo(no)
            else -> "invalid number"
        }
    }


    private fun translate4000to19999(no: Int): String{
        return when(no){
            4000,6000,8000,10000,12000,14000,16000,18000 -> eventhousands(no)
            5000,7000,9000,11000,13000,15000,17000,19000 -> oddThousands(no)
            in 4001..4999 -> eventhousands(4000) + "le"+translate10004D(no)
            in 5001..5999 -> oddThousands(5000) + "le"+translate10004D(no)
            in 6001..6999 -> eventhousands(6000) + "le"+translate10004D(no)
            in 7001..7999 -> oddThousands(7000) + "le"+translate10004D(no)
            in 8001..8999 -> eventhousands(8000) + "le"+translate10004D(no)
            in 9001..9999 -> oddThousands(8000) + "le"+translate10004D(no)
            in 10001..10999 -> eventhousands(10000) + "le"+translate100005digitNo(no)
            in 11001..11999 -> oddThousands(11000) + "le"+translate100005digitNo(no)
            in 12001..12999 -> eventhousands(12000) + "le"+translate100005digitNo(no)
            in 13001..13999 -> oddThousands(13000) + "le"+translate100005digitNo(no)
            in 14001..14999 -> eventhousands(14000) + "le"+translate100005digitNo(no)
            in 15001..15999 -> oddThousands(15000) + "le"+translate100005digitNo(no)
            in 16001..16999 -> eventhousands(16000) + "le"+translate100005digitNo(no)
            in 17001..17999 -> oddThousands(17000) + "le"+translate100005digitNo(no)
            in 18001..18999 -> eventhousands(18000) + "le"+translate100005digitNo(no)
            in 19001..19999 -> oddThousands(19000) + "le"+translate100005digitNo(no)
            else -> "invalid number"
        }
    }


    private fun translate1000to3999(no: Int): String{
        return when (no){
            1000 -> translateTens(no)
            1200,1400,1600,1800,2000,2200,2400 -> translateeven1000(no)
            2600,2800,3000,3200,3400,3600,3800 -> translateeven1000(no)
            1100,1300,1500,1700,1900,2100,2300 -> translateOdd1000(no)
            2500,2700,2900,3100,3300,3500,3700,3900 -> translateOdd1000(no)
            in 1001..1099 -> translateTens(1000)+"le" + translate1000D(no)
            in 1101..1199 -> translateOdd1000(1100)+"le" + translate1000D(no-100)
            in 1201..1299 -> translateeven1000(1200)+"le" + translate1000D(no-200)
            in 1301..1399 -> translateOdd1000(1300)+"le" + translate1000D(no-300)
            in 1401..1499 -> translateeven1000(1400)+"le" + translate1000D(no-400)
            in 1501..1599 -> translateOdd1000(1500)+"le" + translate1000D(no-500)
            in 1601..1699 -> translateeven1000(1600)+"le" + translate1000D(no-600)
            in 1701..1799 -> translateOdd1000(1700)+"le" + translate1000D(no-700)
            in 1801..1899 -> translateeven1000(1800)+"le" + translate1000D(no-800)
            in 1901..1999 -> translateOdd1000(1900)+"le" + translate1000D(no-900)

            in 2001..2099 -> translateeven1000(2000) +"le" + translate1000D(no)
            in 2101..2199 -> translateOdd1000(2100)+"le" + translate1000D(no-100)
            in 2201..2299 -> translateeven1000(2200)+"le" + translate1000D(no-200)
            in 2301..2399 -> translateOdd1000(2300)+"le" + translate1000D(no-300)
            in 2401..2499 -> translateeven1000(2400)+"le" + translate1000D(no-400)
            in 2501..2599 -> translateOdd1000(2500)+"le" + translate1000D(no-500)
            in 2601..2699 -> translateeven1000(2600)+"le" + translate1000D(no-600)
            in 2701..2799 -> translateOdd1000(2700)+"le" + translate1000D(no-700)
            in 2801..2899 -> translateeven1000(2800)+"le" + translate1000D(no-800)
            in 2901..2999 -> translateOdd1000(2900)+"le" + translate1000D(no-900)

            in 3001..3099 -> translateeven1000(3000)+"le" + translate1000D(no)
            in 3101..3199 -> translateOdd1000(3100)+"le" + translate1000D(no-100)
            in 3201..3299 -> translateeven1000(3200)+"le" + translate1000D(no-200)
            in 3301..3399 -> translateOdd1000(3300)+"le" + translate1000D(no-300)
            in 3401..3499 -> translateeven1000(3400)+"le" + translate1000D(no-400)
            in 3501..3599 -> translateOdd1000(3500)+"le" + translate1000D(no-500)
            in 3601..3699 -> translateeven1000(3600)+"le" + translate1000D(no-600)
            in 3701..3799 -> translateOdd1000(3700)+"le" + translate1000D(no-700)
            in 3801..3899 -> translateeven1000(3800)+"le" + translate1000D(no-800)
            in 3901..3999 -> translateOdd1000(3900)+"le" + translate1000D(no-900)
            else -> "invalid number"
        }
    }
    private fun translate20s(no: Int): String{
        val suffix = no/20
        val suffixTranslation = translate1to9(suffix)
        return when(suffix){
            5-> "ọgọ"+suffixTranslation.removePrefix("aá")
            2->  "ọgọ"+ suffixTranslation.removePrefix("eé")
            else -> "ọgọ"+suffixTranslation.removePrefix("ẹẹ")
        }
    }

    private fun translate1to19(no: Int): String{
        return when (no){
            in 0..9 -> translate1to9(no)
             10 -> translateTens(10)
            else -> translate11to19(no, translate1to9(no-10), translateTens(20), translate1to9(20-no))
        }
    }

    private fun eventhousands(no: Int): String{
        val suffix = no/2000
        val suffixTranslation = translate1to9(suffix)
        return when(suffix){
            5 -> "Ẹgba"+suffixTranslation.removePrefix("aá")
            2, 7 -> "Ẹgba"+ suffixTranslation.removePrefix("eé")
            else -> "Ẹgba"+suffixTranslation.removePrefix("ẹẹ")
        }
    }

    private fun oddThousands(no: Int): String{
        val suffix = (no+1000)/2000
        val sT = translate1to9(suffix)
        return when(suffix){
            5 -> "ẹgbarundinẹgbẹ̀rún"
            2, 7 -> "ẹdẹgba"+ sT.removePrefix("eé")
            10 -> "ọkẹ́kándinẹgbẹ̀rún"
            else -> "ẹdẹgba"+sT.removePrefix("ẹẹ")
        }
    }

    private fun translate100005digitNo(no: Int): String{
        val numToArray = no.toString().map { it.toString().toInt() }.toIntArray()
        return if (numToArray[1] == 0 && numToArray[2] == 0 && numToArray[3] == 0) translate1to9(numToArray[4])
        else if (numToArray[1] == 0 && numToArray[2] == 0 && numToArray[3] != 0) translate10to99(("${numToArray[3]}${numToArray[4]}").toInt())
        else translate100to999(("${numToArray[2]}${numToArray[3]}${numToArray[4]}").toInt())
    }

    private fun translate4digitNumber(no: Int): String{
        val array = no.toString().map { it.toString().toInt() }.toIntArray()
        return if (array[1] == 0 && array[2] == 0 && array[3] == 0) translate1to9(array[4])
        else if (array[1] == 0 && array[2] == 0 && array[3] != 0) translate10to99(("${array[3]}${array[4]}").toInt())
        else if (array[1] == 0 && array[2] != 0) translate100to999(("${array[2]}${array[3]}${array[4]}").toInt())
        else translate1000to9999(("${array[1]}${array[2]}${array[3]}${array[4]}").toInt())
    }

    private fun translate5digitNo(no: Int): String{
        val array = no.toString().map { it.toString().toInt() }.toIntArray()
        return if (array[2] == 0 && array[3] == 0 && array[4] == 0) translate1to9(array[5])
        else if (array[2] == 0 && array[3] == 0 && array[4] != 0) translate10to99(("${array[4]}${array[5]}").toInt())
        else if (array[2] == 0 && array[3] != 0) translate100to999(("${array[3]}${array[4]}${array[5]}").toInt())
        else translate1000to9999(("${array[2]}${array[3]}${array[4]}${array[5]}").toInt())
    }

    private fun translate6digitNo(no: Int): String{
        val array = no.toString().map { it.toString().toInt() }.toIntArray()
        return if (array[1] == 0 && array[2] == 0 && array[3] == 0 && array[4] == 0) translate1to9(array[5])
        else if (array[1] == 0 && array[2] == 0 && array[3] == 0 && array[4] != 0) translate10to99(("${array[4]}${array[5]}").toInt())
        else if (array[1] == 0 && array[2] == 0 && array[3] != 0) translate100to999(("${array[3]}${array[4]}${array[5]}").toInt())
        else if (array[1] == 0 && array[2] != 0) translate1000to9999(("${array[2]}${array[3]}${array[4]}${array[5]}").toInt())
        else translate10000to99999(("${array[1]}${array[2]}${array[3]}${array[4]}${array[5]}").toInt())
    }


    private fun translate20000(no: Int): String{
        val suffix = no/20000
        val suffixTranslation = translate1to9(suffix)
        return when (suffix) {
            1 -> "ọkẹ "+suffixTranslation.removePrefix("ọ")
            2 -> "ọkẹ "+ suffixTranslation.replace("e", "m")
            5 -> "ọkẹ "+suffixTranslation.replace("a", "m")
            7 -> "ọkẹ "+ suffixTranslation.replaceFirst("e", "m")
            10 -> "ọkẹ mẹwa"
            else -> "ọkẹ "+ suffixTranslation.replaceFirst("ẹ", "m")
        }
    }

    private fun translate300000to900000(no: Int, prefix: String): String{
        val suffix = no/1000
        val suffixTranslation = translate301to999(suffix)
        return if (suffix==300) prefix + translateTens(300)
        else prefix + suffixTranslation
    }


    private fun translateeven1000(no: Int): String{
        val suffix = no/200
        val numTranslation = translate1to19(suffix)
        return when (suffix) {
            7 -> "ẹgbẹ"+ numTranslation.removePrefix("eé")
            6,8,9 -> "ẹgbẹ"+numTranslation.removePrefix("ẹẹ")
            10 -> "ẹgbà" + numTranslation.removePrefix("ẹẹ")
            else -> "ẹgb$numTranslation"
        }
    }
    private fun translateOdd1000(no: Int): String{
        val suffix = (no+100)/200
        val numTranslation = translate1to19(suffix)
        return when (suffix) {
            6 -> "ẹgberunleọgọrun"
            7 -> "ẹdẹgbe" + numTranslation.removePrefix("eé")
            10 -> "ẹgbadinọgọrun"
            11 -> "ẹgbàwáleọgọrun"
            20 -> "ẹgbajidin-ọgọrun"
            else -> "ẹdẹgb$numTranslation"
        }
    }


    private fun translateoddtens(no: Int): String{
        val suffix = (no+10)/20
        val numTranslation = translate1to9(suffix)
        return when (suffix) {
            5 -> "àádọ" + numTranslation.removePrefix("aá")
            7 -> "àádọ" + numTranslation.removePrefix("eé")
            else -> "àádọ" + numTranslation.removePrefix("ẹẹ")
        }
    }

    private fun translateEven200tens(no: Int, prefix: String): String{
        val suffix = no/20
        return when (suffix) {
            1 -> translateTens(20)+"le"+prefix
            2 -> "ojule$prefix"
            3 -> "otale$prefix"
            4 -> "orinle$prefix"
            else -> "Invalid number"
        }
    }
    private fun translate10004D(no: Int): String{
        val numToArray = no.toString().map { it.toString().toInt() }.toIntArray()
        return if (numToArray[1] == 0 && numToArray[2] == 0) translate1to9(numToArray[3])
        else if (numToArray[1] == 0 && numToArray[2] != 0) translate10to99(("${numToArray[2]}${numToArray[3]}").toInt())
        else translate100to999(("${numToArray[1]}${numToArray[2]}${numToArray[3]}").toInt())
    }

    private fun translate1000D(no: Int): String{
        val numToArray = no.toString().map { it.toString().toInt() }.toIntArray()
        return if (numToArray[2] == 0) translate1to9(numToArray[3])
        else translate10to99(("${numToArray[2]}${numToArray[3]}").toInt())
    }

    private fun getLastDigitOf3digitNo(number: Int, prefix: String, suffix: String): String{
        val numToArray = number.toString().map { it.toString().toInt() }.toIntArray()
        return when {
            numToArray[2]>5 -> translate1to9(10-numToArray[2]) + "dinl" + suffix
            numToArray[2] == 0 -> prefix
            else -> translate1to9(numToArray[2]) + "lel" + prefix
        }
    }


    private fun trySomething(number: Int, prefix: String, suffix: String): String{
        val numToArray = number.toString().map { it.toString().toInt() }.toIntArray()
        return when {
            numToArray[1] == 0 -> translate1to9(numToArray[2]) + "le"+prefix
            numToArray[1] == 1 -> getLastDigitOf3digitNo(number, translateTens(10)+"le"+prefix,
                translateEven200tens(20, prefix))
            numToArray[1] == 2 -> getLastDigitOf3digitNo(number, translateEven200tens(20, prefix),
                translateTens(30)+"le"+prefix)
            numToArray[1] == 3 -> getLastDigitOf3digitNo(number, translateTens(30)+"le"+prefix,
                translateEven200tens(40, prefix))
            numToArray[1] == 4 -> getLastDigitOf3digitNo(number, translateEven200tens(40, prefix),
                translateoddtens(50)+"le"+ prefix)
            numToArray[1] == 5 -> getLastDigitOf3digitNo(number, translateoddtens(50)+"le"+ prefix,
                translateEven200tens(60, prefix))
            numToArray[1] == 6 -> getLastDigitOf3digitNo(number, translateEven200tens(60, prefix),
                translateoddtens(70)+"le"+prefix)
            numToArray[1] == 7 -> getLastDigitOf3digitNo(number, translateoddtens(70)+"le"+prefix,
                translateEven200tens(80, prefix))
            numToArray[1] == 8 -> getLastDigitOf3digitNo(number, translateEven200tens(80, prefix),
                translateoddtens(90)+"le"+prefix)
            numToArray[1] == 9 -> getLastDigitOf3digitNo(number, translateoddtens(90)+"le"+prefix, suffix)
            else -> "invalid number"
        }
    }





    //get last no for a 2 digits value
    // For example, if no is 23, this will return 3
    private fun getLastDigitOf2DigitNo(no: Int): Int{
        val numToArray = no.toString().map { it.toString().toInt() }.toIntArray()
        return numToArray[1]
    }
}