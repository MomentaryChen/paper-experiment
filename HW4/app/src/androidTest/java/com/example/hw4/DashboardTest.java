package com.example.hw4;

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

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsAnything.anything;
import static org.junit.Assert.assertEquals;
import java.util.Collection;
import java.util.Iterator;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class DashboardTest {
  @Rule
  public ActivityTestRule<MainActivity> mActivityRule =
    new ActivityTestRule(DashboardActivity.class);

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
  public void clickListViewByPositionZero() {
    onData(anything()).atPosition(0).perform(click());
    onView(withId(R.id.description_name))
      .check(matches(withText(containsString("TV"))));
    onView(withId(R.id.description))
      .check(matches(withText(containsString("TV"))));
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void clickListViewByPositionOne() {
    onData(anything()).atPosition(1).perform(click());
    onView(withId(R.id.description_name))
      .check(matches(withText(containsString("Computer"))));
    onView(withId(R.id.description))
      .check(matches(withText(containsString("computer"))));
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void clickListViewByPositionTwo() {

    onData(anything()).atPosition(2).perform(click());
    onView(withId(R.id.description_name))
      .check(matches(withText(containsString("Screen"))));
    onView(withId(R.id.description))
      .check(matches(withText(containsString("screen"))));
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void clickListViewByPositionThree() {
    onData(anything()).atPosition(3).perform(click());
    onView(withId(R.id.description_name))
      .check(matches(withText(containsString("Mouse"))));
    onView(withId(R.id.description))
      .check(matches(withText(containsString("mouse"))));

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void clickListViewByPositionFour() {
    onData(anything()).atPosition(4).perform(click());
    onView(withId(R.id.description_name))
      .check(matches(withText(containsString("Keyboard"))));
    onView(withId(R.id.description))
      .check(matches(withText(containsString("keyboard"))));
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
