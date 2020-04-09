package com.example.challengerapproaching.utils;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.challengerapproaching.R;

public class EditDataActivity extends AppCompatActivity {

    private static final String TAG = "EditDataActivity";

    private Button btnSave, btnDelete;
    private EditText editable_item;
     databaseHelper eventDatabase;

     private String selectedName;
     private int selectedId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_data_layout);
        btnSave = findViewById(R.id.savebtn);
        btnDelete = findViewById(R.id.delbtn);
        editable_item = findViewById(R.id.editable_item);
        eventDatabase = new databaseHelper(this);

        Intent receivedIntent = getIntent();
        selectedId = receivedIntent.getIntExtra("id",-1);
        selectedName = receivedIntent.getStringExtra("name");
        editable_item.setText(selectedName);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = editable_item.getText().toString();
                if(!item.equals("")){
                    eventDatabase.updateName(item, selectedId, selectedName);
                }
                else{
                    toastMessage("You must enter a name");
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventDatabase.deleteEvent(selectedId,selectedName);
                editable_item.setText("");
                toastMessage("removed from database");
            }
        });
    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
