package com.bhagavad.demoproject.dashboard.fragment.home.bean

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class HomeListResponse {

    data class HomeListBean(
        val `data`: List<Data>,
        val error_code: Int,
        val error_line: Int,
        val message: String,
        val status: Int
    )

    data class Data(

        @SerializedName("class_id")
        val class_id: String? = "",
        @SerializedName("course")
        val course: String? = "",
        @SerializedName("description")
        val description: String? = "",
        @SerializedName("name")
        val name: String? = "",
        @SerializedName("profile_picture")
        val profile_picture: String? = ""

    ) : Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()
        ) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(class_id)
            parcel.writeString(course)
            parcel.writeString(description)
            parcel.writeString(name)
            parcel.writeString(profile_picture)

        }

        override fun describeContents(): Int {
            return 0
        }

        companion object {
            @JvmField
            val CREATOR = object : Parcelable.Creator<Data> {
                override fun createFromParcel(parcel: Parcel): Data {
                    return Data(parcel)
                }

                override fun newArray(size: Int): Array<Data?> {
                    return arrayOfNulls(size)
                }
            }
        }
    }


}