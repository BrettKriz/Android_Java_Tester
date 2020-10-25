package com.example.basic_java_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Lobby extends AppCompatActivity {
    static String T1 = "LobbyActivity";
    static String visits_s1 = "You've been here ";
    static String visits_s2 = " times this session.";
    static Integer visits = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);
        // Start Code Area
        Log.i(T1, "Lobby Activity Started");

        // Define Vars
        Button B2 = (Button)(findViewById(R.id.b_GotoMain));
        TextView Visit_TV = (TextView)(findViewById(R.id.tv_counter));

        //Define functionality
        Visit_TV.setText(visits_s1 + visits + visits_s2);

        B2.setOnClickListener(new View.OnClickListener(){
            // Lambda functions anyone?
            @Override
            public void onClick(View v) {
                Log.i(T1, "B2 Clicked, Visits =" + addVisit());

                // Setup intent
                Intent i;
                i = new Intent(Lobby.this, MainActivity.class);
                // Change page
               Lobby.this.startActivity(i);
            }
        });
    }

    protected void doResetVisits(View view){
        // The onClick function of the button
        visits = 0;
        Log.i(T1, "Visits Reset");
    }

    protected Integer addVisit(){
       return ++visits;
    }
}