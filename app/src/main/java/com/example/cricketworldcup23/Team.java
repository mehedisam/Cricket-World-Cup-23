package com.example.cricketworldcup23;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Team extends AppCompatActivity implements View.OnClickListener {
    TextView aus,afg,ban;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        aus=(TextView) findViewById(R.id.aus);
        afg=(TextView) findViewById(R.id.afg);
        ban=(TextView) findViewById(R.id.ban);
        aus.setOnClickListener(this);
        afg.setOnClickListener(this);
        ban.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.aus){
            startActivity(new Intent(Team.this,aus.class));
        }
        else if(v.getId()==R.id.afg){
            startActivity(new Intent(Team.this,afg.class));
        }
        else if(v.getId()==R.id.ban){
            startActivity(new Intent(Team.this,ban.class));
        }
    }
}