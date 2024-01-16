package utils;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FormPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AppiumDriverManager {
    public AppiumDriverLocalService service;
    public AndroidDriver driver;

    @BeforeClass
    public void configureAppium() throws MalformedURLException {

        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1");
//        builder.usingPort(4723);

        builder.usingAnyFreePort();

        service = AppiumDriverLocalService.buildService(builder);

        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel7");
        options.setApp("D:\\APKFiles\\resources\\ApiDemos-debug.apk");


        driver = new AndroidDriver(new URL(service.getUrl().toString()), options);
        FormPage formPage = new FormPage(driver);
    }


//    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
        service.stop();
    }

}
