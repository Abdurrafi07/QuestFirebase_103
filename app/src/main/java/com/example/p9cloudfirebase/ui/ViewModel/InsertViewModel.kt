package com.example.p9cloudfirebase.ui.ViewModel

import com.example.p9cloudfirebase.Model.Mahasiswa

//data class variable yang menyimpan data input form
data class MahasiswaEvent(
    val nim:String = "",
    val nama:String = "",
    val alamat:String = "",
    val gender:String = "",
    val kelas:String = "",
    val angkatan:String = ""
)

fun MahasiswaEvent.toMhsModel(): Mahasiswa = Mahasiswa(
    nim = nim,
    nama = nama,
    gender = gender,
    alamat = alamat,
    kelas = kelas,
    angkatan = angkatan
)