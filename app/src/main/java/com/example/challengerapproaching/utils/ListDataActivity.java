package com.example.challengerapproaching.utils;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.challengerapproaching.EventsActivity;
import com.example.challengerapproaching.R;
import java.util.ArrayList;

public class ListDataActivity extends AppCompatActivity {
  private static final String TAG = "ListDataActivity";

  DatabaseHelper eventDatabase;
  private ListView eventsList;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.list_layout);
    eventsList = findViewById(R.id.list_view);
    eventDatabase = new DatabaseHelper(this);

    populateListView();
  }

  private void populateListView() {
    Log.d(TAG, "populateListView: Displaying data in the ListView.");

    ArrayList<Event> eventList;
    eventList = eventDatabase.getAllData();
    ArrayList<String> eventTitle = new ArrayList<>();
    for (int i = 0; i < eventList.size(); i++) {
      eventTitle.add(eventList.get(i).getName() + "\n" + eventList.get(i).getDate());
    }

    if (eventList.size() != 0) {
      Log.d(TAG, "Peek at array list: " + eventList.toString());
    }
    ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, eventTitle){
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view = super.getView(position, convertView, parent);
            TextView textView = (TextView) view.findViewById(android.R.id.text1);

            textView.setTextColor(Color.WHITE);
            textView.setTextSize(30);
            return view;
        }
    };
    eventsList.setAdapter(adapter);
    ArrayList<Event> finalEventList = eventList;
    eventsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            String name = (finalEventList.get(i).getName());
            String date = (finalEventList.get(i).getDate());
            Log.d(TAG, "onItemClick: You Clicked on " + eventTitle.get(i));

            Cursor data = eventDatabase.getDateID(date);
            int itemID = -1;
            while (data.moveToNext()) {
              itemID = data.getInt(0);
            }
            if (itemID > -1) {
            Log.d(TAG, "onItemClick: The ID is: " + itemID);
            Intent editScreenIntent = new Intent(ListDataActivity.this, EditDataActivity.class);
            editScreenIntent.putExtra("id", itemID);
            editScreenIntent.putExtra("name", name);
            editScreenIntent.putExtra("date", date);
            Log.d(TAG, "attempting to start edit screen");
            Intent intent = getIntent();
            startActivityForResult(editScreenIntent, 1);
            } else {
            toastMessage("No ID associated with that name");
            }
        }
    });
  }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 0){
            finish();
            this.setResult(0);
        }
    }

    private void toastMessage(String message) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
  }
}
