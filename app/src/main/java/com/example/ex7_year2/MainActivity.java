package com.example.ex7_year2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    /**
     *      @author ziv ankri address: za6200@bs.amalnet.k12.il
     *      * @version	    2022.3.1
     *      * @since       25/10/2023
     *      class will if the user click raw it will get the text from the res>raw file
     *      and put it in the text view and if he click text it will make the text view
     *      as the edit text that the user entered
     */
    private final String FILENAME = "rawtest.txt";

    TextView textView1;
    EditText textInput1;
    Button raw1;
    Button textButton;
    Intent credits;

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

        credits = new Intent(this, credits.class);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        /**
         * function will make the option menu
         * param menu: the menu
         */
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        /**
         * function will check if the user clicked the credit button and if he did it will get him to the credits screen
         * param item: the item clicked
         */
        String st = item.getTitle().toString();
        if(st.equals("credit"))
        {
            startActivity(credits);
        }
        return super.onOptionsItemSelected(item);
    }
    public void raw(View view) {
        /**
         * function will make the edit text content as the file in the res>raw
         * param view: when button clicked
         */
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
        /**
         * function will make the text view as the text that the user entered in the edit text
         * param view: when the button clicked
         */
        String userInputText = textInput1.getText().toString();
        textView1.setText(userInputText);
    }
}
