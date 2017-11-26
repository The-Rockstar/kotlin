package waheguru.hope.view.core

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_time_line.*
import waheguru.hope.R

class TimeLine : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_time_line)
        timeline_main.setOnClickListener( {
            view ->
            startActivity(Intent(baseContext,GoalActivity::class.java))
//            Toast.makeText(baseContext,"Under construction ...",Toast.LENGTH_SHORT).show()
        })

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

}
