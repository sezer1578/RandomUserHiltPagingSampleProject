package com.ozaltun.pagingsampleproject.data.model

import java.io.Serializable

data class UserModel(
    val name: NameModel,
    val email: String,
    val phone: String,
    val picture: PictureModel
) : Serializable {

}