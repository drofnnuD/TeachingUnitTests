package com.example.anothertestproject.test;

import java.util.ArrayList;
import java.util.List;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import com.example.anothertestproject.MainActivity;
import com.example.anothertestproject.database.SQLiteHelper;

public class QuickExampleTest extends ActivityInstrumentationTestCase2<MainActivity>{

	private MainActivity myActivity;
	List<String> tempList;
	
	public QuickExampleTest(){
		super(MainActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		myActivity = getActivity();
	}

	public void testPreconditions(){
		assertNotNull("MainActivity not null", myActivity);
	}
	
	public void testActivityLoadsProperly(){
		assertTrue(myActivity.getTitle().toString().equals("AnotherTestProject"));
	}
	
	public void testCreateMethod(){
		SQLiteHelper dbHelper = new SQLiteHelper(myActivity.getApplicationContext());
		tempList = dbHelper.getAllPeople();
		assertNotNull(tempList);
		assertTrue(tempList.get(0).equals("Matthew"));
	}
	
	public void testReadMethod(){
		SQLiteHelper dbHelper = new SQLiteHelper(myActivity.getApplicationContext());
		List<String> tempList = dbHelper.getAllPeople();
		assertEquals("Matthew", tempList.get(0));
	}
	
	public void testUpdateMethod(){
		SQLiteHelper dbHelper = new SQLiteHelper(myActivity.getApplicationContext());
		List<String> tempList = dbHelper.getAllPeople();
		assertEquals("Matthew", tempList.get(0));
		dbHelper.updateResult("1", "Test");
		List<String> secondList = dbHelper.getAllPeople();
		assertEquals("Test", secondList.get(0));
	}
	
	public void deleteMethodTest(){
		SQLiteHelper dbHelper = new SQLiteHelper(myActivity.getApplicationContext());
		List<String> tempList = new ArrayList<String>();
		assertEquals("Test", tempList.get(0));
		dbHelper.deleteResult("1");
		List<String> secondList = dbHelper.getAllPeople();
		assertTrue(secondList.isEmpty());
	}
	
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
