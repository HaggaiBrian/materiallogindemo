package com.sourcey.materiallogindemo;

import android.support.design.widget.TextInputLayout;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class hasHintMatchers{
public static Matcher<View> hintMatchers(final String expectedHintText) {
        return new TypeSafeMatcher<View>() {

@Override
public boolean matchesSafely(View item) {
        if (!(item instanceof TextInputLayout)) {
        return false;
        }

        CharSequence hint = ((TextInputLayout) item).getHint();

        if (hint == null) {
        return false;
        }

        String hints = hint.toString();

        return expectedHintText.equals(hints);
        } 

@Override
public void describeTo(Description description) {
        description.appendText("The Hint did not match any hints in this View" + expectedHintText);
        }
        };
}
}