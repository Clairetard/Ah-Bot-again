package com.example.clair.ahbot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnMedProfile, btnMedicine,btnSchedule,btnRecipe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMedProfile=findViewById(R.id.btnViewMedProfile);
        btnMedicine=findViewById(R.id.btnViewMedicine);
        btnSchedule=findViewById(R.id.btnSchedule);
        btnRecipe=findViewById(R.id.btnRecipe);
        btnMedProfile.setOnClickListener(this);
        btnMedicine.setOnClickListener(this);
        btnSchedule.setOnClickListener(this);
        btnRecipe.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        Intent i;
        switch (v.getId()){
            case R.id.btnViewMedProfile:
            i=new Intent(MainActivity.this,MedProfile.class);
                startActivity(i);
                break;
            case R.id.btnViewMedicine:
                i=new Intent(MainActivity.this,MedProfile.class);
                startActivity(i);
                break;
            case R.id.btnSchedule:
                i=new Intent(MainActivity.this,Schedule.class);
                startActivity(i);
                break;
            case R.id.btnRecipe:
                i=new Intent(MainActivity.this,MedProfile.class);
                startActivity(i);
                break;
        }
    }
}
