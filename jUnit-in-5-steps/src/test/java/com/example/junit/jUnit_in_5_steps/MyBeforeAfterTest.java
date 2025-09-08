package com.example.junit.jUnit_in_5_steps;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class MyBeforeAfterTest {

    @BeforeAll
    static void beforeAll(){
        System.out.println("Before All");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("Before Each");
    }

    @AfterEach
    void afterEach(){
        System.out.println("After Each");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("After ALL");
    }

    @Test
    void test1(){
        System.out.println("test1");
    }

    @Test
    void test2(){
        System.out.println("test2");
    }

    @Test
    void test3(){
        System.out.println("test3");
    }


}
