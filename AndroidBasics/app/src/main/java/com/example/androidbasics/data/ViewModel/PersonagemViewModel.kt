package com.example.androidbasics.data.ViewModel

import Personagem
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import bonusRacial.BonusRacial
import com.example.androidbasics.data.conversores.toEntity
import com.example.androidbasics.data.conversores.toPersonagem
import com.example.androidbasics.data.dao.PersonagemDao
import com.example.androidbasics.data.database.AppDatabase
import kotlinx.coroutines.launch

class PersonagemViewModel(application: Application) : AndroidViewModel(application) {
    private val personagemDao: PersonagemDao = AppDatabase.getDatabase(application).personagemDao()

    fun inserirPersonagem(personagem: Personagem) {
        viewModelScope.launch {
            val personagemEntity = personagem.toEntity()
            personagemDao.inserir(personagemEntity)
        }
    }

    fun buscarPersonagens(bonusRacial: BonusRacial): LiveData<List<Personagem>> {
        val personagens = MutableLiveData<List<Personagem>>()
        viewModelScope.launch {
            val personagensEntity = personagemDao.buscarTodos()
            personagens.postValue(personagensEntity.map { it.toPersonagem(bonusRacial) })
        }
        return personagens
    }
}