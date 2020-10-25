package com.example.basic_java_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    static String T1 = "EnterActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Start Code Area
        Log.i(T1, "Enter Activity Started");

        // Define Vars
        Button B1 = (Button)(findViewById(R.id.b_Enter));

        //Define functionality
        B1.setOnClickListener(new View.OnClickListener(){
            // Create a lambda just cause
            @Override
            public void onClick(View v) {
                Log.i(T1, "B1 Clicked, Going to Lobby");

                Intent i;
                i = new Intent(MainActivity.this, Lobby.class);
                // Change page
                MainActivity.this.startActivity(i);
            }
        });

    }
}