package basicAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BasicAppiumTestFanny {

    private AppiumDriver driver;



    @Before
    public void beforeTest() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","cedric");
        capabilities.setCapability("platformVersion","8.1");
        capabilities.setCapability("appPackage","com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity","com.vrproductiveapps.whendo.ui.HomeActivity");
        capabilities.setCapability("platformName","Android");
        /*capabilities.setCapability("deviceName","testqa");
        capabilities.setCapability("platformVersion","7");
        capabilities.setCapability("appPackage","com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity","com.vrproductiveapps.whendo.ui.HomeActivity");
        capabilities.setCapability("platformName","Android");
*/
        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        //implicit
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void verifyToDo(){
        //Click plus - AÑADIR NOTA
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
        //LLENAR FORMULARIO
        //Título
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys("Tomar agua");
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys("Tomar agua y ponerse de pie");
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/note_item_reminder_date1")).click();
        //asignar una hora con el reloj
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/time")).click();
        driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"11\"]")).click();
        driver.findElement(By.id("android:id/am_label")).click();
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Guardar']")).click();
        //Aceptar
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();


        String create = "Test Prueba";
        WebElement message = driver.findElement(By.id("com.vrproductiveapps.whendo:id/home_list_item_text"));
        Assert.assertEquals("Es correcto",create,message.getText());



    }

    @After
    public void afterTest(){
        driver.quit();
    }

}