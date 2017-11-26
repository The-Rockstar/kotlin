package waheguru.hope.view.core

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import waheguru.hope.R
import waheguru.hope.adapters.MainAdapter
import waheguru.hope.models.UserModel

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView;


    private lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        recyclerView = findViewById(R.id.mainRecyclerView);

        val userModelList = ArrayList<UserModel>()

        val userModel = UserModel()
        userModel.userName = "Ram Kumar"
        userModel.userProfile= "https://i.guim.co.uk/img/static/sys-images/Guardian/Pix/pictures/2014/4/7/1396871767552/Max-Clifford-011.jpg?w=300&q=55&auto=format&usm=12&fit=max&s=c6f416db0e207839a0ba6c71113136e8"

        val sham = UserModel()
        sham.userName = "Sham Sharma"
        sham.userProfile= "http://1o9ddb39vxx9vbisv3djd3iysr.wpengine.netdna-cdn.com/wp-content/uploads/2017/06/Vinnie-Tortorich.jpg"


        val rani = UserModel()
        rani.userName = "Rani Devi"
        rani.userProfile= "http://gaia.adage.com/images/bin/image/medium/Women2013AngelaCourtin.jpg?1369852913"


        val mukesh = UserModel()
        mukesh.userName = "Mukesh"
        mukesh.userProfile= "http://wwwimage2.cbsstatic.com/base/files/cast/cast_manwithaplan_mattleblanc.jpg"



        userModelList.add(userModel)
        userModelList.add(rani)
        userModelList.add(sham)
        userModelList.add(mukesh)

        mainAdapter = MainAdapter(userModelList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setAdapter(mainAdapter)


    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}
