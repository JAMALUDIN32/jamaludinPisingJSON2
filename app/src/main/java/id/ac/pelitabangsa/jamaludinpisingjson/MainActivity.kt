package id.ac.pelitabangsa.jamaludinpisingjson

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.pelitabangsa.jamaludinpisingjson.model.DataItem
import id.ac.pelitabangsa.jamaludinpisingjson.model.ResponUser
import id.ac.pelitabangsa.jamaludinpisingjson.network.ApiConfig
import retrofit2.Call

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.Layout.activity_main)

        adapter = UserAdapter(mutableListOf())


        rvuser.setHasFixedSize(true)
        rvuser.layoutManager = LinearLayoutManager(this)
        rvuser.adapter = adapter
        getUser()
    }


    private fun getUser(){
        val client = ApiConfig.getApiService().getListUsers("")

        client.enqueue(object : retrofit2.Callback<ResponUser> {
            override fun onResponse(call: Call<ResponUser>, response: retrofit2.Response<ResponUser>){
                if (response.isSuccessful){
                    val dataArray = response.body()?.Data as List<DataItem>
                    for (data in dataArray){
                        adapter.addUser(data)
                    }
                }
            }

            override fun onFailure(call: Call<ResponUser>, t: Throwable){
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
                t.printStackTrace()
            }
        })
    }
}