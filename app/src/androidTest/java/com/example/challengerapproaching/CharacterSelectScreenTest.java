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
public class CharacterSelectScreenTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void characterSelectScreen() {
        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.characters),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction imageButton = onView(
                allOf(withId(R.id.banjoKazooie),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        imageButton.check(matches(isDisplayed()));

        ViewInteraction imageButton2 = onView(
                allOf(withId(R.id.bayonetta),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        imageButton2.check(matches(isDisplayed()));

        ViewInteraction imageButton3 = onView(
                allOf(withId(R.id.bowser),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        imageButton3.check(matches(isDisplayed()));

        ViewInteraction imageButton4 = onView(
                allOf(withId(R.id.bowserJr),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        1),
                                1),
                        isDisplayed()));
        imageButton4.check(matches(isDisplayed()));

        ViewInteraction imageButton5 = onView(
                allOf(withId(R.id.bylthe),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        2),
                                0),
                        isDisplayed()));
        imageButton5.check(matches(isDisplayed()));

        ViewInteraction imageButton6 = onView(
                allOf(withId(R.id.captainFalcon),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        2),
                                1),
                        isDisplayed()));
        imageButton6.check(matches(isDisplayed()));

        ViewInteraction imageButton7 = onView(
                allOf(withId(R.id.chrom),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        3),
                                0),
                        isDisplayed()));
        imageButton7.check(matches(isDisplayed()));

        ViewInteraction imageButton8 = onView(
                allOf(withId(R.id.cloud),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        3),
                                1),
                        isDisplayed()));
        imageButton8.check(matches(isDisplayed()));

        ViewInteraction imageButton9 = onView(
                allOf(withId(R.id.corrin),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        4),
                                0),
                        isDisplayed()));
        imageButton9.check(matches(isDisplayed()));

        ViewInteraction imageButton10 = onView(
                allOf(withId(R.id.daisy),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        4),
                                1),
                        isDisplayed()));
        imageButton10.check(matches(isDisplayed()));

        ViewInteraction imageButton11 = onView(
                allOf(withId(R.id.darkPit),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        5),
                                0),
                        isDisplayed()));
        imageButton11.check(matches(isDisplayed()));

        ViewInteraction imageButton12 = onView(
                allOf(withId(R.id.darkSamus),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        5),
                                1),
                        isDisplayed()));
        imageButton12.check(matches(isDisplayed()));

        ViewInteraction imageButton13 = onView(
                allOf(withId(R.id.diddyKong),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        6),
                                0),
                        isDisplayed()));
        imageButton13.check(matches(isDisplayed()));

        ViewInteraction imageButton14 = onView(
                allOf(withId(R.id.donkeyKong),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        6),
                                1),
                        isDisplayed()));
        imageButton14.check(matches(isDisplayed()));

        ViewInteraction imageButton15 = onView(
                allOf(withId(R.id.dr_mario),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        7),
                                0),
                        isDisplayed()));
        imageButton15.check(matches(isDisplayed()));

        ViewInteraction imageButton16 = onView(
                allOf(withId(R.id.duckHunt),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        7),
                                1),
                        isDisplayed()));
        imageButton16.check(matches(isDisplayed()));

        ViewInteraction imageButton17 = onView(
                allOf(withId(R.id.falco),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        8),
                                0),
                        isDisplayed()));
        imageButton17.check(matches(isDisplayed()));

        ViewInteraction imageButton18 = onView(
                allOf(withId(R.id.fox),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        8),
                                1),
                        isDisplayed()));
        imageButton18.check(matches(isDisplayed()));

        ViewInteraction imageButton19 = onView(
                allOf(withId(R.id.ganondorf),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        9),
                                0),
                        isDisplayed()));
        imageButton19.check(matches(isDisplayed()));

        ViewInteraction imageButton20 = onView(
                allOf(withId(R.id.greninja),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        9),
                                1),
                        isDisplayed()));
        imageButton20.check(matches(isDisplayed()));

        ViewInteraction imageButton21 = onView(
                allOf(withId(R.id.hero),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        10),
                                0),
                        isDisplayed()));
        imageButton21.check(matches(isDisplayed()));

        ViewInteraction imageButton22 = onView(
                allOf(withId(R.id.iceClimbers),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        10),
                                1),
                        isDisplayed()));
        imageButton22.check(matches(isDisplayed()));

        ViewInteraction imageButton23 = onView(
                allOf(withId(R.id.ike),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        11),
                                0),
                        isDisplayed()));
        imageButton23.check(matches(isDisplayed()));

        ViewInteraction imageButton24 = onView(
                allOf(withId(R.id.incineroar),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        11),
                                1),
                        isDisplayed()));
        imageButton24.check(matches(isDisplayed()));

        ViewInteraction imageButton25 = onView(
                allOf(withId(R.id.inkling),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        12),
                                0),
                        isDisplayed()));
        imageButton25.check(matches(isDisplayed()));

        ViewInteraction imageButton26 = onView(
                allOf(withId(R.id.isabelle),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        12),
                                1),
                        isDisplayed()));
        imageButton26.check(matches(isDisplayed()));

        ViewInteraction imageButton27 = onView(
                allOf(withId(R.id.jigglypuff),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        13),
                                0),
                        isDisplayed()));
        imageButton27.check(matches(isDisplayed()));

        ViewInteraction imageButton28 = onView(
                allOf(withId(R.id.joker),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        13),
                                1),
                        isDisplayed()));
        imageButton28.check(matches(isDisplayed()));

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withId(R.id.pikachu),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        26),
                                1)));
        appCompatImageButton2.perform(scrollTo());

        ViewInteraction imageButton29 = onView(
                allOf(withId(R.id.ken),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        14),
                                0),
                        isDisplayed()));
        imageButton29.check(matches(isDisplayed()));

        ViewInteraction imageButton30 = onView(
                allOf(withId(R.id.kingDedede),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        14),
                                1),
                        isDisplayed()));
        imageButton30.check(matches(isDisplayed()));

        ViewInteraction imageButton31 = onView(
                allOf(withId(R.id.kingK_Rool),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        15),
                                0),
                        isDisplayed()));
        imageButton31.check(matches(isDisplayed()));

        ViewInteraction imageButton32 = onView(
                allOf(withId(R.id.kirby),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        15),
                                1),
                        isDisplayed()));
        imageButton32.check(matches(isDisplayed()));

        ViewInteraction imageButton33 = onView(
                allOf(withId(R.id.link),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        16),
                                0),
                        isDisplayed()));
        imageButton33.check(matches(isDisplayed()));

        ViewInteraction imageButton34 = onView(
                allOf(withId(R.id.littleMac),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        16),
                                1),
                        isDisplayed()));
        imageButton34.check(matches(isDisplayed()));

        ViewInteraction imageButton35 = onView(
                allOf(withId(R.id.lucario),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        17),
                                0),
                        isDisplayed()));
        imageButton35.check(matches(isDisplayed()));

        ViewInteraction imageButton36 = onView(
                allOf(withId(R.id.lucas),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        17),
                                1),
                        isDisplayed()));
        imageButton36.check(matches(isDisplayed()));

        ViewInteraction imageButton37 = onView(
                allOf(withId(R.id.lucina),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        18),
                                0),
                        isDisplayed()));
        imageButton37.check(matches(isDisplayed()));

        ViewInteraction imageButton38 = onView(
                allOf(withId(R.id.Luigi),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        18),
                                1),
                        isDisplayed()));
        imageButton38.check(matches(isDisplayed()));

        ViewInteraction imageButton39 = onView(
                allOf(withId(R.id.mario),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        19),
                                0),
                        isDisplayed()));
        imageButton39.check(matches(isDisplayed()));

        ViewInteraction imageButton40 = onView(
                allOf(withId(R.id.marth),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        19),
                                1),
                        isDisplayed()));
        imageButton40.check(matches(isDisplayed()));

        ViewInteraction imageButton41 = onView(
                allOf(withId(R.id.megaMan),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        20),
                                0),
                        isDisplayed()));
        imageButton41.check(matches(isDisplayed()));

        ViewInteraction imageButton42 = onView(
                allOf(withId(R.id.metaKnight),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        20),
                                1),
                        isDisplayed()));
        imageButton42.check(matches(isDisplayed()));

        ViewInteraction imageButton43 = onView(
                allOf(withId(R.id.mewtwo),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        21),
                                0),
                        isDisplayed()));
        imageButton43.check(matches(isDisplayed()));

        ViewInteraction imageButton44 = onView(
                allOf(withId(R.id.miiBrawler),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        21),
                                1),
                        isDisplayed()));
        imageButton44.check(matches(isDisplayed()));

        ViewInteraction imageButton45 = onView(
                allOf(withId(R.id.miiSwordfighter),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        22),
                                0),
                        isDisplayed()));
        imageButton45.check(matches(isDisplayed()));

        ViewInteraction imageButton46 = onView(
                allOf(withId(R.id.miiGunner),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        22),
                                1),
                        isDisplayed()));
        imageButton46.check(matches(isDisplayed()));

        ViewInteraction imageButton47 = onView(
                allOf(withId(R.id.mr_GameWatch),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        23),
                                0),
                        isDisplayed()));
        imageButton47.check(matches(isDisplayed()));

        ViewInteraction imageButton48 = onView(
                allOf(withId(R.id.ness),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        23),
                                1),
                        isDisplayed()));
        imageButton48.check(matches(isDisplayed()));

        ViewInteraction imageButton49 = onView(
                allOf(withId(R.id.olimar),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        24),
                                0),
                        isDisplayed()));
        imageButton49.check(matches(isDisplayed()));

        ViewInteraction imageButton50 = onView(
                allOf(withId(R.id.pacMan),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        24),
                                1),
                        isDisplayed()));
        imageButton50.check(matches(isDisplayed()));

        ViewInteraction imageButton51 = onView(
                allOf(withId(R.id.palutena),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        25),
                                0),
                        isDisplayed()));
        imageButton51.check(matches(isDisplayed()));

        ViewInteraction imageButton52 = onView(
                allOf(withId(R.id.peach),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        25),
                                1),
                        isDisplayed()));
        imageButton52.check(matches(isDisplayed()));

        ViewInteraction imageButton53 = onView(
                allOf(withId(R.id.pichu),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        26),
                                0),
                        isDisplayed()));
        imageButton53.check(matches(isDisplayed()));

        ViewInteraction imageButton54 = onView(
                allOf(withId(R.id.pikachu),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        26),
                                1),
                        isDisplayed()));
        imageButton54.check(matches(isDisplayed()));

        ViewInteraction appCompatImageButton3 = onView(
                allOf(withId(R.id.zeroSuitSamus),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        40),
                                1)));
        appCompatImageButton3.perform(scrollTo());

        ViewInteraction imageButton55 = onView(
                allOf(withId(R.id.piranhaPlant),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        27),
                                0),
                        isDisplayed()));
        imageButton55.check(matches(isDisplayed()));

        ViewInteraction imageButton56 = onView(
                allOf(withId(R.id.pit),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        27),
                                1),
                        isDisplayed()));
        imageButton56.check(matches(isDisplayed()));

        ViewInteraction imageButton57 = onView(
                allOf(withId(R.id.charizard),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        28),
                                0),
                        isDisplayed()));
        imageButton57.check(matches(isDisplayed()));

        ViewInteraction imageButton58 = onView(
                allOf(withId(R.id.ivysaur),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        28),
                                1),
                        isDisplayed()));
        imageButton58.check(matches(isDisplayed()));

        ViewInteraction imageButton59 = onView(
                allOf(withId(R.id.squirtle),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        29),
                                0),
                        isDisplayed()));
        imageButton59.check(matches(isDisplayed()));

        ViewInteraction imageButton60 = onView(
                allOf(withId(R.id.richter),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        29),
                                1),
                        isDisplayed()));
        imageButton60.check(matches(isDisplayed()));

        ViewInteraction imageButton61 = onView(
                allOf(withId(R.id.ridley),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        30),
                                0),
                        isDisplayed()));
        imageButton61.check(matches(isDisplayed()));

        ViewInteraction imageButton62 = onView(
                allOf(withId(R.id.r_o_b_),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        30),
                                1),
                        isDisplayed()));
        imageButton62.check(matches(isDisplayed()));

        ViewInteraction imageButton63 = onView(
                allOf(withId(R.id.robin),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        31),
                                0),
                        isDisplayed()));
        imageButton63.check(matches(isDisplayed()));

        ViewInteraction imageButton64 = onView(
                allOf(withId(R.id.rosalinaAndLuma),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        31),
                                1),
                        isDisplayed()));
        imageButton64.check(matches(isDisplayed()));

        ViewInteraction imageButton65 = onView(
                allOf(withId(R.id.roy),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        32),
                                0),
                        isDisplayed()));
        imageButton65.check(matches(isDisplayed()));

        ViewInteraction imageButton66 = onView(
                allOf(withId(R.id.ryu),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        32),
                                1),
                        isDisplayed()));
        imageButton66.check(matches(isDisplayed()));

        ViewInteraction imageButton67 = onView(
                allOf(withId(R.id.samus),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        33),
                                0),
                        isDisplayed()));
        imageButton67.check(matches(isDisplayed()));

        ViewInteraction imageButton68 = onView(
                allOf(withId(R.id.sheik),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        33),
                                1),
                        isDisplayed()));
        imageButton68.check(matches(isDisplayed()));

        ViewInteraction imageButton69 = onView(
                allOf(withId(R.id.shulk),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        34),
                                0),
                        isDisplayed()));
        imageButton69.check(matches(isDisplayed()));

        ViewInteraction imageButton70 = onView(
                allOf(withId(R.id.simon),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        34),
                                1),
                        isDisplayed()));
        imageButton70.check(matches(isDisplayed()));

        ViewInteraction imageButton71 = onView(
                allOf(withId(R.id.snake),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        35),
                                0),
                        isDisplayed()));
        imageButton71.check(matches(isDisplayed()));

        ViewInteraction imageButton72 = onView(
                allOf(withId(R.id.sonic),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        35),
                                1),
                        isDisplayed()));
        imageButton72.check(matches(isDisplayed()));

        ViewInteraction imageButton73 = onView(
                allOf(withId(R.id.terry),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        36),
                                0),
                        isDisplayed()));
        imageButton73.check(matches(isDisplayed()));

        ViewInteraction imageButton74 = onView(
                allOf(withId(R.id.toonLink),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        36),
                                1),
                        isDisplayed()));
        imageButton74.check(matches(isDisplayed()));

        ViewInteraction imageButton75 = onView(
                allOf(withId(R.id.villager),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        37),
                                0),
                        isDisplayed()));
        imageButton75.check(matches(isDisplayed()));

        ViewInteraction imageButton76 = onView(
                allOf(withId(R.id.wario),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        37),
                                1),
                        isDisplayed()));
        imageButton76.check(matches(isDisplayed()));

        ViewInteraction imageButton77 = onView(
                allOf(withId(R.id.wiiFitTrainer),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        38),
                                0),
                        isDisplayed()));
        imageButton77.check(matches(isDisplayed()));

        ViewInteraction imageButton78 = onView(
                allOf(withId(R.id.wolf),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        38),
                                1),
                        isDisplayed()));
        imageButton78.check(matches(isDisplayed()));

        ViewInteraction imageButton79 = onView(
                allOf(withId(R.id.yoshi),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        39),
                                0),
                        isDisplayed()));
        imageButton79.check(matches(isDisplayed()));

        ViewInteraction imageButton80 = onView(
                allOf(withId(R.id.youngLink),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        39),
                                1),
                        isDisplayed()));
        imageButton80.check(matches(isDisplayed()));

        ViewInteraction imageButton81 = onView(
                allOf(withId(R.id.zelda),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        40),
                                0),
                        isDisplayed()));
        imageButton81.check(matches(isDisplayed()));

        ViewInteraction imageButton82 = onView(
                allOf(withId(R.id.zeroSuitSamus),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        40),
                                1),
                        isDisplayed()));
        imageButton82.check(matches(isDisplayed()));
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
