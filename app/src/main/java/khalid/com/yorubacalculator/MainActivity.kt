package khalid.com.yorubacalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import khalid.com.yorubacalculator.translator.Translator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.simple_calculator_result.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    private var mValue1: Int? = null
    private var mValue2: Int? = null
    private var mAddition: Boolean? = null
    private var mSubtraction: Boolean? = null
    private var mMultiplication: Boolean? = null
    private var mDivision: Boolean? = null
    private var numberOfPressesForEquals = 0
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_delete.setOnClickListener {
            ediText.setText("")
            display_view.text = ""
            nos_in_yor.text = ""
        }
        btn_divide.setOnClickListener {
            if (ediText.text == null) {
                ediText.setText("")
            } else {
                mValue1 = Integer.parseInt(ediText.text.toString() + "")
                mDivision = true
                ediText.text = null
                display_view.text = mValue1.toString() + " / "
            }
        }
        btn_multiple.setOnClickListener {
            if (ediText.text == null) {
                ediText.setText("")
            } else {
                mValue1 = Integer.parseInt(ediText.text.toString() + "")
                mMultiplication = true
                ediText.text = null
                display_view.text = mValue1.toString() + " * "
            }
        }
        btn_minus.setOnClickListener {
            if (ediText.text == null) {
                ediText.setText("")
            } else {
                mValue1 = Integer.parseInt(ediText.text.toString() + "")
                mSubtraction = true
                ediText.text = null
                display_view.text = mValue1.toString() + " - "
            }

        }
        btn_plus.setOnClickListener {
            if (ediText.text == null) {
                ediText.setText("")
            } else {
                mValue1 = Integer.parseInt(ediText.text.toString() + "")
                mAddition = true
                ediText.text = null
                display_view.text = mValue1.toString() + " + "
            }

        }
        btn_equal.setOnClickListener { performCalculationAndDisplayTranslation() }
        btn_zero.setOnClickListener { displayText("0") }
        btn_one.setOnClickListener { displayText("1") }
        btn_two.setOnClickListener { displayText("2") }
        btn_three.setOnClickListener { displayText("3") }
        btn_four.setOnClickListener { displayText("4") }
        btn_five.setOnClickListener { displayText("5") }
        btn_six.setOnClickListener { displayText("6") }
        btn_seven.setOnClickListener { displayText("7") }
        btn_eight.setOnClickListener { displayText("8") }
        btn_nine.setOnClickListener { displayText("9") }

    }

    @SuppressLint("SetTextI18n")
    private fun performCalculationAndDisplayTranslation() {
        numberOfPressesForEquals += 1
        try {
            if (numberOfPressesForEquals > 1) {
                Toast.makeText(this@MainActivity, "Input is limited to 2 numbers", Toast.LENGTH_SHORT).show()
                return
            }
            mValue2 = Integer.parseInt(ediText.text.toString() + "")
            display_view.text = display_view.text.toString() + mValue2

            if (mAddition == true) {
                val sum = mValue1!! + mValue2!!
                if (sum > 1000000) {
                    Toast.makeText(this@MainActivity, "Answer cannot be higher than 1 million", Toast.LENGTH_SHORT)
                        .show()
                    return
                }
                display_view.text = display_view.text.toString() + "=" + sum
                translateResult("+", sum)
                mAddition = false
            }

            if (mSubtraction == true) {
                val sum = mValue1!! - mValue2!!
                if (sum > 1000000) {
                    Toast.makeText(this@MainActivity, "Answer cannot be higher than 1 million", Toast.LENGTH_SHORT)
                        .show()
                    return
                }
                display_view.text = display_view.text.toString() + "=" + sum
                translateResult("-", sum)
                mSubtraction = false
            }

            if (mMultiplication == true) {
                val sum = mValue1!! * mValue2!!
                if (sum > 1000000) {
                    Toast.makeText(this@MainActivity, "Answer cannot be higher than 1 million", Toast.LENGTH_SHORT)
                        .show()
                    return
                }
                display_view.text = display_view.text.toString() + "=" + sum
                translateResult("*", sum)
                mMultiplication = false
            }

            if (mDivision == true) {
                val sum = mValue1!! / mValue2!!
                if (sum > 1000000) {
                    Toast.makeText(this@MainActivity, "Answer cannot be higher than 1 million", Toast.LENGTH_SHORT)
                        .show()
                    return
                }
                display_view.text = display_view.text.toString() + "=" + sum
                translateResult("/", sum)
                mDivision = false
            }
        } catch (e: NumberFormatException) {
            Toast.makeText(this@MainActivity, "Input must be a number", Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun translateResult(operator: String, result: Int) {
        nos_in_yor.text = "${Translator.translate1to1000000(mValue1!!)} " +
                "${Translator.translateoperator(operator)} ${Translator.translate1to1000000(mValue2!!)} " +
                "${Translator.translateoperator("=")} ${Translator.translate1to1000000(result)}"
    }

    @SuppressLint("SetTextI18n")
    private fun displayText(text: String) {
        numberOfPressesForEquals = 0
        ediText.setText(ediText.text.toString() + text)
    }
}
