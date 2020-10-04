package pl.idzikqa.herokuapp.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class MySuiteListener implements ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        //when <suite> tag starts
        System.out.println("SuiteListener : onStart function started "  + suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        //when <suit> tag finishes
        System.out.println("SuiteListener : onFinish function started "  + suite.getName());
    }
}
