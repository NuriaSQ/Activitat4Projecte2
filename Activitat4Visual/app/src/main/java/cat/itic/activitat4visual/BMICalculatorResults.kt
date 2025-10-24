package cat.itic.activitat4visual

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BMICalculatorResults : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmicalculator_results)

        val result = findViewById<TextView>(R.id.result)
        val status = findViewById<TextView>(R.id.status)
        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnRecalculate = findViewById<Button>(R.id.btnRecalculate)

        val bmi = intent.getDoubleExtra("bmi", 0.0)
        result.text = "Your BMI: %.1f".format(bmi)
        status.text = when {
            bmi < 18.5 -> "Underweight"
            bmi < 24.9 -> "Normal"
            bmi < 29.9 -> "Overweight"
            else -> "Obese"
        }

        btnBack.setOnClickListener { finish() }
        btnRecalculate.setOnClickListener { finish() }
    }
}
