package ru.job4j.it;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class BackwardArrayItTest {
    @Test
    public void whenReadSequence() {
        BackwardArrayIt it = new BackwardArrayIt(
                new int[]{1, 2, 3}
        );
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(1));
    }

    @Test
    public void whenMultiCallhasNextThenTrue() {
        BackwardArrayIt it = new BackwardArrayIt(new int[]{1, 2, 3});
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
    }

    @Test(expected = NoSuchElementException.class)
    public void whennextFromEmpty() {
        BackwardArrayIt it = new BackwardArrayIt(new int[] {});
        it.next();
    }




}