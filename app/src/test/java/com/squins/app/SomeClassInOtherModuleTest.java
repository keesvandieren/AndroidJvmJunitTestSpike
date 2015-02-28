package com.squins.app;

import org.junit.Test;

import com.squins.common.SomeClass;

import static org.junit.Assert.assertEquals;

public class SomeClassInOtherModuleTest {

    @Test
    public void shouldSumOnePlusOne() {
        assertEquals(2, new SomeClass().sum(1, 1));
    }

    @Test
    public void testEchoR() throws Exception {
        new SomeClass().referenceDrawableFromR();

    }

}
