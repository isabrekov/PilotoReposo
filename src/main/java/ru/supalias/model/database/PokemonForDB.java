package ru.supalias.model.database;

import lombok.Data;

import java.util.List;

@Data
public class PokemonForDB {
    private List<AbilityForDB> abilityForDBList;
    private int id;
    private String name;
}
