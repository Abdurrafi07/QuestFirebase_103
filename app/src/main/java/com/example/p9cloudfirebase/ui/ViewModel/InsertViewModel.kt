package com.example.p9cloudfirebase.ui.ViewModel

import com.example.p9cloudfirebase.Model.Mahasiswa

sealed class FormState{
    object idle : FormState()
    object loading : FormState()
    data class Succes(val message: String) : FormState()
    data class Error(val message: String) : FormState()
}

data class InsertUiState(
    val insertUiEvent: MahasiswaEvent = MahasiswaEvent(),
    val isEntryValid: FormErrorState = FormErrorState(),
)

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