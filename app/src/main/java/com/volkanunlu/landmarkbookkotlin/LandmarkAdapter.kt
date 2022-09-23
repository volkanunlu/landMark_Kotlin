package com.volkanunlu.landmarkbookkotlin

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.volkanunlu.landmarkbookkotlin.databinding.RecyclerRowBinding

//landmarklisti kullanmak adına  constructor metodumda burada verdim.
class LandmarkAdapter(val landmarkList: ArrayList<Landmark>) : RecyclerView.Adapter<LandmarkAdapter.LandMarkHolder>() {  //Adım 1 bu kısmı oluştur

    class LandMarkHolder(val binding: RecyclerRowBinding):RecyclerView.ViewHolder(binding.root){ //Adım 2 bu kısımı oluştur


    }

    //Adım 3 methodlarını implement et

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandMarkHolder {  //View holder ilk oluşturulduğunda ne olacak

        val binding=RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LandMarkHolder(binding)  //Görünümümüzü bağladık.

    }

    override fun onBindViewHolder(holder: LandMarkHolder, position: Int) {  //Bağlandıktan sonra ne olacak

        holder.binding.recyclerViewTextView.text=landmarkList.get(position).name

        holder.itemView.setOnClickListener {
                            //holder içindeyim this için herhangi bir activity veremem o yüzden holder tarafına verdim
            val intent=Intent(holder.itemView.context,DetailsActivity::class.java)
            MySingleton.chosenLandmark=landmarkList.get(position)  //---> Hep aynı objeyi çektim.
            holder.itemView.context.startActivity(intent)

        }


    }

    override fun getItemCount(): Int {    //Kaç tane olacak
        return landmarkList.size  //listte ne kadar varsa o kadar oluştur derim.
    }

}