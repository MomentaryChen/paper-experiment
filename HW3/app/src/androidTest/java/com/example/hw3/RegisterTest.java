package com.example.hw3;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.squareup.spoon.Spoon;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class RegisterTest {
    @Rule
    public ActivityTestRule<RegisterActivity> mActivityRule = new ActivityTestRule(RegisterActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.hw3", appContext.getPackageName());
    }

    @Test
    public void clickRegister(){
        TextView text= (TextView) mActivityRule.getActivity().findViewById(R.id.feedbackTextView);
        Spoon.screenshot( mActivityRule.getActivity(), "PreClickRegister");
        onView(withId(R.id.register)) // Matcher
                .perform(click()); // Action

        Spoon.screenshot( mActivityRule.getActivity(), "AfterClickRegister");
        assertEquals(text.getText().toString(), "Account cannot be empty.");
    }
    @Test
    public void inputAccountAndClickRegister(){
        TextView text= (TextView) mActivityRule.getActivity().findViewById(R.id.feedbackTextView);

        onView(withId(R.id.editAccount))
                .perform(typeText("zxcv1234@gmail.com"),closeSoftKeyboard());

        Spoon.screenshot( mActivityRule.getActivity(), "PreInputAccount");

        onView(withId(R.id.register)) // Matcher
                .perform(click()); // Action

        Spoon.screenshot( mActivityRule.getActivity(), "AfterInputAccount");
        assertEquals(text.getText().toString(), "Password cannot be empty.");
    }

    @Test
    public void inputPasswordAndClickRegister(){
        TextView text= (TextView) mActivityRule.getActivity().findViewById(R.id.feedbackTextView);
        Spoon.screenshot( mActivityRule.getActivity(), "PreInputAccount");

        onView(withId(R.id.editAccount))
                .perform(typeText("zxcv1234@gmail.com"),closeSoftKeyboard());
        onView(withId(R.id.editPassword))
                .perform(typeText("zxcv4561234"),closeSoftKeyboard());
        EditText password = (EditText)mActivityRule.getActivity().findViewById(R.id.editPassword);

        onView(withId(R.id.register)) // Matcher
                .perform(click()); // Action

        Spoon.screenshot( mActivityRule.getActivity(), "AfterInputAccount");
        assertEquals(text.getText().toString(), "Password need include a capital English or more");
    }
}
