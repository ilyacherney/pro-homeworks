package ru.otus.TestingClasses;

import ru.otus.TestingInterfaces.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TestRunner {

    public static void run(Class<?> testSuiteClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, MultipleAnnotationUsesException, MethodHasMultipleAnnotationsException {
        if (!TestChecker.checkBeforeRunning(testSuiteClass)) return;

        TestSuiteMetadata testSuiteMetadata = TestSuiteMetadataFactory.create(testSuiteClass);
        List<Method> testMethods = testSuiteMetadata.getTestMethods();
        Method beforeSuiteMethod = testSuiteMetadata.getBeforeSuiteMethod();
        Method afterSuiteMethod = testSuiteMetadata.getAfterSuiteMethod();
        List<Method> sortedByPrioritiesTestMethods = sortTestMethodsByPriorities(testMethods);
        Queue<Method> methodsRunQueue = setMethodsRunQueue(beforeSuiteMethod, sortedByPrioritiesTestMethods, afterSuiteMethod);

        int testsCounter = 0;
        int successCounter = 0;
        int failCounter = 0;
        for (Method method : methodsRunQueue) {

           if (TestChecker.checkMethod(method)) {
               testsCounter++;
               try {
                   method.invoke(testSuiteClass);
                   successCounter++;
               } catch (Exception e) {
                   failCounter++;
                   System.out.println("Exception occurred");
               }
           }
       }

        System.out.println("_________________");
        System.out.println("Tests Total: " + testsCounter);
        System.out.println("Tests Succeed: " + successCounter);
        System.out.println("Tests Failed: " + failCounter);
    }

    public static List<Method> sortTestMethodsByPriorities(List<Method> unsortedTestMethods) {
        List<Method> sortedTestMethods = new ArrayList<>();
        int minPriority = 1;
        int maxPriority = 10;
        for (int priority = maxPriority; priority >= minPriority; priority--)  {
            for (Method method : unsortedTestMethods) {
                if (method.getAnnotation(Test.class).priority() == priority) sortedTestMethods.add(method);
            }
        }
        return sortedTestMethods;
    }

    public static Queue<Method> setMethodsRunQueue(Method beforeSuiteMethod, List<Method> sortedByPrioritiesTestMethods, Method afterSuiteMethod) {
        Queue<Method> methodsRunQueue = new LinkedList<>();
        methodsRunQueue.add(beforeSuiteMethod);
        methodsRunQueue.addAll(sortedByPrioritiesTestMethods);
        methodsRunQueue.add(afterSuiteMethod);
        return methodsRunQueue;
    }
}
