import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class utils {
    AndroidDriver driver;




    public void longPressAction(WebElement element, int duration){
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "duration",duration
        ));
    }

    public void scrollToText(String text) throws InterruptedException {
        //Thread.sleep(2000);
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));

    }

    public void scrollToEndAction(double speed){
        boolean canScrollMore;
        do {

            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", speed


            ));
        }while(canScrollMore);
    }

    public void swipeAction(WebElement ele, String direction, double percent){
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "direction", direction,
                "percent", percent
        ));
    }

    public void dragAndDropAction(WebElement ele, int endX, int endY){
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "endX", endX,
                "endY", endY
        ));
    }

    public void WaitUntilAttributeMatchesText(int durationOfSeconds,WebElement element, String Attribute, String TextToMatch){
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(durationOfSeconds));
        wait.until(ExpectedConditions.attributeContains(element, Attribute, TextToMatch));
    }

    public Double getFormattedAmount(String amount){
        Double price = Double.parseDouble(amount.substring(1));
        return price;
    }
}
