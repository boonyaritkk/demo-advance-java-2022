package demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloWorldTest {

    @Test
    @DisplayName("test")
    void case1() {
        HelloWorld helloWorld = new HelloWorld();
        String actualResult = helloWorld.hi("test");

        assertEquals("hi test", actualResult);
    }
}