package cat.itic.activitat4visual

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class BMICalculator : AppCompatActivity() {
    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var seekBarHeight: SeekBar
    private lateinit var heightValue: TextView
    private lateinit var weightValue: TextView
    private lateinit var ageValue: TextView
    private lateinit var btnWeightMinus: ImageView
    private lateinit var btnWeightPlus: ImageView
    private lateinit var btnAgeMinus: ImageView
    private lateinit var btnAgePlus: ImageView
    private lateinit var btnCalculate: Button
    private var isMale = true
    private var height = 170
    private var weight = 60
    private var age = 25

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmicalculator)

        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        seekBarHeight = findViewById(R.id.seekBarHeight)
        heightValue = findViewById(R.id.heightValue)
        weightValue = findViewById(R.id.weightValue)
        ageValue = findViewById(R.id.ageValue)
        btnWeightMinus = findViewById(R.id.btnWeightMinus)
        btnWeightPlus = findViewById(R.id.btnWeightPlus)
        btnAgeMinus = findViewById(R.id.btnAgeMinus)
        btnAgePlus = findViewById(R.id.btnAgePlus)
        btnCalculate = findViewById(R.id.btnCalculate)

        viewMale.setOnClickListener { selectGender(true) }
        viewFemale.setOnClickListener { selectGender(false) }

        seekBarHeight.progress = height
        heightValue.text = "$height cm"
        seekBarHeight.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                height = progress
                heightValue.text = "$height cm"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
        btnWeightMinus.setOnClickListener { if (weight > 1) weightValue.text = (--weight).toString() }
        btnWeightPlus.setOnClickListener { weightValue.text = (++weight).toString() }
        btnAgeMinus.setOnClickListener { if (age > 1) ageValue.text = (--age).toString() }
        btnAgePlus.setOnClickListener { ageValue.text = (++age).toString() }

        btnCalculate.setOnClickListener {
            val bmi = weight / ((height / 100.0) * (height / 100.0))
            val intent = Intent(this, BMICalculatorResults::class.java)
            intent.putExtra("bmi", bmi)
            intent.putExtra("isMale", isMale)
            intent.putExtra("age", age)
            startActivity(intent)
        }
    }
    private fun selectGender(maleSelected: Boolean) {
        isMale = maleSelected
        viewMale.setCardBackgroundColor(getColor(if (maleSelected) R.color.background_component_selected else R.color.background_component))
        viewFemale.setCardBackgroundColor(getColor(if (!maleSelected) R.color.background_component_selected else R.color.background_component))
    }
}
