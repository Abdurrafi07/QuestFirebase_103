package com.example.p9cloudfirebase.ui.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.p9cloudfirebase.Model.Mahasiswa
import com.example.p9cloudfirebase.Repository.RepositoryMhs

class InsertViewModel (
    private val repoMhs: RepositoryMhs
) : ViewModel(){
    var uiEvent: InsertUiState by mutableStateOf(InsertUiState())
        private set

    var uiState: FormState by mutableStateOf(FormState.idle)
        private set

    // Mengimplementasikan stste berdasarkan input pengguna
    fun updateState(mahasiswaEvent: MahasiswaEvent){
        uiEvent = uiEvent.copy(
            insertUiEvent = mahasiswaEvent
        )
    }

    // Validasi data input pengguna
    fun validateFields(): Boolean{
        val event = uiEvent.insertUiEvent
        val errorState = FormErrorState(
            nim = if (event.nim.isNotEmpty()) null else "NIM tidak boleh kosong",
            nama = if (event.nama.isNotEmpty()) null else "Nama tidak boleh kosong",
            gender = if (event.gender.isNotEmpty()) null else "Jenis Kelamin tidak boleh kosong",
            alamat = if (event.alamat.isNotEmpty()) null else "Alamat tidak boleh kosong",
            kelas = if (event.gender.isNotEmpty()) null else "Kelas tidak boleh kosong",
            angkatan = if (event.angkatan.isNotEmpty()) null else "Angkatan tidak boleh kosong",
        )
        uiEvent = uiEvent.copy(isEntryValid = errorState)
        return errorState.isValid()
    }
}

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