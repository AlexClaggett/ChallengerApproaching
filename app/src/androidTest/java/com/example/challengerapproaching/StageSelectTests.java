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
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class StageSelectTests {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void stageSelectTests() {
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
                allOf(withId(R.id.BattleField),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        0),
                                0)));
        appCompatImageButton2.perform(scrollTo(), click());

        pressBack();

        ViewInteraction appCompatImageButton3 = onView(
                allOf(withId(R.id.FinalDestination),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        1),
                                0)));
        appCompatImageButton3.perform(scrollTo(), click());

        pressBack();

        ViewInteraction appCompatImageButton4 = onView(
                allOf(withId(R.id.KalosPokemonStadium),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        2),
                                0)));
        appCompatImageButton4.perform(scrollTo(), click());

        pressBack();

        ViewInteraction appCompatImageButton5 = onView(
                allOf(withId(R.id.LylatCruise),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        3),
                                0)));
        appCompatImageButton5.perform(scrollTo(), click());

        pressBack();

        ViewInteraction appCompatImageButton6 = onView(
                allOf(withId(R.id.PokemonStadium),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        4),
                                0)));
        appCompatImageButton6.perform(scrollTo(), click());

        pressBack();

        ViewInteraction appCompatImageButton7 = onView(
                allOf(withId(R.id.PokemonStadium2),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        5),
                                0)));
        appCompatImageButton7.perform(scrollTo(), click());

        pressBack();

        ViewInteraction appCompatImageButton8 = onView(
                allOf(withId(R.id.Smashville),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        6),
                                0)));
        appCompatImageButton8.perform(scrollTo(), click());

        pressBack();

        ViewInteraction appCompatImageButton9 = onView(
                allOf(withId(R.id.TownAndCity),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        7),
                                0)));
        appCompatImageButton9.perform(scrollTo(), click());

        pressBack();

        ViewInteraction appCompatImageButton10 = onView(
                allOf(withId(R.id.UnovaPokemonLeague),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        8),
                                0)));
        appCompatImageButton10.perform(scrollTo(), click());

        pressBack();

        ViewInteraction appCompatImageButton11 = onView(
                allOf(withId(R.id.YoshiIsland),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        9),
                                0)));
        appCompatImageButton11.perform(scrollTo(), click());

        pressBack();

        ViewInteraction appCompatImageButton12 = onView(
                allOf(withId(R.id.YoshisStory),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        10),
                                0)));
        appCompatImageButton12.perform(scrollTo(), click());

        pressBack();

        pressBack();

        ViewInteraction imageButton = onView(
                allOf(withId(R.id.stages),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                        0),
                                3),
                        isDisplayed()));
        imageButton.check(matches(isDisplayed()));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(final Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(final View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
