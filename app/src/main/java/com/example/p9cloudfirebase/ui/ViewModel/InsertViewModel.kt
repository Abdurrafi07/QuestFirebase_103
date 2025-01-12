package com.example.p9cloudfirebase.ui.ViewModel

import com.example.p9cloudfirebase.Model.Mahasiswa

data class FormErrorState(
    val nim:String? = null,
    val nama:String? = null,
    val alamat:String? = null,
    val gender:String? = null,
    val kelas:String? = null,
    val angkatan:String? = null
){
    fun isValid(): Boolean{
        return nim == null && nama == null && gender == null &&
                alamat == null && kelas == null && angkatan == null
    }
}

//data class variable yang menyimpan data input form
data class MahasiswaEvent(
    val nim:String = "",
    val nama:String = "",
    val alamat:String = "",
    val gender:String = "",
    val kelas:String = "",
    val angkatan:String = ""
)

//Menyimpan input form ke dalam entity
fun MahasiswaEvent.toMhsModel(): Mahasiswa = Mahasiswa(
    nim = nim,
    nama = nama,
    gender = gender,
    alamat = alamat,
    kelas = kelas,
    angkatan = angkatan
)