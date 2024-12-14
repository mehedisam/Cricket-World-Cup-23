package com.example.cricketworldcup23;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    TextView txt;
    Button fixture,news,team,point,stadium,stat;
    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt=(TextView)findViewById(R.id.txt);
        fixture=(Button) findViewById(R.id.fixture);
        team=(Button)findViewById(R.id.team);
        news=(Button)findViewById(R.id.news);
        point=(Button)findViewById(R.id.point);
        stadium=(Button)findViewById(R.id.stadium);
        fixture.setOnClickListener(this);
        news.setOnClickListener(this);
        team.setOnClickListener(this);
        point.setOnClickListener(this);
        stadium.setOnClickListener(this);
        Bundle bundle=getIntent().getExtras();
        String nam=bundle.getString("tag");
        txt.setText("Hello "+nam+"!!!");
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.fixture){
            startActivity(new Intent(MainActivity2.this,Fixture.class));
        }
        else if(v.getId()==R.id.team){
            startActivity(new Intent(MainActivity2.this,Team.class));
        }
        else if(v.getId()==R.id.point){

        }
        else if(v.getId()==R.id.stadium){

        }
        else if(v.getId()==R.id.news){
            startActivity(new Intent(MainActivity2.this,news.class));
        }
    }
}