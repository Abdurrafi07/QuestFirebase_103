package com.example.p9cloudfirebase.Repository

import com.example.p9cloudfirebase.Model.Mahasiswa
import kotlinx.coroutines.flow.Flow

interface RepositoryMhs{
    suspend fun insertMhs(mahasiswa: Mahasiswa)

    fun getAllMhs() : Flow<List<Mahasiswa>>

    fun getMhs(nim : String) : Flow<Mahasiswa>

    suspend fun deleteMhs(Mahasiswa: Mahasiswa)

    suspend fun updateMhs(Mahasiswa: Mahasiswa)

}