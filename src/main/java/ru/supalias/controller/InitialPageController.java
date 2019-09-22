package ru.supalias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.supalias.model.buisness.PokemonsListDTO;
import ru.supalias.service.impl.PokeApiParserServiceImpl;

import java.io.IOException;

@Controller
public class InitialPageController {

    @Autowired
    PokeApiParserServiceImpl pokeApiParserService;

    @GetMapping("/")
    public String initialPageLoad() throws IOException{
        PokemonsListDTO pokemonsListDTO = pokeApiParserService.parsePokeApi();
        return "lol";
    }

}
