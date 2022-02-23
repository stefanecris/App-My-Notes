package com.stefane.mynotes;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText textNote;
    private String text;
    private NotesPreferences note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textNote = findViewById(R.id.textNote);

        note = new NotesPreferences(getApplicationContext());

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text = textNote.getText().toString();

                if(isFilled(text)){
                    note.saveNote(text);
                    Toast.makeText(getApplicationContext(), "Note successfully saved!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Note wasn't saved!", Toast.LENGTH_LONG).show();
                }

            }
        });

        String recoveredText = note.getNote();

        textNote.setText(recoveredText);

    }

    public Boolean isFilled(String text){
        if(text == null || text.equals("")){
            return false;
        }
        return true;
    }

}
