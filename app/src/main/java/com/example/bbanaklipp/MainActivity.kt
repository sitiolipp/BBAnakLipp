package com.example.bbanaklipp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var EtNama: EditText
    lateinit var Ettahun: EditText
    lateinit var Etbulan: EditText
    lateinit var Btnhitung: Button
    lateinit var Hasilhitung: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        EtNama = findViewById(R.id.grsnama)
        Ettahun = findViewById(R.id.grstahun)
        Etbulan = findViewById(R.id.grsbulan)
        Btnhitung = findViewById(R.id.btnhitung)
        Hasilhitung = findViewById(R.id.hasilhitung)

        Btnhitung.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
    when(v?.id) {
        R.id.btnhitung -> hitungBB()
    }
    }
    private fun hitungBB() {
        val nama = EtNama.text.toString()
        val tahun = Ettahun.text.toString().toIntOrNull()?:0
        val bulan = Etbulan.text.toString().toIntOrNull()?:0

        val BBIdeal = kalkulatorBB(tahun,bulan)
        val hasil = "$nama,Usia $tahun tahun, $bulan bulan. Berat badan idealnya adalah $BBIdeal kg"
        Hasilhitung.text = hasil
    }
    private fun kalkulatorBB(tahun: Int, bulan: Int): Double {
        return 10.0 + (tahun - 1)*2.0+bulan*0.1
    }
}