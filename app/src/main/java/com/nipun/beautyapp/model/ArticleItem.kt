package com.nipun.beautyapp.model


import com.google.gson.annotations.SerializedName

data class ArticleItem(
    @SerializedName("date")
    var date: String?,
    @SerializedName("id")
    var id: String?,
    @SerializedName("image")
    var image: String?,
    @SerializedName("reco")
    var reco: String?,
    @SerializedName("source")
    var source: String?,
    @SerializedName("summary")
    var summary: String?,
    @SerializedName("title")
    var title: String?
)