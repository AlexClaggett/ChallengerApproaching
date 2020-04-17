package com.example.challengerapproaching;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

/** This test checks all of the Smashville's page values
 *  by navigating to the stage select screen and then to
 *  Smashville's page
 *  */

@LargeTest
@RunWith(AndroidJUnit4.class)
public class Smashville {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void smashville() {
        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.stages),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                3),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withId(R.id.Smashville),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        6),
                                0)));
        appCompatImageButton2.perform(scrollTo(), click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.BF_SW_Value), withText(" 139.298"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        textView.check(matches(withText(" 139.298")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.BF_PC_Value), withText(" 1"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        1),
                                1),
                        isDisplayed()));
        textView2.check(matches(withText(" 1")));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.BF_PBZT3_Value), withText(" 28.698"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        3),
                                1),
                        isDisplayed()));
        textView3.check(matches(withText(" 28.698")));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.BF_BZT_Value), withText(" 189.9"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        5),
                                1),
                        isDisplayed()));
        textView4.check(matches(withText(" 189.9")));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.BF_BZR_Value), withText(" 159.754"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        6),
                                1),
                        isDisplayed()));
        textView5.check(matches(withText(" 159.754")));

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.BF_BZL_Value), withText(" 159.949"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        7),
                                1),
                        isDisplayed()));
        textView6.check(matches(withText(" 159.949")));

        ViewInteraction textView7 = onView(
                allOf(withId(R.id.BF_BZB_Value), withText(" 115.1"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        8),
                                1),
                        isDisplayed()));
        textView7.check(matches(withText(" 115.1")));

        ViewInteraction textView8 = onView(
                allOf(withId(R.id.BF_BZC_Value), withText(" 50.1"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        9),
                                1),
                        isDisplayed()));
        textView8.check(matches(withText(" 50.1")));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
