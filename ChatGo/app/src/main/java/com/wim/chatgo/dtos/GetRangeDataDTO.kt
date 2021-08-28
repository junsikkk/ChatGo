package com.wim.chatgo.dtos

import com.google.gson.annotations.SerializedName

data class GetRangeDataDTO(
    @SerializedName("distance") val distance: Double,
    @SerializedName("School_name") val schoolName: String,
    @SerializedName("Zip_code") val zipCode: String,
    @SerializedName("address") val adress: String,
    @SerializedName("phone_number") val phoneNumber: String,
    @SerializedName("Year_of_opening") val yaerOfOpening: String,
    @SerializedName("total_people") val totalPeople: String,
    @SerializedName("Field") val field: String,
    @SerializedName("division") val division: String,
    @SerializedName("Region_1") val region1: String,
    @SerializedName("Region_2") val region2: String,
    @SerializedName("school_district") val schoolDistrict: String,
    @SerializedName("Type_1") val type1: String,
    @SerializedName("Type_2") val type2: String,
    @SerializedName("Type_3") val type3: String,
    @SerializedName("teaching_process") val teachingProcess: String,
    @SerializedName("x") val x: String,
    @SerializedName("y") val y: String,
)
