package com.sourcey.materiallogindemo;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(LoginActivity.class);

    //Inputs for the Sign up fields
    private static String Email = "haggzo@gmail.com";
    private static String Password = "penta";

    @Before
    public void setUp()
    {

    }

    @Test
    public void happyFlow(){
        onView(withId(R.id.input_email))
                .check(matches(isDisplayed()))
                .perform(typeText(Email), closeSoftKeyboard());
        onView(withId(R.id.input_password))
                .check(matches(isDisplayed()))
                .perform(typeText(Password), closeSoftKeyboard());
        onView(withId(R.id.btn_login))
                .check(matches(isDisplayed()))
                .perform(click());
    }

    @Test
    public void clickOpenSignup()
    {
        onView(withId(R.id.link_signup))
                .perform(click());
    }

    @After
    public void tearDown()
    {

    }
}