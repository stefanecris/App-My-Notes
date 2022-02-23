package com.stefane.mynotes;

import android.content.Context;
import android.content.SharedPreferences;

public class NotesPreferences {

    private Context context;
    private static final String FILE_PREFERENCES = "filePreferences";
    private static final String TEXT_KEY = "text";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public NotesPreferences(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(FILE_PREFERENCES, 0);
        editor = sharedPreferences.edit();
    }

    public void saveNote(String text){

        editor.putString(TEXT_KEY, text);
        editor.commit();

    }

    public String getNote(){

        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_PREFERENCES, 0);

        return sharedPreferences.getString(TEXT_KEY, "Nothing to show");

    }

}
