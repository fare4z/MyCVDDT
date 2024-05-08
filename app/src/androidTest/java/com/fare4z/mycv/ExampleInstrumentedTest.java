package com.fare4z.mycv;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.junit.Assert.assertEquals;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityScenarioRule<MainActivity> mActivityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() {
        Intents.init();
    }

    @After
    public void tearDown() {
        Intents.release();
    }

    @Test
    public void testA_RegisterButton() {

        ActivityScenario<MainActivity> scenario = mActivityRule.getScenario();

        // Type text into EditTexts
        onView(withId(R.id.et_name)).perform(typeText("Fareez"));
        onView(withId(R.id.et_email)).perform(typeText("fareez@psp.edu.my"));
        onView(withId(R.id.et_nric)).perform(typeText("123456789012"));

        // Click on Register Button
        onView(withId(R.id.btn_register)).perform(click());

        // Check if the Intent to start ProfileActivity is sent
        intended(hasComponent(ProfileActivity.class.getName()));
    }

    @Test
    public void testB_1_NumberButtonClick() {
        onView(withId(R.id.btn_one)).perform(click());
        onView(withId(R.id.tvOutputAge)).check(matches(withText("1")));
    }

    @Test
    public void testB_2_NumberButtonClick() {
        onView(withId(R.id.btn_two)).perform(click());
        onView(withId(R.id.tvOutputAge)).check(matches(withText("2")));
    }

    @Test
    public void testB_3_NumberButtonClick() {
        onView(withId(R.id.btn_three)).perform(click());
        onView(withId(R.id.tvOutputAge)).check(matches(withText("3")));
    }

    @Test
    public void testC_OperationButtonClick() {
        onView(withId(R.id.btn_plus)).perform(click());
        onView(withId(R.id.tvOutputAge)).check(matches(withText("+")));
    }

    @Test
    public void testD_CalculateMethod() {
        mActivityRule.getScenario().onActivity(activity -> {
            int result = activity.kira("1+2");
            assertEquals(3, result);
        });
    }

}
