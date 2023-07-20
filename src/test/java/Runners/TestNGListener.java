package Runners;

import com.microsoft.playwright.Page;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static Base.TestBase.page;

public class TestNGListener implements ITestListener {
    int count = 0;
    public PrintWriter printWriterInit() {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("reports/logs.txt", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new PrintWriter(fileWriter);
    }

    public String getCurrentTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd_HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dateTimeFormatter.format(now);
    }

    @Override
    public void onTestStart(ITestResult result) {
        count++;
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        PrintWriter writer = printWriterInit();
        writer.println("     Test " + count + " started, status:  SUCCESS: " + getCurrentTime());
        writer.close();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        PrintWriter writer = printWriterInit();
        writer.println("     Test " + count + " started, status: FAILED: " + getCurrentTime());
        writer.close();
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("snaps/test" + count + "fail.png"))
                .setFullPage(true));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        PrintWriter writer = printWriterInit();
        writer.print("     Test " + count + " started, status: SKIPPED: " + getCurrentTime());
        writer.close();
        count++;
    }

    @Override
    public void onStart(ITestContext context) {
        PrintWriter writer = printWriterInit();
        writer.println("Test suite started: " + getCurrentTime());
        writer.close();
    }

    @Override
    public void onFinish(ITestContext context) {
        PrintWriter writer = printWriterInit();
        writer.println("Test suite finished: " + getCurrentTime() + "\n");
        writer.close();
        count = 0;
    }
}
