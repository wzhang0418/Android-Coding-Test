package com.apolis.androidcodingtest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), FirstFragment.OnFragmentInteraction {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, FirstFragment()).addToBackStack("").commit()
    }

    override fun onButtonClicked(employee: Employee) {
        var secondFragment = SecondFragment.newInstance(employee, "")
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, secondFragment).addToBackStack("").commit()
    }
}