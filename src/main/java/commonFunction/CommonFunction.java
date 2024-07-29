package commonFunction;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class CommonFunction {
    public static ExtentReports extent;
    public static ExtentSparkReporter sparkReporter;
    public static ExtentTest test;
    public static WebDriver driver = null;
    public static Actions act;

    @BeforeSuite
    public void browserLauncher() throws IOException {
        try {
            // Initialize ExtentReports
            sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//extentSparkReport.html");
            sparkReporter.config().setDocumentTitle("Automation Report");
            sparkReporter.config().setReportName("Automation Test Execution Report");
            sparkReporter.config().setTheme(Theme.STANDARD);
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            // Initialize WebDriver
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--disable-notifications");
            driver = new ChromeDriver(option);		
            act = new Actions(driver);
			driver.get("https://todo-trackerz.netlify.app/");
            driver.manage().window().maximize();

            // Open Google
            
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }

//    @AfterSuite
//    public void tearDown() {
//        // Close WebDriver
//        if (driver != null) {
//            driver.quit();
//        }
//
//        // Flush ExtentReports
//        if (extent != null) {
//            extent.flush();
//        }
//    }
}
