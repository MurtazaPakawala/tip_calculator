package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import java.time.temporal.TemporalAmount
private  const val TAG="MainActivity"
private const val InitialTip=15;
class MainActivity : AppCompatActivity() {

    private lateinit var etBaseAmount:EditText;
    private lateinit var tvTipval:TextView;
    private lateinit var sbTip:SeekBar;
    private lateinit var tvTipAmount: TextView;
    private lateinit var tvTotalAmount:TextView;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etBaseAmount=findViewById(R.id.etBaseAmount)
        tvTipval=findViewById(R.id.tvTipval)
        sbTip=findViewById(R.id.sbTip)
        tvTipAmount=findViewById(R.id.tvTipAmount)
        tvTotalAmount=findViewById(R.id.tvTotalAmount)

        sbTip.progress=InitialTip;
        tvTipval.text="${InitialTip}%";
        sbTip.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{

            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
               Log.i(TAG,"lets see the change $p1");
                tvTipval.text="$p1%";
                ComputeTotal()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
        etBaseAmount.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                Log.i(TAG,"after text change ${p0}")
                ComputeTotal()
            }

        }

        )

    }

    private fun ComputeTotal() {
        //conmpute total
        if(etBaseAmount.text.isEmpty())
        {
            tvTipAmount.text=""
            tvTotalAmount.text=""
            return;
        }
        val base_amount=etBaseAmount.text.toString().toDouble();
        val tip_amount=base_amount*sbTip.progress/100
        val total_amount=base_amount+tip_amount;

//        val tip_amount=tvTipval.text.toString().toDouble()
        //showing it
        tvTipAmount.text="%.2f".format(tip_amount)
        tvTotalAmount.text="%.2f".format(total_amount)
    }
}