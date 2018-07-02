package com.example.clair.ahbot;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

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

    public static void deleteCache(Context context) {
        try {
            File dir = context.getCacheDir();
            deleteDir(dir);
        } catch (Exception e) {
        }
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if (dir != null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }

    @Override
    protected void onDestroy() {
        deleteCache(this);
        super.onDestroy();
    }
}
