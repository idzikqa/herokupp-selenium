package pl.idzikqa.herokuapp.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class MyTestListener implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        // before <test> tag in xml file
        System.out.println("ITestListener : onStart method started");
        ITestResult result;
        ITestNGMethod methods[] = context.getAllTestMethods();
        System.out.println("Methods will be executed in this test tag");
        for (ITestNGMethod method : methods
        ) {
            System.out.println(method.getMethodName());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        // after <test> tag in xml file
        System.out.println("ITestListener : onFinish method started");
    }

    @Override
    public void onTestStart(ITestResult result) {
        //when test method starts
        System.out.println("ITestListener : New Test Started" + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        //if test method is successful
        System.out.println("ITestListener : onTestSuccess Method" + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //if test method is failed
        System.out.println("ITestListener : onTestFailure Method" + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        //if test method is skipped
        System.out.println("ITestListener : onTestSkipped Method" + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("ITestListener : onTestFailedButWithinSuccessPercentage" + result.getName());
    }
}
