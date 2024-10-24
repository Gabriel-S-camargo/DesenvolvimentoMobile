package com.example.androidbasics.data.viewModel

import Personagem
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.androidbasics.data.conversores.toEntity
import com.example.androidbasics.data.dao.PersonagemDao
import com.example.androidbasics.data.database.AppDatabase
import com.example.androidbasics.data.entities.PersonagemEntity
import kotlinx.coroutines.launch

class PersonagemViewModel(application: Application) : AndroidViewModel(application) {
    private val personagemDao: PersonagemDao = AppDatabase.getDatabase(application).personagemDao()

    private val _personagens = MutableLiveData<List<PersonagemEntity>>()

    val personagens: LiveData<List<PersonagemEntity>> = _personagens

    init {
        buscarPersonagens()
    }

    fun inserirPersonagem(personagem: Personagem) {
        viewModelScope.launch {
            val personagemEntity = personagem.toEntity()
            personagemDao.inserir(personagemEntity)
        }
    }

    fun buscarPersonagens() {
        viewModelScope.launch {
            val personagensEntity = personagemDao.buscarTodos()
            _personagens.postValue(personagensEntity) // Atualiza o LiveData
        }
    }


    fun buscarPersonagemPorId(id: Int): LiveData<PersonagemEntity?> {
        val personagemPorId = MutableLiveData<PersonagemEntity?>()
        viewModelScope.launch {
            val personagem = personagemDao.buscarPorId(id)
            personagemPorId.postValue(personagem)
        }
        return personagemPorId
    }

    fun atualizarPersonagem(personagem: PersonagemEntity) {
        viewModelScope.launch {
            personagemDao.atualizar(personagem)
        }
    }

    fun deletarPersonagem(personagem: PersonagemEntity) {
        viewModelScope.launch {
            personagemDao.deletar(personagem)
        }
    }

}
