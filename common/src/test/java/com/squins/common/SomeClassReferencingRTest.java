package com.squins.common;

import org.junit.Test;

public class SomeClassReferencingRTest {

    @Test
    public void testEchoR() throws Exception {
        new SomeClass().referenceDrawableFromR();
    }
}