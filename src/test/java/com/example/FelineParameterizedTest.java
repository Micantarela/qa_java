package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private final int expectedKittens;

    private final Feline feline = new Feline();

    public FelineParameterizedTest(int expectedKittens) {
        this.expectedKittens = expectedKittens;
    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return new Object[][] {
            {1}, {10}, {5}
        };
    }

    @Test
    public void getKittensTest() {
        int actualKittens = feline.getKittens(expectedKittens);
        Assert.assertEquals(expectedKittens, actualKittens);
    }

}
