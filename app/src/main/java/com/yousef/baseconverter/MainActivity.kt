package com.yousef.baseconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    lateinit var btnClear: Button
    lateinit var binaryET: EditText
    lateinit var decimalET: EditText
    lateinit var hexadecimalET: EditText
    lateinit var octalET: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnClear = findViewById(R.id.clear_btn)
        binaryET = findViewById(R.id.binary_et)
        hexadecimalET = findViewById(R.id.Hexadecimal_et)
        decimalET = findViewById(R.id.decimal_et)
        octalET = findViewById(R.id.octal_et)

        btnClear.setOnClickListener {
            hexadecimalET.setText("")
            decimalET.setText("")
            octalET.setText("")
            binaryET.setText("")

        }

            binaryET.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (binaryET.hasFocus()) {
                        fromBinary(binaryET.text.toString())


                    }
                }


                    override fun afterTextChanged(s: Editable?) {

                    }



            })

        decimalET.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (decimalET.hasFocus()) {
                    fromDecimal(decimalET.text.toString())
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }


        })
        hexadecimalET.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (hexadecimalET.hasFocus()) {
                    fromHexadecimal(hexadecimalET.text.toString())
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }


        })
        octalET.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (octalET.hasFocus()) {
                    fromOctal(octalET.text.toString())
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }


        })

    }
    fun fromBinary(binaryNumber: String) {
        if (binaryNumber != "") {
            decimalET.setText(binaryNumber.toLong(2).toString())
            hexadecimalET.setText(binaryNumber.toLong(2).toString(16))
            octalET.setText(binaryNumber.toLong(2).toString(8))
        } else {
            hexadecimalET.setText("")
            decimalET.setText("")
            octalET.setText("")
        }
    }

    fun fromDecimal(decimalNumber: String) {
        if (decimalNumber != "") {
            binaryET.setText(decimalNumber.toLong().toString(2))
            hexadecimalET.setText(decimalNumber.toLong().toString(16))
            octalET.setText(decimalNumber.toLong().toString(8))
        } else {

            hexadecimalET.setText("")
            binaryET.setText("")
            octalET.setText("")
        }
    }

    fun fromHexadecimal(hexNumber: String) {
        if (hexNumber != "") {
            binaryET.setText(hexNumber.toLong(16).toString(2))
            decimalET.setText(hexNumber.toLong(16).toString())
            octalET.setText(hexNumber.toLong(16).toString(8))
        } else {
            decimalET.setText("")
            binaryET.setText("")
            octalET.setText("")
        }
    }

    fun fromOctal(octalNumber: String) {
        if (octalNumber != "") {
            binaryET.setText(octalNumber.toLong(8).toString(2))
            decimalET.setText(octalNumber.toLong(8).toString())
            hexadecimalET.setText(octalNumber.toLong(8).toString(16))
        } else {
            decimalET.setText("")
            binaryET.setText("")
            hexadecimalET.setText("")
        }
    }
}
