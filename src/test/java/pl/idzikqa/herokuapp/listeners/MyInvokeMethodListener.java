package pl.idzikqa.herokuapp.listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class MyInvokeMethodListener implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println(
                "Before Invocation Method Started For : " + method.getTestMethod().getMethodName()
                        + " of Class :" + testResult.getTestClass().getName());
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

        System.out.println("After Invocation Method Started For : "
                + method.getTestMethod().getMethodName()
                + " of Class : " + testResult.getTestClass().getName());

    }
}
