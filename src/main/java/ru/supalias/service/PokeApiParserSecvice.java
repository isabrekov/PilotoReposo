package ru.supalias.service;

import ru.supalias.model.buisness.PokemonsListDTO;

import java.io.IOException;

public interface PokeApiParserSecvice {
    public PokemonsListDTO parsePokeApi() throws IOException;

}
