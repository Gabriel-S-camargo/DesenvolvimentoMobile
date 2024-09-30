package com.example.androidbasics.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.androidbasics.data.entities.PersonagemEntity

@Dao
interface PersonagemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserir(personagem: PersonagemEntity)

    @Query("SELECT * FROM personagens")
    suspend fun buscarTodos(): List<PersonagemEntity>
}
