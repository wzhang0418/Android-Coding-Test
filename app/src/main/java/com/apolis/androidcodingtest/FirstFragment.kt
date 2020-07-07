package com.apolis.androidcodingtest

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_first.view.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FirstFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    var listener: OnFragmentInteraction? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_first, container, false)

        init(view)
        return view
    }

    private fun init(view: View) {
        view.button_send.setOnClickListener {

            var id = view.edit_text_id.text.toString().toLong()
            var name = view.edit_text_name.text.toString()
            var email = view.edit_text_email.text.toString()
            var mobile = view.edit_text_mobile.text.toString()

            var employee = Employee(id, name, email, mobile)

            listener?.onButtonClicked(employee)
        }
    }

    interface OnFragmentInteraction {
        fun onButtonClicked(employee: Employee)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as MainActivity
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}