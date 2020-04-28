package com.example.hw4;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.squareup.spoon.Spoon;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsAnything.anything;
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class DashboardTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(DashboardActivity.class);

    @Test
    public void clickListViewByPositionTwo(){
        onData(anything()).atPosition(2).perform(click());
        onView(withId(R.id.description_name))
                .check(matches(withText(containsString("Screen"))));
        onView(withId(R.id.description))
                .check(matches(withText(containsString("screen"))));
        Spoon.screenshot( mActivityRule.getActivity(), "hasScreen");
    }

    @Test
    public void clickListViewByPositionFour(){
        onData(anything()).atPosition(4).perform(click());
        onView(withId(R.id.description_name))
                .check(matches(withText(containsString("Keyboard"))));
        onView(withId(R.id.description))
                .check(matches(withText(containsString("keyboard"))));
        Spoon.screenshot( mActivityRule.getActivity(), "hasKeyboard");
    }
}
