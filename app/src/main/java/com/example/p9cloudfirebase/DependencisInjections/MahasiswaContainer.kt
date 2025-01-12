package com.example.p9cloudfirebase.DependencisInjections

import android.content.Context
import com.example.p9cloudfirebase.Repository.NetworkRepositoryMhs
import com.example.p9cloudfirebase.Repository.RepositoryMhs
import com.google.firebase.firestore.FirebaseFirestore

interface  InterfaceContainerApp{
    val repositoryMhs: RepositoryMhs
}

class MahasiswaContainer(private val context: Context) : InterfaceContainerApp{
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    override val repositoryMhs: RepositoryMhs by lazy {
        NetworkRepositoryMhs(firestore)
    }
}