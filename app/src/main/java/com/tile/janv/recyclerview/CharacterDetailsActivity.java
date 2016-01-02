package com.tile.janv.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CharacterDetailsActivity extends AppCompatActivity {

    @Bind(R.id.character_name)
    protected TextView characterName;
    @Bind(R.id.character_description)
    protected TextView characterDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_details);
        ButterKnife.bind(this);

        // set the activity height and width to be 80% of screen size
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        getWindow().setLayout((int)(dm.widthPixels * 0.8), (int)(dm.heightPixels * 0.8));

        //get character position from extra
        int position = getIntent().getIntExtra(Constants.CHARACTER_POSITION, -1);
        if (position < 0) {
            throw new IllegalArgumentException("intent's extra needs character position");
        }

        CharacterDescription character = CharacterData.getCharacters().get(position);

        characterName.setText(character.name);
        characterDescription.setText(character.description);
    }
}
