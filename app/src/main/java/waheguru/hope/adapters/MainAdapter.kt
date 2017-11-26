package waheguru.hope.adapters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import waheguru.hope.R
import waheguru.hope.models.UserModel
import waheguru.hope.utils.ImageLoadUtils
import waheguru.hope.view.core.TimeLine

/**
 * Created by jaswinderwadali on 20/11/17.
 */

class MainAdapter internal constructor(internal var userModels: List<UserModel>) : RecyclerView.Adapter<MainAdapter.MainVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        return MainVH(view)
    }

    override fun onBindViewHolder(holder: MainAdapter.MainVH, position: Int) {
        val userModel = userModels[position]
        holder.name.text = userModel.userName
        holder.itemView.setOnClickListener({ v ->
            val intent = Intent(v.context, TimeLine::class.java)
            v.context.startActivity(intent)
        })
        ImageLoadUtils.loadRoundImage(userModel.userProfile, holder.profileImage)


    }

    override fun getItemCount(): Int {
        return userModels.size
    }


    class MainVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var name: TextView = itemView.findViewById(R.id.main_item_name)
        internal var status: TextView = itemView.findViewById(R.id.main_item_status)
        internal var statusColor: ImageView = itemView.findViewById(R.id.main_item_status_color)
        internal var profileImage: ImageView = itemView.findViewById(R.id.main_item_profile_pic)
        private var updateAt: TextView = itemView.findViewById(R.id.main_item_update_at)

    }

}
