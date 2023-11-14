import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static java.time.Duration.*;

public class Base extends utils{

    public AndroidDriver driver;

    public AppiumDriverLocalService service;
    public String srvAddress = "http://127.0.0.1:4723";



    @BeforeClass

    public void ConfigureAppiumServer() throws MalformedURLException {

        String LogsPath = "C:\\Users\\Dawid\\Desktop\\AppiumLogs\\Logs";
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss").format(new Date());


        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\Dawid\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withLogFile(new File(System.getProperty(LogsPath)+"appium.log"+ " " + timeStamp))
                .withTimeout(ofSeconds(200))
                .build();

        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Wingtech T Phone");
        options.setApp("resources\\General-Store.apk");
        driver = new AndroidDriver(new URL(srvAddress), options);
        driver.manage().timeouts().implicitlyWait(ofSeconds(20));
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        service.stop();
    }
}
