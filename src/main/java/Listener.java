import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Good");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Good");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Bad");
    }
}
