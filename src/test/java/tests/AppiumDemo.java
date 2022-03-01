package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDemo {
    public static AppiumDriver driver;

    @BeforeClass
    public void Android_setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "espresso");
        capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("showGradleLog",true);
        capabilities.setCapability("app",
                System.getProperty("user.dir") + "/apps/Calculator.apk");
        driver = new AndroidDriver(new URL("http://localhost:4724/wd/hub"), capabilities);
    }

    @Test
    public void calcDemo() throws InterruptedException {
        WebElement number1 = driver.findElementById("digit_1");
        WebElement plus =  driver.findElementById("op_add");
        WebElement number2 = driver.findElementById("digit_2");
        WebElement equal =  driver.findElementById("eq");

        number1.click();
        plus.click();
        number2.click();
        equal.click();
    }


    @AfterClass
    public static void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
