package com.example.constructor;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class login extends AppCompatActivity {

    Button btnLogin;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Window window=getWindow();

        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.myStatusBar));
      /*  if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            window.setStatusBarColor(getColor(R.color.myStatusBar));
        }
        else {
            window.setStatusBarColor(getResources().getColor(R.color.myStatusBar));
        }*/


        btnLogin=findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Home.class);
                startActivity(intent);
                /*Toast toast= Toast.makeText(getApplicationContext(),"hellow",Toast.LENGTH_SHORT);
                toast.show();*/

            }
        });
    }
}
