package com.example.kalaiarasan.personalfitness;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import static android.support.test.espresso.Espresso.onView;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withInputType;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.click;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.kalaiarasan.personalfitness", appContext.getPackageName());
    }
/***
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule=
            new ActivityTestRule<>(MainActivity.class);


    @Test
    public void RegisterPage(){
        onView(withId(R.id.etEmail))
                .perform(typeText("arasan3@rocketmail.com"),closeSoftKeyboard());
        onView(withId(R.id.etPassword))
                .perform(typeText("12345"),closeSoftKeyboard());
        onView(withId(R.id.etCPassword))
                .perform(typeText("12345"),closeSoftKeyboard());
        onView(withId(R.id.btnregister))
                .perform(click());
        onView(withId(R.id.btn2))
                .perform(click());
        onView(withId(R.id.editText))
                .perform(typeText("arasan3@rocketmail.com"),closeSoftKeyboard());
        onView(withId(R.id.editText2))
                .perform(typeText("12345"),closeSoftKeyboard());
        onView(withId(R.id.button))
                .perform(click());
    }
    ***/
    @Rule
    public ActivityTestRule<MainPage> mainPageActivityTestRule=
        new ActivityTestRule<>(MainPage.class);

    @Test
    public void man(){
        onView(withId(R.id.imgman))
                .perform(click());
        onView(withId(R.id.btnpushup))
                .perform(click());
        onView(withId(R.id.starte))
                .perform(click());
        onView(withId(R.id.tvc1));


    }
    @Test
    public void woman(){
        onView(withId(R.id.imgwoman))
                .perform(click());
        onView(withId(R.id.womanplank))
                .perform(click());
        onView(withId(R.id.womanstartplank))
                .perform(click());
        onView(withId(R.id.tvwomanplanks));

    }
    @Test
    public void BMI() {
        onView(withId(R.id.imgbmi))
                .perform(click());
        onView(withId(R.id.etheight))
                .perform(typeText("168"), closeSoftKeyboard());
        onView(withId(R.id.etweight))
                .perform(typeText("60"), closeSoftKeyboard());
        onView(withId(R.id.btncalculate))
                .perform(click());
    }
    @Test
    public void MealPlan(){
        onView(withId(R.id.imgdietplan))
                .perform(click());
        onView(withId(R.id.btnVegan))
                .perform(click());
        onView(withId(R.id.tvvegan)).perform(scrollTo())
                .perform(click());

    }
    @Test
    public void eventlog(){
        onView(withId(R.id.btnevent))
                .perform(click());
        onView(withId(R.id.start_log))
                .perform(click());

    }

    @Test
    public void about(){
        onView(withId(R.id.btnabout))
                .perform(click());
        onView(withId(R.id.button2))
                .perform(click());
    }

    @Test
    public void exit(){
        onView(withId(R.id.btnlogout))
                .perform(click());
    }

    }




