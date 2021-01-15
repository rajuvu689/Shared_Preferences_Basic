package com.rtsoftworld.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button saveButton;
    private EditText enterText;
    private TextView resultText;
    private SharedPreferences myPrefs;
    private static final String PREFS_NAME = "myPrefsFile";  //xml file name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveButton = findViewById(R.id.saveButton);
        enterText = findViewById(R.id.enterText);
        resultText = findViewById(R.id.resultText);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myPrefs = getSharedPreferences(PREFS_NAME,0); //mode 0 = file is accessible
                SharedPreferences.Editor editor = myPrefs.edit(); // allow us to edit myPrefs

                editor.putString("message", enterText.getText().toString()); //put string as message
                editor.commit(); //save the input string
            }
        });

        // show the saved data
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME,0);

        if (prefs.contains("message")){
            String message = prefs.getString("message","Not found any message");
            resultText.setText("message: "+ message);
        }

    }
}