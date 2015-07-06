package com.example.anothertestproject;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.anothertestproject.database.SQLiteHelper;

public class MainActivity extends Activity {

	Button createButton;
	Button readButton;
	Button updateButton;
	Button deleteButton;
	SQLiteHelper dbHelper = new SQLiteHelper(this);
	List<String> tempList = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		createButton = (Button)findViewById(R.id.create_button);
		
		createButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dbHelper.insetNameToDB();
				tempList = dbHelper.getAllPeople();
				Log.d("test1", tempList.get(0));
				Toast.makeText(getApplicationContext(), "Insert", Toast.LENGTH_LONG).show();
			}
		});
		
		updateButton = (Button)findViewById(R.id.update_button);
		
		updateButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dbHelper.updateResult("1", "Test");
				tempList = dbHelper.getAllPeople();
				Log.d("Test2", tempList.get(0));
			}
		});
	}

}
