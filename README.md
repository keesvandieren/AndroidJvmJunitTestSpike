# Spike to test Android support for Junit JVM testing.

## Goals

* Find out if Junit test can be added in an app project
* Find out if Junit test can depend on R class
* Find out if Junit test can depend on class of Android library project.

## Current status

I have problems to get Java unit-testing to work for an android library project.

Gradle command: `./gradlew clean test` runs into the following error:

    :common:compileDebugUnitTestJava
    /home/username/path/AndroidJvmJunitTestSpike/common/src/test/java/squins/com/common/SomeClassTest.java:11: error: cannot find symbol
            assertEquals(2, new SomeClass().sum(1, 1));
                            ^
