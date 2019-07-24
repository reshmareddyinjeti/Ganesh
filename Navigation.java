package ganesh.com.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Navigation {
    //back and forward simulation button are the part of browser elements and
//not a webelements

    public static WebDriver driver;

    @Before
    public void launchBrowser() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
         driver.quit();
    }
    @Test
    public void navigation(){
        driver.get("http:/www.google.com");
        driver.navigate().to("http:/www.argos.uk.co/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }
    @Test
    public void ScreenShort() throws IOException {
        driver.get("https://www.argos.co.uk/");
        File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("/Users/sandeep/Downloads/ganeshcom/src/test/java/ganesh/com/webdriver/argos.png"));
    }
    @Test
    public void nike() throws IOException {
        driver.get("https://www.nike.com");

        File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("/Users/sandeep/Downloads/ganeshcom/src/test/java/ganesh/com/webdriver/NIKE.png"));
    }



    @Test
    public void explicitWait(){
        driver.get("https://www.argos.co.uk/");
    // new WebDriverWait(driver,20).ignoring(S)
    }
}
