package com.example.android.jokes;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.android.jokeslibrary.JokeActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Created by Peretz on 2017-02-21.
 */

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest{

    @Rule
    public IntentsTestRule<MainActivity> rule=new IntentsTestRule<>(MainActivity.class);

    @Test
    public void retreiveJokeOnClick(){
        onView(withId(R.id.tell_joke_button)).perform(click());
        intended(hasComponent(hasClassName(JokeActivity.class.getName())));
        intended(hasExtra(equalTo("KEY_JOKE"),notNullValue()));
    }

}
