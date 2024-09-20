package ru.otus.TestingClasses;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

public class TestSuiteMetadata {
    private final Class<?> testSuiteCLass;
    private final Constructor<?> constructor;
    private final List<Method> testMethods;
    private final Method beforeSuiteMethod;
    private final Method afterSuiteMethod;

    public TestSuiteMetadata(Class<?> testSuiteCLass, Constructor<?> constructor, List<Method> testMethods, Method beforeSuiteMethod, Method afterSuiteMethod) throws NoSuchMethodException {
        this.testSuiteCLass = testSuiteCLass;
        this.constructor = constructor;
        this.testMethods = testMethods;
        this.beforeSuiteMethod = beforeSuiteMethod;
        this.afterSuiteMethod = afterSuiteMethod;
    }

    public Constructor<?> getConstructor() {
        return constructor;
    }

    public List<Method> getTestMethods() {
        return testMethods;
    }

    public Method getBeforeSuiteMethod() {
        return beforeSuiteMethod;
    }

    public Method getAfterSuiteMethod() {
        return afterSuiteMethod;
    }

    public Class<?> getTestSuiteCLass() {
        return testSuiteCLass;
    }
}
