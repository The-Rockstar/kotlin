package waheguru.hope.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by jaswinderwadali on 19/11/17.
 */

class UserModel {


    @SerializedName("createdAt")
    @Expose
    lateinit var createdAt: String

    @SerializedName("userName")
    @Expose
    lateinit var userName: String

    @SerializedName("id")
    @Expose
    lateinit var id: String

    @SerializedName("userType")
    @Expose
    lateinit var userType: String

    @SerializedName("userProfile")
    @Expose
    lateinit var userProfile: String

    @SerializedName("emailId")
    @Expose
    lateinit var emailId: String

    @SerializedName("mobileNo")
    @Expose
    lateinit var mobileNo: String



}
