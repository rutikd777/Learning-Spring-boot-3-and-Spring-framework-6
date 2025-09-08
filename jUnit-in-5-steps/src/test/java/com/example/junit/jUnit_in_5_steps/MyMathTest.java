package com.example.junit.jUnit_in_5_steps;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MyMathTest {

    private MyMath myMath = new MyMath();

    @Test
    void calcSum_ThreeMemberArray(){
        assertEquals(6, myMath.calSum(new int[] {1,2,3}));
    }

    @Test
    void calcSum_nullArray(){
        assertEquals(0, myMath.calSum(new int[] {}));
    }
}


