# Spike to test Android support for Junit JVM testing.

Recently Google added [Unit Testing Support](http://tools.android.com/tech-docs/unit-testing-support) that supports running Junit tests on the Java VM.

This speeds up test execution.

## Goals

1. Find out if Junit test can be added in an Android Library project.
2. Find out if Junit test can depend on R class.
3. Find out if Junit test can depend on class of Android library project.

## Current status

### 28-02-2015, 20:00
Struggling to find out how to get the AndroidManifest generated, and have available in jvm via class R.

In the sut (Subject Under Test), I added the following method:

    public void referenceDrawableFromR() {
        System.out.println("Reference drawable!" + com.squins.common.R.drawable.sample);
    }

And test:

    package com.squins.common;

    import org.junit.Ignore;
    import org.junit.Test;

    public class SomeClassReferencingRTest {

        @Test
        @Ignore
        public void testEchoR() throws Exception {
            new SomeClass().referenceDrawableFromR();
        }
    }

This results in error:

    com.squins.common.SomeClassReferencingRTest > testEchoR FAILED
        java.lang.NoClassDefFoundError at SomeClassReferencingRTest.java:10
            Caused by: java.lang.ClassNotFoundException at SomeClassReferencingRTest.java:10

And in the test report:

    java.lang.NoClassDefFoundError: com/squins/common/R$drawable
        at com.squins.common.SomeClass.referenceDrawableFromR(SomeClass.java:10)
        at com.squins.common.SomeClassReferencingRTest.testEchoR(SomeClassReferencingRTest.java:10)
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)

### 28-02-2015, 19:00
Problem of symbol not found solved, by using the following gradle command:
 
`./gradlew clean assembleDebug assembleRelease test` 

Still need to find out why assembleDebug, assembleRelease goals are not executed, but at least
its an acceptable workaround.

Achievement (1) unlocked!

Now we added another test to verify Achievement (2): Find out if Junit test can depend on R class.


### 28-02-2015, 15:00
I have problems to get Java unit-testing to work for an android library project.

Gradle command: `./gradlew clean test` runs into the following error:

    :common:compileDebugUnitTestJava
    /home/username/path/AndroidJvmJunitTestSpike/common/src/test/java/squins/com/common/SomeClassTest.java:11: error: cannot find symbol
            assertEquals(2, new SomeClass().sum(1, 1));
                            ^
