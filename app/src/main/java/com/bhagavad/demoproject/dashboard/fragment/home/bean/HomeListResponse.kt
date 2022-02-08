package com.bhagavad.demoproject.dashboard.fragment.home.bean


class HomeListResponse {

    data class HomeListBean(
    val `data`: List<Data>,
    val error_code: Int,
    val error_line: Int,
    val message: String,
    val status: Int
)

data class Data(

    val class_id: String,
    val course: String,
    val description: String,
    val name: String,
    val profile_picture: String

)



}