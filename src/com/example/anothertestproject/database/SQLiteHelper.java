package com.example.anothertestproject.database;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper{

	private static final String DATABASE_NAME = "Testdb";
	private static final int DATABASE_VERSION = 1;
	//table name to be created
	private static final String TABLE_PEOPLE = "people";
	//columns to be added to table
	private static final String PEOPLE_ID = "_id";
	private static final String PEOPLE_FIRST_NAME = "first_name";
	//SQL statement to create table
	private static final String CREATE_TABLE_PEOPLE = "CREATE TABLE " +
			TABLE_PEOPLE + "( " + PEOPLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ PEOPLE_FIRST_NAME + " TEXT NOT NULL)";
	
	public SQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_PEOPLE);
		db.close();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PEOPLE);
		db.close();
	}
	
	public void insetNameToDB(){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(PEOPLE_FIRST_NAME, "Matthew");
		db.insert(TABLE_PEOPLE, null, values);
		db.close();
	}
	
	public List<String> getAllPeople(){
		
		List<String> allPeople = new ArrayList<String>();
		String statement = "SELECT * FROM " + TABLE_PEOPLE;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(statement, null);
		while(cursor.moveToNext()){
			allPeople.add(cursor.getString(1));
		}
		return allPeople;
	}
	

}
