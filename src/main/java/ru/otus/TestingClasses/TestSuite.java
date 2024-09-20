package ru.otus.TestingClasses;

import ru.otus.TestingInterfaces.AfterSuite;
import ru.otus.TestingInterfaces.BeforeSuite;
import ru.otus.TestingInterfaces.Disabled;
import ru.otus.TestingInterfaces.Test;

//@Disabled(reason = "TEST CLASS REASON")
public class TestSuite {
    public static void init() {
        System.out.println("init");
    }

    @AfterSuite
    public static void test1() {
        System.out.println("test1 @AfterSuit");
    }

    @Disabled(reason = "TEST REASON.")
    @Test(priority = 2)
    public static void test2() {
        System.out.println("test2 @Disabled (with a reason)");
    }

    @BeforeSuite
    public static void test3() {
        System.out.println("test3 @BeforeSuite");
    }

//    @AfterSuite
    @Test(priority = 4)
    public static void test4() {
        System.out.println("test4");
    }

    @Test(priority = 5)
    public static void test5() {
        System.out.println("test5 + 5/0 ");
        int result = 5 / 0;
    }

    @Test(priority = 6)
    public static void test6() {
        System.out.println("test6");
    }

}
