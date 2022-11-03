package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumIOSTest {
    public static AppiumDriver driver;
    @BeforeClass
    public void Android_setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:automationName", "xcuitest");
        capabilities.setCapability("appium:platformVersion", "16.0");
        capabilities.setCapability("appium:deviceName", "iPhone 12 Pro");
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("appium:app", System.getProperty("user.dir") + "/apps/DailyCheck.zip");
        driver = new IOSDriver(new URL("http://127.0.0.1:4723"), capabilities);
    }
    @Test
    public void calcDemo(){
        driver.findElement(By.id("plus.circle")).click();
    }

    @AfterClass
    public static void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
