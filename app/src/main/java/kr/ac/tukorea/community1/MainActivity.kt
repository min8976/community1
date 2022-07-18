package kr.ac.tukorea.community1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.concurrent.timer
import kotlin.reflect.KMutableProperty1

class MainActivity : AppCompatActivity() {

    private var time = 0
    private var timerTask : Timer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnWalk.setOnClickListener {
            startTimer()
            btnStop.visibility = View.VISIBLE
            btnReset.visibility = View.VISIBLE

        }

        btnStop.setOnClickListener {
            stopTimer()
            btnStop.visibility = View.INVISIBLE

        }
        btnReset.setOnClickListener {
            resetTimer()
            btnReset.visibility = View.INVISIBLE


        }

    }
    private fun startTimer(){
        timerTask = timer(period = 10){
            time++
            val sec = time / 100
            val milli = time % 100

            runOnUiThread {
                txtTime?.text = "${sec} : ${milli}"
            }

        }

    }

    private fun stopTimer(){
        timerTask?.cancel()

    }
    private fun resetTimer(){
        timerTask?.cancel()

        time = 0
        txtTime?.text = "00:00"
    }

}
