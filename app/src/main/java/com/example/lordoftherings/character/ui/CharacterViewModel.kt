package com.example.lordoftherings.character.ui

import androidx.lifecycle.*
import com.example.lordoftherings.character.data.CharacterModel
import com.example.lordoftherings.character.data.CharacterRepository
import kotlinx.coroutines.launch

class CharacterViewModel(private val repository: CharacterRepository) : ViewModel() {

    lateinit var characterList: LiveData<List<CharacterModel>>

    init{
        viewModelScope.launch {
           characterList = repository.getCharacters()
        }
    }
}
