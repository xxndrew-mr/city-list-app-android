package com.example.myapplicationproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Profile
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var rvCity : RecyclerView
    private val list = ArrayList<City>()

    private fun moveActivity(city: City){
        val detailIntent = Intent (this, MoveActivity::class.java)
        detailIntent.putExtra(MoveActivity.EXTRA_NAME, city.name)
        detailIntent.putExtra(MoveActivity.EXTRA_DESCRIPTION,city.description)
        detailIntent.putExtra(MoveActivity.EXTRA_PHOTO, city.photo)
        startActivity(detailIntent)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean{
        menuInflater.inflate(R.menu.profile, menu)
        return super.onCreateOptionsMenu(menu)
    }

   override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
           R.id.open_profile -> {
               val moveAbout = Intent(this@MainActivity, AboutActivity::class.java)
               startActivity(moveAbout)
           }
       }
       return super.onOptionsItemSelected(item)
   }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        rvCity = findViewById(R.id.rv_city)
        rvCity.setHasFixedSize(true)

        list.addAll(getListCity())
        showRecyclerList()


    }


    private fun getListCity(): ArrayList<City> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val listCity = ArrayList<City>()
        for (i in dataName.indices) {
            val city = City(dataName[i], dataDescription[i], dataPhoto[i])
            listCity.add(city)
        }
        return listCity
    }

    private fun showRecyclerList() {
        rvCity.layoutManager = LinearLayoutManager(this)
        val listCityAdapter = ListCityAdapter(list)
        rvCity.adapter = listCityAdapter
        listCityAdapter.setOnItemClickCallback(object : ListCityAdapter.OnItemClickCallback {
            override fun onItemClicked(data: City){
                moveActivity(data)
            }

        })
    }

  override fun onClick(p0: View?){
     when(p0?.id){
         R.id.imageView ->{
             val  moveIntent = Intent (this@MainActivity, MoveActivity::class.java)
             startActivity(moveIntent)
         }
     }
 }
}