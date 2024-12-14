package com.example.cricketworldcup23;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity implements View.OnClickListener {
    EditText edt1,edt2;
    TextView txt,org;
    DBhelper DB;
    Button logbtn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txt=(TextView) findViewById(R.id.register);
        logbtn=(Button)findViewById(R.id.log);
        edt1=(EditText)findViewById(R.id.email);
        edt2=(EditText)findViewById(R.id.password);
        txt.setOnClickListener(this);
        logbtn.setOnClickListener(this);
        DB=new DBhelper(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.register){
            startActivity(new Intent(login.this,Registration.class));
        }
        else if(v.getId()==R.id.log){
            String email= edt1.getText().toString();
            String password= edt2.getText().toString();
            boolean ck=DB.checkMailPass(email,password);
            if(ck==true) {
                String name=DB.passName(email);
                Toast.makeText(login.this,"Successfully login",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(login.this,MainActivity2.class);
                intent.putExtra("tag",name);
                startActivity(intent);
            }
            else{
                Toast.makeText(login.this,"Incorrect Email and Password!",Toast.LENGTH_SHORT).show();
            }
        }
    }
}