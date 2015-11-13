package com.tile.janv.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class CharacterDetailsActivity extends AppCompatActivity {

    private TextView characterName;
    private TextView characterDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_details);
        characterName = (TextView) findViewById(R.id.character_name);
        characterDescription = (TextView) findViewById(R.id.character_description);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        getWindow().setLayout((int)(dm.widthPixels * 0.8), (int)(dm.heightPixels * 0.8));

        //get character position
        int position = getIntent().getIntExtra(Constants.CHARACTER_POSITION, -1);
        if (position < 0) {
            throw new IllegalArgumentException("intent's extra needs character position");
        }

        CharacterDescription character = CharacterData.getCharacters().get(position);

        characterName.setText(character.name);
        characterDescription.setText(character.description);
    }

}
