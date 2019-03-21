package khalid.com.yorubacalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import khalid.com.yorubacalculator.translator.Translator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Translate", Translator.translateAllNumbersToYoruba(159))
        Log.d("Translate", Translator.translateAllNumbersToYoruba(1256))
        Log.d("Translate", Translator.translateAllNumbersToYoruba(700))
        Log.d("Translate", Translator.translateAllNumbersToYoruba(1875))
        Log.d("Translate", Translator.translateAllNumbersToYoruba(568))
        Log.d("Translate", Translator.translateAllNumbersToYoruba(198))
        Log.d("Translate", Translator.translateAllNumbersToYoruba(1107))
        Log.d("Translate", Translator.translateAllNumbersToYoruba(1056))
    }
}
