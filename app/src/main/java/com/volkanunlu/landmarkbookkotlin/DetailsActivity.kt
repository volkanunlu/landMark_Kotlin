package com.volkanunlu.landmarkbookkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.volkanunlu.landmarkbookkotlin.databinding.ActivityDetailsBinding


class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetailsBinding.inflate(layoutInflater)  //inflater = şişirici xml ile kodu bağlayıcı
        val view=binding.root   //ana kaynak kökten görünümü veriyorum
        setContentView(view)

        val intent=intent
        //Casting --> ben sana yolladığım veriden eminim. --> as Landmark ekledim sadece

        val selectedLandmark= MySingleton.chosenLandmark  //Hep aynı objeyi çektik

        selectedLandmark?.let {
            binding.nameText.text=selectedLandmark!!.name   //verilerimin değerlerini verdim sırasıyla
            binding.countryText.text=selectedLandmark!!.country
            binding.imageView.setImageResource(selectedLandmark!!.image)
        }




      //  val selectedLandmark=intent.getSerializableExtra("landmark") as Landmark

    }
}