package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private static final String DEFAULT_LION_SEX = "Самец";
    private static final String MALE_LION_SEX = "Самец";
    private static final String FEMALE_LION_SEX = "Самка";
    private static final String UNSUPPORTED_LION_SEX = "Неизвестный пол";

    @Mock
    Feline feline;

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = createDefaultLion();
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = createDefaultLion();
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    private Lion createDefaultLion() throws Exception {
        return new Lion(DEFAULT_LION_SEX, feline);
    }

    @Test
    public void createMaleLionTest() throws Exception {
        Lion lion = new Lion(MALE_LION_SEX, feline);
        Assert.assertTrue(lion.hasMane);
    }

    @Test
    public void createFemaleLionTest() throws Exception {
        Lion lion = new Lion(FEMALE_LION_SEX, feline);
        Assert.assertFalse(lion.hasMane);
    }

    @Test
    public void createUnsupportedSexLionTest() throws Exception {
        Assert.assertThrows(Exception.class,
            () -> new Lion(UNSUPPORTED_LION_SEX, feline)
        );
    }

    @Test
    public void doesHaveManeFalseTest() throws Exception {
        Lion lion = createDefaultLion();
        lion.hasMane = false;
        Assert.assertFalse(lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeTrueTest() throws Exception {
        Lion lion = createDefaultLion();
        lion.hasMane = true;
        Assert.assertTrue(lion.doesHaveMane());
    }

}
