package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumAndroidTest {
    public static AppiumDriver driver;

    @BeforeClass
    public void Android_setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:automationName", "espresso");
        capabilities.setCapability("appium:platformVersion", "9");
        capabilities.setCapability("appium:deviceName", "Android Emulator");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:app", System.getProperty("user.dir") + "/apps/app-debug.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
    }

    @Test
    public void calcDemo(){
        driver.findElement(By.id("buttonFive")).click();
        driver.findElement(By.id("buttonAdd")).click();
        driver.findElement(By.id("buttonFour")).click();
        driver.findElement(By.id("buttonEqual")).click();
    }

    @AfterClass
    public static void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
