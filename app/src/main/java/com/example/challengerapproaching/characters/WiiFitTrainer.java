package com.example.challengerapproaching.characters;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;

/** This class sets the content view to Wii Fit Trainer's xml
 * file when the respective button is pushed.*/

public class WiiFitTrainer extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_wii__fit__trainer);
  }
}
