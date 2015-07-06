package com.example.anothertestproject.database;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 
 * @author MDunn
 *
 */
public class SQLiteHelper extends SQLiteOpenHelper{

	//db name and version
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
		//creates the good stuff
		db.execSQL(CREATE_TABLE_PEOPLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//drops the good stuff
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PEOPLE);
		db.close();
	}
	
	/**
	 * Adds a name into the DB, simple right?
	 * Hard coded data because I'm lazy
	 */
	public void insetNameToDB(){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(PEOPLE_FIRST_NAME, "Matthew");
		db.insert(TABLE_PEOPLE, null, values);
	}
	
	/**
	 * Returns a String list of all the first names in the database, again, simple right?
	 * @return full list of people in DB
	 */
	public List<String> getAllPeople(){
		//List where people are added
		List<String> allPeople = new ArrayList<String>();
		//sql statement to be exec
		String statement = "SELECT * FROM " + TABLE_PEOPLE;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(statement, null);
		while(cursor.moveToNext()){
			//adding values to list
			allPeople.add(cursor.getString(1));
		}
		db.close();
		return allPeople;
	}
	
	/**
	 * Updates a row with a new name 
	 * @param passedID ID of the col to be updated
	 * @param newNameValue new value to be inserted
	 */
	public void updateResult(String passedID, String newNameValue){
		SQLiteDatabase dbHelper = this.getWritableDatabase();
		String sqlStatement = "UPDATE " + TABLE_PEOPLE +
				" SET " + PEOPLE_FIRST_NAME + " = \"" + newNameValue 
				+ "\" WHERE " + PEOPLE_ID + " = " + passedID + ";";
		dbHelper.execSQL(sqlStatement);
		dbHelper.close();
	}
	
	/**
	 * Deletes a result passed on an ID being passed to it, not difficult is it
	 * @param passedID duh
	 */
	public void deleteResult(String passedID){
		SQLiteDatabase dbHelper = this.getWritableDatabase();
		String sqlStatemnt = "DELETE FROM " + TABLE_PEOPLE + " WHERE " +
				PEOPLE_ID + " = " + passedID;
		dbHelper.execSQL(sqlStatemnt);
		dbHelper.close();
	}
	
}
