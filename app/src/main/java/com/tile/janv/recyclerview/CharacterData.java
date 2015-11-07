package com.tile.janv.recyclerview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by janv on 07-Nov-15.
 */
public class CharacterData {

    private CharacterData() {
    }

    private static final Integer[] characterPictures = {
            R.drawable.cerseilannister,
            R.drawable.jaqenhghar,
            R.drawable.missandei,
            R.drawable.petyrbaelish
    };
    private static final String[] characterNames = {
            "Cersei Lannister",
            "Jaqen H’ghar",
            "Missandei",
            "Petyr Baelish (\"Littlefinger\")"
    };
    private static final String[] characterDetails = {
            "Queen Regent of the Seven Kingdoms.",
            "",
            "Formerly a slave in Astapor.",
            "Beyond his official duties, he is the eyes and ears of King's Landing."
    };

    private static List<CharacterDescription> characters = new ArrayList<>();
    public static List<CharacterDescription> getCharacters() {
        if (characters.isEmpty()) {
            for (int i = 0; i < characterPictures.length; i++) {
                CharacterDescription cd = new CharacterDescription();
                cd.id = characterPictures[i];
                cd.name = characterNames[i];
                cd.description = characterDetails[i];
                characters.add(cd);
            }
        }
        return characters;
    }

}
