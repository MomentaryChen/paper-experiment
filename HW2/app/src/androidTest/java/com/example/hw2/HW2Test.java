package com.example.hw2;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.squareup.spoon.Spoon;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.getIdlingResources;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class HW2Test {
  @Rule
  public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

  @Test
  public void account(){
    TextView feedback = mActivityRule.getActivity().findViewById(R.id.feedbackTextView);
    onView(withId(R.id.register)).perform(click());
    assertEquals(feedback.getText().toString(), "Account caanot be empty.");

    onView(withId(R.id.editAccount)).perform(typeText("zxcv123456"), closeSoftKeyboard());
    onView(withId(R.id.register)).perform(click());
    assertEquals(feedback.getText().toString(), "Account error format");
  }


  @Test
  public void password(){
    onView(withId(R.id.editAccount)).perform(typeText("zxcv123456@gmail.com"), closeSoftKeyboard());
    TextView feedback = mActivityRule.getActivity().findViewById(R.id.feedbackTextView);
    onView(withId(R.id.register)).perform(click());
    assertEquals(feedback.getText().toString(), "Password caanot be empty.");

    onView(withId(R.id.register)).perform(click());
    onView(withId(R.id.editPassword)).perform(typeText("zzxc456"), closeSoftKeyboard());
    assertEquals(feedback.getText().toString(), "Password length is greater than 8");

    onView(withId(R.id.register)).perform(click());
    onView(withId(R.id.editPassword)).perform(typeText("zzxcasddadsa"), closeSoftKeyboard());
    assertEquals(feedback.getText().toString(), "Password need include a number or more");

    onView(withId(R.id.register)).perform(click());
    onView(withId(R.id.editPassword)).perform(typeText("zzxc4564564"), closeSoftKeyboard());
    assertEquals(feedback.getText().toString(), "Password need include a capital English or more");
  }

  @Test
  public void comfirm(){

    onView(withId(R.id.editAccount)).perform(typeText("zxcv123456@gmail.com"), closeSoftKeyboard());
    onView(withId(R.id.editPassword)).perform(typeText("Zzxcv123456"), closeSoftKeyboard());


    TextView feedback = mActivityRule.getActivity().findViewById(R.id.feedbackTextView);
    onView(withId(R.id.register)).perform(click());
    assertEquals(feedback.getText().toString(), "Comfirm password cannot be empty.");

    onView(withId(R.id.editCheck)).perform(typeText("Zzxcv12356"), closeSoftKeyboard());
    onView(withId(R.id.register)).perform(click());
    assertEquals(feedback.getText().toString(), "Comfirm password is not the same.");
  }
}
