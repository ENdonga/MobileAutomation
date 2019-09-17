package testcases;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidSampleTest {
    public AndroidDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        String appiumServerURL = "http://127.0.0.1:4723/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nokia 6.1 Plus");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "a6a4776fabc10bfc");
        capabilities.setCapability(MobileCapabilityType.UDID, "DRGGAM5931805135");
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability("appActivity","com.android.calculator2.Calculator");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);


        driver = new AndroidDriver(new URL(appiumServerURL), capabilities);
    }

    @Test
    public void clickNumberTest(){
        WebElement numberSeven = driver.findElement(By.id("com.google.android.calculator:id/digit_7"));
        String text = numberSeven.getText();
        System.out.println(text);
        numberSeven.click();
        System.out.println("Clicked on number " + text);

    }
}
