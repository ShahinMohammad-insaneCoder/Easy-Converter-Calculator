package com.okcodex.easyconverters.ui.calculators.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.okcodex.easyconverters.R

class InterestActivity : AppCompatActivity() {

    private lateinit var labelInterestAmount: TextView
    private lateinit var labelTotalAmount: TextView
    private lateinit var interestCalculate: TextView
    private lateinit var eInterest: EditText
    private lateinit var eTotalPrice: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interest)

        labelInterestAmount = findViewById(R.id.labelInterestAmount)
        labelTotalAmount = findViewById(R.id.labelTotalAmount)
        interestCalculate = findViewById(R.id.interestCalculate)
        eInterest = findViewById(R.id.eInterest)
        eTotalPrice = findViewById(R.id.eTotalPrice)

        interestCalculate.setOnClickListener {
            val amount = eTotalPrice.text.toString()
            val interest = eInterest.text.toString()

            when {
                amount.isEmpty() -> {
                    Toast.makeText(this, "Enter your Amount", Toast.LENGTH_SHORT).show()
                }
                interest.isEmpty() -> {
                    Toast.makeText(this, "Input Discount Percentage", Toast.LENGTH_SHORT).show()
                }
                else -> {

                    val totalInterestAmount: Float =
                        amount.toFloat() + (amount.toFloat() * interest.toFloat() / 100)
                    val totalInterest: Float =  totalInterestAmount -  amount.toFloat()
                    labelTotalAmount.text = "%.2f".format(totalInterestAmount) + "$"
                    labelInterestAmount.text = "%.2f".format(totalInterest) + "$"
                }
            }

        }

    }
}