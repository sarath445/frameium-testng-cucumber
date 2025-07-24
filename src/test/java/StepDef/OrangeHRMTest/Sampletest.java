package StepDef.OrangeHRMTest;

import TestngListener.ITestListeners;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ITestListeners.class)
public class Sampletest {

    @Test
    public void testMethod1() {
        System.out.println("i am insidetestmethod");
    }

    @Test
    public void testMethod2() {
        System.out.println("i am insidetestmethod");
        Assert.assertTrue(false);
    }
    @Test(timeOut = 1000)
    public void testMethod3() throws Exception{
        Thread.sleep(2000);
        System.out.println("i am insidetestmethod");

    }
    @Test(dependsOnMethods = "testMethod3")
    public void testMethod4() {
        System.out.println("i am insidetestmethod");
}
}










//https://www.odbm.org/
