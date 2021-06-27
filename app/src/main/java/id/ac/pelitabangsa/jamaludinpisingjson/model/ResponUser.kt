package id.ac.pelitabangsa.jamaludinpisingjson.model

import com.google.gson.annotations.SerializedName

class ResponUser {
    @field:SerializedName("Page")
    val page: Int? = null,

    @field:SerializedName("Per_Page")
    val Per_Page: Int? = null,

    @field:SerializedName("Total_Page")
    val Total_Page: Int? = null,

    @field:SerializedName("Data")
    val Data: List<DataItem>?= null
}