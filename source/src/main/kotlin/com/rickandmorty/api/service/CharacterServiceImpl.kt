package com.rickandmorty.api.service

import com.rickandmorty.api.entity.Character
import com.rickandmorty.api.repository.CharacterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class CharacterServiceImpl: CharacterService {
    @Autowired
    lateinit var repository: CharacterRepository

    override fun saveCharacter(character: Character): Character {
        return repository.save(character)
    }

    override fun saveCharacters(characters: MutableList<Character>) {
        for( hero in characters){
            repository.save(hero)
        }
    }

    override fun deleteCharacter(id: Int) {
        repository.deleteById(id)
    }

    override fun deleteAllCharacter() {
        repository.deleteAll()
    }

    override fun getCharacterById(id: Int): Character{return repository.findById(id).orElse(null)}

    override fun getCharacters(): MutableList<Character> {
        return repository.findAll() as MutableList<Character>
    }

    override fun getCharacterByFirstName(name: String) = repository.findByName(name)

    override fun updateCharacter( character: Character) {
        repository.save(character)
    }

}