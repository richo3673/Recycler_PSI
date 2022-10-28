package com.example.recyclerpsi

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerpsi.databinding.ActivityMainBinding
import com.example.recyclerpsi.helper.MahasiswaAdapter
import com.example.recyclerpsi.model.MahasiswaModel
import com.example.recyclerpsi.viewmodel.MahasiswaViewModel


class MainActivity : AppCompatActivity(), View.OnClickListener {
    var data = MutableLiveData<List<MahasiswaModel>>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showData()
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {

        }
    }

    private fun showData() {
        //AMBIL DARI VIEWMODEL
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val model = ViewModelProvider(this).get(MahasiswaViewModel::class.java)
        model.getMahasiswaList().observe(this) { mahasiswaListData ->
            data.value = mahasiswaListData
//          LALU TAMPIL RECYCLER VIEW
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = MahasiswaAdapter(data, this)
        }
    }
}