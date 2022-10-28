package com.example.recyclerpsi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerpsi.model.MahasiswaModel

class MahasiswaViewModel : ViewModel() {

    var mahasiswaListData: MutableLiveData<ArrayList<MahasiswaModel>>? = null
    val mahasiswaList = ArrayList<MahasiswaModel>()

    //GET LIVEDATA
    internal fun getMahasiswaList(): MutableLiveData<ArrayList<MahasiswaModel>> {
        if (mahasiswaListData == null) {
            mahasiswaListData = MutableLiveData()
            createMahasiswa()
        }
        return mahasiswaListData as MutableLiveData<ArrayList<MahasiswaModel>>
    }

    //ADD MODEL TO LIVEDATA
    private fun addData(array: ArrayList<MahasiswaModel>) {
        mahasiswaListData!!.value = array
    }

    //CREATE MODEL
    fun addMahasiswa(nama: String, nim: String, kelas:String, foto:String) {
        mahasiswaList.add(MahasiswaModel(nama, nim, kelas,foto))
        addData(mahasiswaList)
    }


    //CREATE DUMMY DATA
    private fun createMahasiswa() {
        addMahasiswa("Nelson Alfons Abilo", "205150200111017", "TIF-A","image_2")
        addMahasiswa("Richo Wijaya Putra", "205150200111018", "TEKKOM-B", "image_0")
        addMahasiswa("Auryn Seanita", "205150201111011", "TIF-C", "image_1")
        addMahasiswa("Billy Kurniananda", "205150201111014", "SI-A","image_3")
    }
}