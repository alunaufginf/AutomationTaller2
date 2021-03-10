package basicAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BasicAppiumTest {
    private AppiumDriver driver;



    @Before
    public void beforeTest() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","testqa");
        capabilities.setCapability("platformVersion","7");
        capabilities.setCapability("appPackage","com.example.android.contactmanager");
        capabilities.setCapability("appActivity","com.example.android.contactmanager.ContactManager");
        capabilities.setCapability("platformName","Android");

        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        //implicit
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
    }

    @Test
    public void verify_calculator(){
        driver.findElement(By.id("com.example.android.contactmanager:id/addContactButton")).click();

    }

    @After
    public void afterTest(){
        driver.quit();
    }

}
