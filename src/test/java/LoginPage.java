
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPage extends Base {





    @Test
    public void ErrorValidationLoginTest(){
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Belgium\"));"));
        //scrollToText("Belgium");
        driver.findElement(By.xpath("//android.widget.TextView[@text='Belgium']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        WebElement toastView = driver.findElement(By.xpath("//android.widget.Toast[1]"));
        String toastMsg = toastView.getAttribute("name");
        Assert.assertEquals(toastMsg, "Please enter your name");

    }



    @Test
    public void PositiveLoginTest() throws InterruptedException {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("DAWID");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Belgium\"));"));
       //scrollToText("Belgium");
        driver.findElement(By.xpath("//android.widget.TextView[@text='Belgium']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        String pageTitle = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).getText();
        Assert.assertEquals(pageTitle, "Products");


    }

    @BeforeMethod
    public void cleanAppState(){
        Activity act = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");







    }
}
