package com.example.basic_java_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

public class Lobby extends AppCompatActivity {
    static String T1 = "LobbyActivity";
    static String visits_s1 = "You've been here ";
    static String visits_s2 = " times this session.";
    static Integer visits = 0;

    static String[] replys = {"~", "Oof","Yeaaah :/", "Yay!","<3 Thank you!", "You're too kind! ^,^"}; // 6 options

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);
        // Start Code Area
        Log.i(T1, "Lobby Activity Started");

        //Define functionality
        refreshVisits();
        doUpdateRating();

    }

    public void gotoMain(View view){
        Log.i(T1, "B2 Clicked, Visits =" + addVisit());

        // Setup intent
        Intent i;
        i = new Intent(Lobby.this, MainActivity.class);
        // Change page
        Lobby.this.startActivity(i);
    }


    protected void doResetVisits(View view){
        // The onClick function of the button
        Log.i(T1, "Visits Reset");

        visits = 0;
        refreshVisits();
    }

    protected void refreshVisits(){
        // Force a refresh
        Log.i(T1, "Visits Refreshed");
        ProgressBar Visit_PB = (ProgressBar)(findViewById(R.id.pb_visits));
        TextView Visit_TV = (TextView)(findViewById(R.id.tv_counter));

        Visit_PB.setProgress(visits);
        Visit_TV.setText(visits_s1 + visits + visits_s2);
    }

    protected Integer addVisit(){
        Log.i(T1, "Visits increased");

        visits++; // Increase visits

        refreshVisits();

        return visits;
    }

    protected void doUpdateRating(){
        // Someone just clicked the rating bar
        // Update rating text
        Log.i(T1, "Ratings Reply refreshed");
        RatingBar RB1 = (RatingBar)(findViewById(R.id.rating));
        TextView TV1 = (TextView)(findViewById(R.id.tv_rating_reply));
        long stars = (long)Math.ceil(RB1.getNumStars());
        String reply_s = "~ ~";

        // Index string
        reply_s = replys[(int)stars];
        TV1.setText(reply_s);

    }

}