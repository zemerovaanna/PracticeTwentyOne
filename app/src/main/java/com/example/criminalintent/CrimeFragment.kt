package com.example.criminalintent

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*


class CrimeFragment: Fragment() {
    private lateinit var crime: Crime
    private lateinit var titleField: EditText
/*    private lateinit var dateButton: Button*/
    private lateinit var solvedCheckBox: CheckBox
    private lateinit var fAB: FloatingActionButton
    private lateinit var txtView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime = Crime()

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH) + 1
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val hours = calendar.get(Calendar.HOUR_OF_DAY)
        val minutes = calendar.get(Calendar.MINUTE)
/*        val  toast = Toast.makeText(this@CrimeFragment.requireContext(), "$day.$month.$year $hours:$minutes", Toast.LENGTH_LONG)
        toast.setGravity(Gravity.TOP, 0, 0)
        toast.show()*/
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crime, container, false)

        titleField = view.findViewById(R.id.crime_title) as EditText
        txtView = view.findViewById(R.id.textView) as TextView
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH) + 1
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val hours = calendar.get(Calendar.HOUR_OF_DAY)
        val minutes = calendar.get(Calendar.MINUTE)
        txtView.text = "$day.$month.$year $hours:$minutes"
/*        dateButton = view.findViewById(R.id.crime_date) as Button*/
        fAB = view.findViewById(R.id.fab) as FloatingActionButton

        fAB.apply {
            isEnabled = false
        }
        solvedCheckBox = view.findViewById(R.id.crime_solved) as CheckBox

        return view
    }

    override fun onStart() {
        super.onStart()
        val titleWatcher = object : TextWatcher {
            override fun beforeTextChanged(
                sequence: CharSequence?, start: Int, count: Int, after: Int
            ) {
            }


            override fun onTextChanged(
                sequence: CharSequence?, start: Int, count: Int, before: Int
            ) {
                crime.title = sequence.toString()
            }

            override fun afterTextChanged(sequence: Editable?) {
            }
        }
        titleField.addTextChangedListener(titleWatcher)
        solvedCheckBox.apply {
            setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    crime.isSloved = isChecked
                    fAB.isEnabled = isEnabled
                    fAB.apply {
                        val calendar = Calendar.getInstance()
                        val year = calendar.get(Calendar.YEAR)
                        val month = calendar.get(Calendar.MONTH) + 1
                        val day = calendar.get(Calendar.DAY_OF_MONTH)
                        val hours = calendar.get(Calendar.HOUR_OF_DAY)
                        val minutes = calendar.get(Calendar.MINUTE)
                        txtView.setText("$day.$month.$year $hours:$minutes")
                    }
                } else {
                    crime.isSloved=false
                    fAB.isEnabled=false
                    fAB.contentDescription = "..."
                }
            }
        }

        fAB.setOnClickListener{
            startActivity(Intent(this@CrimeFragment.requireContext(),MainActivity2::class.java))
        }

/*        fAB.setOnClickListener {
            Toast.makeText(this@CrimeFragment.requireContext(), "Сообщений нет", Toast.LENGTH_LONG).show()
        }*/
    }
}



