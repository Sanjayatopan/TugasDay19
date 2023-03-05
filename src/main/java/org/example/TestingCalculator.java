package org.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestingCalculator {
    private static AndroidDriver<MobileElement> driver;
    public Calculator calculator;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "Pixel_4");
        dc.setCapability("udid", "emulator-5556");
        dc.setCapability("platformName", "Android");
        dc.setCapability("platformVersion", "14");
        dc.setCapability("appPackage", "com.google.android.calculator");
        dc.setCapability("appActivity", "com.android.calculator2.Calculator");


//        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
//
//        driver = new AndroidDriver(remoteUrl, dc);
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
    }
    @BeforeMethod
    public void pageObject() {
        calculator = new Calculator(driver);
    }

    @Test (priority = 1)
    public void testAdd() {
        calculator.calcAdd();
        System.out.println("Hasil = "+calculator.getTxtResult());
        Assert.assertEquals(calculator.getTxtResult(), "4");
    }


    @Test (priority = 2)
    public void testMul() {
        calculator.calcMul();
        System.out.println("Hasil = "+calculator.getTxtResult());
        Assert.assertEquals(calculator.getTxtResult(), "12");
    }

    @Test (priority = 3)
    public void testSub() {
        calculator.calcSub();
        System.out.println("Hasil = "+calculator.getTxtResult());
        Assert.assertEquals(calculator.getTxtResult(), "2");
    }

    @Test (priority = 4)
    public void testDiv() {
        calculator.calcDiv();
        System.out.println("Hasil = "+calculator.getTxtResult());
        Assert.assertEquals(calculator.getTxtResult(),"2");
    }

    @AfterClass
    public void closeApp() {
        driver.quit();
    }

}
