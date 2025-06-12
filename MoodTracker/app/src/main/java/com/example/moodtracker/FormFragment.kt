package com.example.moodtracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FormFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FormFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var mood = ""

        val moodGroup: RadioGroup = view.findViewById(R.id.moodGroup)
        moodGroup.setOnCheckedChangeListener { _, checkedId ->
            val radioButton: RadioButton = view.findViewById(checkedId)
            mood = radioButton.text.toString()
        }


        val mainButton: ImageButton = view.findViewById(R.id.mainButton)

        mainButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.ShownFragment, MainFragment())
                .addToBackStack(null)
                .commit()
        }

        val saveButton: Button = view.findViewById(R.id.saveButton)

        saveButton.setOnClickListener {

        }
    }
}