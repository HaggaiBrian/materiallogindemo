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
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.hasTextColor;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.sourcey.materiallogindemo.hasHintMatchers.hintMatchers;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class SignupActivityTest {

    @Rule
    public ActivityTestRule<SignupActivity> mActivityRule = new ActivityTestRule<>(SignupActivity.class);

    //Inputs for the Sign up fields
    private static String Name = "Haggai Brian Odio";
    private static String Address = "Kampala, Uganda";
    private static String Email = "haggzo@gmail.com";
    private static String PhoneNumber = "0706658499";
    private static String Password = "penta";
    private static String ReenterPassword = "penta";

    //Errors on the Screen
    private static String NameError = "at least 3 characters";
    private static String AddressError = "Enter Valid Address";
    private static String EmailError = "enter a valid email address";
    private static String PhoneNumberError = "Enter Valid Mobile Number";
    private static String PasswordError = "between 4 and 10 alphanumeric characters";
    private static String ReenterPasswordError = "Password Do not match";

    //Hints on the Screen
    private static String NameHint = "Name";
    private static String AddressHint = "Address";
    private static String EmailHint = "Email";
    private static String PhoneNumberHint = "Mobile Number";
    private static String PasswordHint = "Password";
    private static String ReenterPasswordHint = "Re-enter Password";

    //Match Texts
    private static String linklogin = "Already a member? Login";
    private static String btnaccount = "CREATE ACCOUNT";
    private static String progressloader = "Creating Account...";

    @Before
    public void setUp()
    {

    }

    @Test
    public void happyFlow() {
        onView(withId(R.id.famous_logo))
                .check(matches(isDisplayed()))
                .check(matches(new DrawableMatcher(R.drawable.logo)));
        onView(withId(R.id.input_name))
                .check(matches(isDisplayed()))
                .perform(typeText(Name), closeSoftKeyboard());
        onView(withId(R.id.name_form))
                .check(matches(hintMatchers(NameHint)))
                .check(matches(isDisplayed()));
        onView(withId(R.id.input_address))
                .check(matches(isDisplayed()))
                .perform(typeText(Address), closeSoftKeyboard());
        onView(withId(R.id.address_form))
                .check(matches(isDisplayed()))
                .check(matches(hintMatchers(AddressHint)));
        onView(withId(R.id.input_email))
                .check(matches(isDisplayed()))
                .perform(typeText(Email), closeSoftKeyboard());
        onView(withId(R.id.email_form))
                .check(matches(isDisplayed()))
                .check(matches(hintMatchers(EmailHint)));
        onView(withId(R.id.input_mobile))
                .check(matches(isDisplayed()))
                .perform(typeText(PhoneNumber), closeSoftKeyboard());
        onView(withId(R.id.phonenumber_form))
                .check(matches(isDisplayed()))
                .check(matches(hintMatchers(PhoneNumberHint)));
        onView(withId(R.id.input_password))
                .check(matches(isDisplayed()))
                .perform(typeText(Password), closeSoftKeyboard());
        onView(withId(R.id.password_form))
                .check(matches(isDisplayed()))
                .check(matches(hintMatchers(PasswordHint)));
        onView(withId(R.id.input_reEnterPassword))
                .check(matches(isDisplayed()))
                .perform(typeText(ReenterPassword), closeSoftKeyboard());
        onView(withId(R.id.reenterpassword_form))
                .check(matches(isDisplayed()))
                .check(matches(hintMatchers(ReenterPasswordHint)));
        onView(withId(R.id.link_login))
                .perform(scrollTo())
                .check(matches(isDisplayed()))
                .check(matches(withText(linklogin)));
        onView(withId(R.id.btn_signup))
                .check(matches(isDisplayed()))
                .check(matches(withText(btnaccount)))
                .check(matches(hasTextColor(R.color.white)))
                .perform(click());
        onView(withText(progressloader))
                .check(matches(isDisplayed()))
                .check(matches(withText(progressloader)));
    }

    @Test
    /*Note that under the unhappy flow
    we can have more test cases of different conditions with some Edge cases to
    With all the fields blank*/
    public void unhappyFlow(){
        onView(withId(R.id.btn_signup))
                .perform(scrollTo())
                .perform(click());
        onView(withId(R.id.input_name))
                .perform(scrollTo())
                .perform(closeSoftKeyboard())
                .check(matches(hasErrorText(NameError)));
        onView(withId(R.id.input_address))
                .perform(closeSoftKeyboard())
                .check(matches(hasErrorText(AddressError)));
        onView(withId(R.id.input_email))
                .perform(closeSoftKeyboard())
                .check(matches(hasErrorText(EmailError)));
        onView(withId(R.id.input_mobile))
                .perform(closeSoftKeyboard())
                .check(matches(hasErrorText(PhoneNumberError)));
        onView(withId(R.id.input_password))
                .perform(closeSoftKeyboard())
                .check(matches(hasErrorText(PasswordError)));
        onView(withId(R.id.input_reEnterPassword))
                .perform(closeSoftKeyboard())
                .check(matches(hasErrorText(ReenterPasswordError)));
    }

    @After
    public void tearDown()
    {

    }
}