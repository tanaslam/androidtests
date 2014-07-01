package com.example.tanny.androidtests.test;

import android.content.pm.ApplicationInfo;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.SmallTest;

import com.example.tanny.androidtests.MyApp;
import com.example.tanny.androidtests.R;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<MyApp> {

    public ApplicationTest() {
        super(MyApp.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        createApplication();
    }

    @SmallTest
    public void testApplicationConfig() {
        ApplicationInfo appInfo = getApplication().getApplicationInfo();
        assertEquals("App icon is different than expected",
                appInfo.icon, R.drawable.ic_launcher);
        assertFalse("allowBackup fag is false",
                (appInfo.flags & ApplicationInfo.FLAG_ALLOW_BACKUP) == 0);

        if(BuildConfig.DEBUG) {
            assertTrue("Application is not debuggable",
                (appInfo.uiOptions & ApplicationInfo.FLAG_DEBUGGABLE) == 0);
        } else {
            assertTrue("Application is debuggable",
                    (appInfo.uiOptions & ApplicationInfo.FLAG_DEBUGGABLE) != 0);
        }
    }

    @Override
    protected void tearDown() throws Exception {
        terminateApplication();
        super.tearDown();
    }
}