package com.example.tanny.androidtests;

import android.test.suitebuilder.TestSuiteBuilder;

import junit.framework.TestSuite;

/**
 * TestSuite
 * Created by Tanny on 30/06/2014.
 */
public class MyTestSuite extends TestSuite {

    public static TestSuite suite() {
        return new TestSuiteBuilder(MyTestSuite.class)
                .includeAllPackagesUnderHere()
                .build();
    }
}
