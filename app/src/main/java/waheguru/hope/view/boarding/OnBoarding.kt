package waheguru.hope.view.boarding

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_on_boarding.*
import kotlinx.android.synthetic.main.boarding_fragment.*
import waheguru.hope.R
import waheguru.hope.view.auth.LoginActivity

class OnBoarding : AppCompatActivity() {


    companion object {
        internal var simpleStr = "SIMPLE"
        internal var simpleArray = arrayOf("Set expectations", "Invite commitment", "Measure progress", "Provider feedback", "Link to consequences", "Evaluate effectiveness")
        internal var simpleViews = ArrayList<TextView>()
    }

    init {

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
        bindDataAdapter()
        for (value in simpleStr) {
            var textView = TextView(this)
            textView.text = value.toString()
            textView.setPadding(10,10,10,10)
            textView.textSize = 22F;
            textView.setTextColor(ContextCompat.getColor(baseContext,R.color.c_zero))

            simpleViews.add(textView)
            simple_container.addView(textView)

        }
        simpleViews.get(0).setTextColor(ContextCompat.getColor(baseContext,R.color.colorPrimaryDark))

    }


    private fun bindDataAdapter() {
        var adapter = Adapter(supportFragmentManager)
        boarding_viewpager.adapter = adapter
        boarding_viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                if (position == simpleArray.size - 1){
                    boarding_next.visibility = View.VISIBLE
                }
                else
                    boarding_next.visibility = View.INVISIBLE
                for (textView in simpleViews){
                    textView.setTextColor(ContextCompat.getColor(baseContext,R.color.c_zero))

                }
                simpleViews.get(position).setTextColor(ContextCompat.getColor(baseContext,R.color.colorPrimaryDark))



            }

        })

        boarding_next.setOnClickListener({
           v ->

            val intent = Intent(baseContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        })


    }

    class Adapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {


        override fun getItem(position: Int): Fragment {
            return PlaceFragment.getInstance(position)

        }

        override fun getCount(): Int {
            return simpleArray.size
        }


    }

    class PlaceFragment : Fragment() {


        private var position: Int = 0

        override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            return inflater?.inflate(R.layout.boarding_fragment, container, false)
        }

        override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            // will assign value to position accordingly
            openBox()

            boarding_circle_text.text = simpleArray[position]
            boardingCardView.setCardBackgroundColor(ContextCompat.getColor(context, if (position % 2 == 0) R.color.colorPrimaryDark else R.color.colorPrimaryDarkGrey))

            if (position == 0) {
                boarding_left.visibility = View.INVISIBLE
                boarding_right.visibility = View.VISIBLE
            } else if (position == simpleArray.size - 1) {
                boarding_left.visibility = View.VISIBLE
                boarding_right.visibility = View.INVISIBLE

            } else {
                boarding_left.visibility = View.VISIBLE
                boarding_right.visibility = View.VISIBLE
            }

        }

        fun openBox() {
            val bundle = arguments;
            position = bundle.getInt(POSITION)

        }

        companion object {
            private val POSITION = "position";
            fun getInstance(position: Int): Fragment {
                val bundle = Bundle()
                bundle.putInt(PlaceFragment.POSITION, position)
                val fragment = PlaceFragment()
                fragment.arguments = bundle
                return fragment
            }


        }
    }

}

