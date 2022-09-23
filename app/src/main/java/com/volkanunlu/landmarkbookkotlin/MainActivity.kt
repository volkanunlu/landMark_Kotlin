package com.volkanunlu.landmarkbookkotlin

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.volkanunlu.landmarkbookkotlin.databinding.ActivityMainBinding


//var chosenLandmark: Landmark?=null  //global tanım

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var landmarkList:ArrayList<Landmark> //landmark objelerini tutacağım dizi..



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        landmarkList=ArrayList<Landmark>() //initialize ettim.

        //data
        val pisa=Landmark("Pisa","Italy",R.drawable.pisa)
        val colesseum=Landmark("Colesseum", "Italy", R.drawable.colesseum)
        val eiffel= Landmark("Eiffel", "France", R.drawable.eiffel)
        val ephesus=Landmark("Ephesus","Turkey",R.drawable.ephesus)

        //Inefficents Verimsiz bir yol kullanmıyoruz bunu //görseller için var , app çökertir cinsten
        //val pisaBitmap=BitmapFactory.decodeResource(resources,R.drawable.pisa)



        //diziye alacağım --> listelerle çalışıp, kullanıcıya göstermek için.

        landmarkList.add(pisa)
        landmarkList.add(colesseum)
        landmarkList.add(eiffel)
        landmarkList.add(ephesus)

        binding.recyclerView.layoutManager=LinearLayoutManager(this) //veriler nasıl gözüksün, linear alt alta alıyor
        val landmarkAdapter=LandmarkAdapter(landmarkList)  //adapter ile landmarklistimi bağladım.
        binding.recyclerView.adapter=landmarkAdapter //oluşturduğum adapter ile elementi birbirine bağladım

        
    }
}