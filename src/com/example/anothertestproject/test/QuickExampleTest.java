package com.example.anothertestproject.test;

import com.example.anothertestproject.MainActivity;

import android.test.ActivityInstrumentationTestCase2;

public class QuickExampleTest extends ActivityInstrumentationTestCase2<MainActivity>{

	private MainActivity myActivity;
	
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
	
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
