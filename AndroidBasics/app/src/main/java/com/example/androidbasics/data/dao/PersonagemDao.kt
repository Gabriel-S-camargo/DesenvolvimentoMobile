package com.example.androidbasics.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.androidbasics.data.entities.PersonagemEntity

@Dao
interface PersonagemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserir(personagem: PersonagemEntity)

    @Query("SELECT * FROM personagens")
    suspend fun buscarTodos(): List<PersonagemEntity>

    // Read (buscar por ID)
    @Query("SELECT * FROM personagens WHERE id = :id")
    suspend fun buscarPorId(id: Int): PersonagemEntity?

    @Update
    suspend fun atualizar(personagem: PersonagemEntity)

    // Delete (excluir)
    @Delete
    suspend fun deletar(personagem: PersonagemEntity)
}
