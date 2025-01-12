package com.example.p9cloudfirebase.ui.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.p9cloudfirebase.Model.Mahasiswa
import com.example.p9cloudfirebase.Repository.RepositoryMhs
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class HomeViewModel (
    private val repoMhs: RepositoryMhs
) : ViewModel(){
    var mhsUiState: HomeUiState by mutableStateOf(HomeUiState.Loading)
    private set

    init {
        getMhs()
    }
    fun getMhs(){
        viewModelScope.launch {
            repoMhs.getAllMhs().onStart {
                mhsUiState = HomeUiState.Loading
            }
                .catch {
                    mhsUiState = HomeUiState.Error(e = it)
                }
                .collect{
                    mhsUiState = if(it.isEmpty()){
                        HomeUiState.Error(Exception("Belum ada data mahasiswa"))
                    }
                    else{
                        HomeUiState.Succes(it)
                    }
                }
        }
    }
}

sealed class HomeUiState{
    //Loading
    object Loading : HomeUiState()
    //Sukses
    data class Succes(val data: List<Mahasiswa>) : HomeUiState()
    //Error
    data class Error(val e: Throwable) : HomeUiState()
}

