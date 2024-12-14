package com.example.cricketworldcup23;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class Registration extends AppCompatActivity implements View.OnClickListener {
    DBhelper DB  ;
    EditText uName,uPass,uMail,uConPass,dob;
    Button reg;
    DatePickerDialog picker;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        reg=(Button) findViewById(R.id.register);
        uName = (EditText) findViewById(R.id.username);
        uMail = (EditText) findViewById(R.id.email);
        dob= (EditText) findViewById(R.id.dob);
        uPass = (EditText) findViewById(R.id.password);
        uConPass = (EditText) findViewById(R.id.repassword);
        DB = new DBhelper(this);
        reg.setOnClickListener(this);
        dob.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.register){
            String name= uName.getText().toString();
            String email= uMail.getText().toString();
            String pass= uPass.getText().toString();
            String cpass= uConPass.getText().toString();
            if(name.equals("") || email.equals("") || pass.equals("")  ){
                Toast.makeText(Registration.this, "Please,Fillup all the fields", Toast.LENGTH_SHORT).show();
            }
            else{
                if(pass.equals(cpass) && email_validate(email)){
                    boolean ck = DB.checkMail(email);
                    if(ck==false){
                        boolean insert = DB.insertuserdata(name,email,pass);
                        Intent intent=new Intent(Registration.this,login.class);
                        startActivity(intent);
                        Toast.makeText(Registration.this,"Registration Successful! Now Login with Email and Password",Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(Registration.this, "User Already Exist. Enter New Email", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(Registration.this, "Password Doesn't match or invalid email", Toast.LENGTH_SHORT).show();
                }
            }
        }
        if(v.getId()==R.id.dob){
            final Calendar calendar= Calendar.getInstance();
            int day=calendar.get(Calendar.DAY_OF_MONTH);
            int month= calendar.get(Calendar.MONTH);
            int year=calendar.get(Calendar.YEAR);
            picker=new DatePickerDialog(Registration.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    dob.setText(dayOfMonth + "/" + (month+1) + "/" + year);
                }
            },year,month,day);
            picker.show();
        }
    }
    boolean email_validate(String email) {
        if( Patterns.EMAIL_ADDRESS.matcher(email).matches() )
            return true;
        else
            return false;
    }
}