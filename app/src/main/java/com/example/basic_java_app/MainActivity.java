package com.example.basic_java_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//-------------------------------------------------------------------
// Im not much of a main function! Go see activity_lobby.java
//-------------------------------------------------------------------
public class MainActivity extends AppCompatActivity {
    static String T1 = "EnterActivity";
    static String tv_str = "Welcome!";
    static String tv_fill = "!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Start Code Area
        Log.i(T1, "Enter Activity Started");

        // Define Vars
        Button B1 = (Button)(findViewById(R.id.b_Enter));
        TextView TV1 = (TextView)(findViewById(R.id.tv_welcome));


        // Refresh elements
        TV1.setText(buildRepeat(tv_fill) );

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
    
    protected String buildRepeat(String filler){
        // Replate string.repeat()
        String tv_temp = tv_str;

        // Iterate to visits
        for(int x = 0; x < Lobby.visits; x++ ){
            // Might be targeting too low of version
            // No String.repeat
            tv_temp = tv_temp + filler;
        }

        return  tv_temp;
    }
}