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

/**
 * 
 * @author MDunn
 *
 */
public class MainActivity extends Activity {

	//only button needed to add something to the DB initally so that it can be tested
	Button createButton;

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
				//adding value to db when clicked
				dbHelper.insetNameToDB();
				tempList = dbHelper.getAllPeople();
				Toast.makeText(getApplicationContext(), "Insert", Toast.LENGTH_LONG).show();
			}
		});
		
	}

}
