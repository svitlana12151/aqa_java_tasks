package test.java.utils;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import test.java.lesson9_10_hometasks.DataProviders.ProducersDP;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer {


    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryAnalyzer.class);

        if(testMethod.getName().equals("selectedProducerIsApplied")) {
            annotation.setDataProviderClass(ProducersDP.class);
            annotation.setDataProvider("Producers");
        }
    }
}

