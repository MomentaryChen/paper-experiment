package com.example.hw3;

import android.app.Activity;
import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import androidx.test.runner.lifecycle.Stage;
import com.squareup.spoon.Spoon;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import java.util.Collection;
import java.util.Iterator;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class LoginTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);
    public ActivityTestRule<DashboardActivity> dashboardActivityTestRule = new ActivityTestRule(DashboardActivity.class);

    private Activity getActivityInstance() {
        final Activity[] currentActivity = {null};

        getInstrumentation().runOnMainSync(new Runnable() {
            public void run() {
                Collection<Activity> resumedActivity =
                  ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(
                    Stage.RESUMED);
                Iterator<Activity> it = resumedActivity.iterator();
                currentActivity[0] = it.next();
            }
        });

        return currentActivity[0];
    }

    @Test
    public void loginFailure(){
        TextView text= (TextView) mActivityRule.getActivity().findViewById(R.id.warning);
        onView(withId(R.id.login)) // Matcher
                .perform(click()); // Action
        Spoon.screenshot( mActivityRule.getActivity(), "LoginFailure");
        assertEquals(text.getText().toString(), mActivityRule.getActivity().getResources().getString(R.string.error));
    }

    @Test
    public void loginSuccessful(){

        // Step1 Click register button
        onView(withId(R.id.register)) // Matcher
                .perform(click()); // Action

        // Step2 Input account
        onView(withId(R.id.editAccount))
                .perform(typeText("zxcv1234@gmail.com"),closeSoftKeyboard());

        // Step3 Input password
        onView(withId(R.id.editPassword))
                .perform(typeText("Zxcv123456"),closeSoftKeyboard());

        // Step4Check password
        onView(withId(R.id.editCheck))
                .perform(typeText("Zxcv123456"),closeSoftKeyboard());

        // Step5 Click manRadioButton
        onView(withId(R.id.manRadioButton))
                .perform(click());

        // Step6 Click interset sleep
        onView(withId(R.id.sleep))
                .perform(click());

        // Step7 Click register
        onView(withId(R.id.register))
                .perform(click());

        // Step8 Input Account and Password
        onView(withId(R.id.editAccount))
                .perform(typeText("zxcv1234@gmail.com"),closeSoftKeyboard());
        onView(withId(R.id.editPassword))
                .perform(typeText("Zxcv123456"),closeSoftKeyboard());

        // Step9 Click login
        onView(withId(R.id.login))
                .perform(click());

        // Step10 Change to dashboard
        onView(withId(R.id.loginTextView)).check(matches(withText("Login Successful")));

        Spoon.screenshot( getActivityInstance(), "LoginSuccessful");
    }
}