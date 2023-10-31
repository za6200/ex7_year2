package com.example.ex7_year2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private final String FILENAME = "rawtest.txt";

    TextView textView1;
    EditText textInput1;
    Button raw1;
    Button textButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.textView);
        textInput1 = findViewById(R.id.textInput);
        raw1 = findViewById(R.id.raw);
        textButton = findViewById(R.id.text1);
        textView1.setText("text view");
        textInput1.setText("");




    }

    public void raw(View view) {
        try {
            String fileName = FILENAME.substring(0, FILENAME.length() - 4);
            int resourceId = getResources().getIdentifier(fileName, "raw", getPackageName());
            InputStream iS = getResources().openRawResource(resourceId);
            InputStreamReader iSR = new InputStreamReader(iS);
            BufferedReader bR = new BufferedReader(iSR);
            StringBuilder sB = new StringBuilder();
            String line;

            while ((line = bR.readLine()) != null) {
                sB.append(line + '\n');
            }
            textView1.setText(sB.toString());
        } catch (Exception e) {
            Toast.makeText(this, "Error reading the file", Toast.LENGTH_SHORT).show();
        }

    }

    public void text(View view) {
        String userInputText = textInput1.getText().toString();
        textView1.setText(userInputText);
    }
}
