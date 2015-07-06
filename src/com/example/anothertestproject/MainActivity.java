package com.example.anothertestproject;

import com.example.anothertestproject.database.SQLiteHelper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button createButton;
	Button readButton;
	Button updateButton;
	Button deleteButton;
	SQLiteHelper dbHelper = new SQLiteHelper(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		createButton = (Button)findViewById(R.id.create_button);
		
		createButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dbHelper.insetNameToDB();
				Toast.makeText(getApplicationContext(), "Insert", Toast.LENGTH_LONG).show();
			}
		});
	}

}
