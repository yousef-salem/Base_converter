package com.yousef.baseconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var btnClear: Button
    lateinit var binary_et: EditText
    lateinit var decimal_et: EditText
    lateinit var hexadecimal_et: EditText
    lateinit var octal_et: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnClear = findViewById(R.id.clear_btn)
        binary_et = findViewById(R.id.binary_et)
        hexadecimal_et = findViewById(R.id.Hexadecimal_et)
        decimal_et = findViewById(R.id.decimal_et)
        octal_et = findViewById(R.id.octal_et)

        btnClear.setOnClickListener {
            binary_et.setText("")
            hexadecimal_et.setText("")
            decimal_et.setText("")
            octal_et.setText("")

        }
        binary_et.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binary_et.hasFocus()) {
                    fromBinary(binary_et.text.toString())
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }


        })
        decimal_et.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (decimal_et.hasFocus()) {
                    fromDecimal(decimal_et.text.toString())
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }


        })
        hexadecimal_et.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (hexadecimal_et.hasFocus()) {
                    fromHexadecimal(hexadecimal_et.text.toString())
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }


        })
        octal_et.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (octal_et.hasFocus()) {
                    fromOctal(octal_et.text.toString())
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }


        })

    }


    fun fromBinary(binaryNumber: String) {
        if (binaryNumber != "") {
            decimal_et.setText(binaryNumber.toInt(2).toString())
            hexadecimal_et.setText(Integer.toHexString(binaryNumber.toInt(2)))
            octal_et.setText(convertBinarytoOctal(binaryNumber.toLong()).toString())
        } else {
            hexadecimal_et.setText("")
            decimal_et.setText("")
            octal_et.setText("")
        }
    }

    fun fromDecimal(decimalNumber: String) {
        if (decimalNumber != "") {
            binary_et.setText(decimalNumber.toInt().toString(2))
            hexadecimal_et.setText(Integer.toHexString(decimalNumber.toInt()))
            octal_et.setText(
                convertBinarytoOctal(
                    decimalNumber.toInt().toString(2).toLong()
                ).toString()
            )
        } else {

            hexadecimal_et.setText("")
            binary_et.setText("")
            octal_et.setText("")
        }
    }

    fun fromHexadecimal(hexNumber: String) {
        if (hexNumber != "") {
            binary_et.setText(hexNumber.toLong(16).toString().toInt().toString(2))
            decimal_et.setText(hexNumber.toLong(16).toString())
            octal_et.setText(
                convertBinarytoOctal(hexNumber.toLong(16).toString().toInt().toString(2).toLong())
                    .toString()
            )
        } else {
            decimal_et.setText("")
            binary_et.setText("")
            octal_et.setText("")
        }
    }

    fun fromOctal(octalNumber: String) {
        if (octalNumber != "") {
            binary_et.setText(convertOctalToBinary(octalNumber.toInt()).toString())
            decimal_et.setText(
                convertOctalToBinary(octalNumber.toInt()).toString().toInt(2).toString()
            )
            hexadecimal_et.setText(
                Integer.toHexString(
                    convertOctalToBinary(octalNumber.toInt()).toString().toInt(2)
                )
            )
        } else {
            decimal_et.setText("")
            binary_et.setText("")
            hexadecimal_et.setText("")
        }
    }


    fun convertBinarytoOctal(binaryNumber: Long): Int {
        var binaryNumber = binaryNumber
        var octalNumber = 0
        var decimalNumber = 0
        var i = 0

        while (binaryNumber.toInt() != 0) {
            decimalNumber += (binaryNumber % 10 * Math.pow(2.0, i.toDouble())).toInt()
            ++i
            binaryNumber /= 10
        }

        i = 1

        while (decimalNumber != 0) {
            octalNumber += decimalNumber % 8 * i
            decimalNumber /= 8
            i *= 10
        }

        return octalNumber
    }

    fun convertOctalToBinary(octalNumber: Int): Long {
        var octalNumber = octalNumber
        var decimalNumber = 0
        var i = 0
        var binaryNumber: Long = 0

        while (octalNumber != 0) {
            decimalNumber += (octalNumber % 10 * Math.pow(8.0, i.toDouble())).toInt()
            ++i
            octalNumber /= 10
        }

        i = 1

        while (decimalNumber != 0) {
            binaryNumber += (decimalNumber % 2 * i).toLong()
            decimalNumber /= 2
            i *= 10
        }

        return binaryNumber
    }


}
