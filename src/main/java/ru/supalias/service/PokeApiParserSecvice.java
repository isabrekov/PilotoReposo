package ru.supalias.service;

import ru.supalias.model.buisness.PokemonListDTO;

import java.io.IOException;

public interface PokeApiParserSecvice {
    public PokemonListDTO parsePokeApi() throws IOException;

}
