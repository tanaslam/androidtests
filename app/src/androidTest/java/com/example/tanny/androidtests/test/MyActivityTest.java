package com.example.tanny.androidtests.test;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.MediumTest;

import com.example.tanny.androidtests.MyActivity_;

/**
 * Class to test {@link com.example.tanny.androidtests.MyActivity_}
 * Created by Tanny on 29/06/2014.
 */
public class MyActivityTest extends ActivityInstrumentationTestCase2<MyActivity_> {

	MyActivity_ activity;

	public MyActivityTest() {
		super(MyActivity_.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		activity = getActivity();
	}

    @MediumTest
	public void testActivityInstance() {
		assertTrue(activity != null);
	}
}
