package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import java.time.temporal.TemporalAmount
private  const val TAG="MainActivity"
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


        sbTip.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
               Log.i(TAG,"lets see the change $p1");
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })

    }
}