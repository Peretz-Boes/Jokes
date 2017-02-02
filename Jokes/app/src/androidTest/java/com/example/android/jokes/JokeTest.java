package com.example.android.jokes;

import com.udacity.example.jokes.Joker;

import org.junit.Test;

/**
 * Created by Peretz on 2016-12-26.
 */
public class JokeTest {
    @Test
    public void test(){
        Joker joker=new Joker();
        assert joker.getJoke().length()!=0;
    }
}
