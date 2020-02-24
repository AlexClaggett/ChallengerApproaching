package com.example.challengerapproaching;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.challengerapproaching.Characters.Banjo_Kazooie;

public class MainActivity extends AppCompatActivity {
 Button banjoKazooie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        banjoKazooie = (Button)findViewById(R.id.banjoKazooie);
        banjoKazooie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Banjo_Kazooie.class);
                startActivity(i);
            }
        });
    }
}
