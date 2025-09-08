package com.example.junit.jUnit_in_5_steps;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class MyAssertTest {

    List<String> Course = Arrays.asList("AWS", "Cloud", "DevOps");

    @Test
    void test(){
        boolean check = Course.contains("Cloud");
//        assertEquals(check, true);
        assertTrue(check);
        assertArrayEquals(new int[] {1,2,3}, new int[] {1,2,3}, "values mismatched" );
        assertEquals(3, Course.size(), "Not as expected");

    }
}
