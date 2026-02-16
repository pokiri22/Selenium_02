package Utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;
    public static WebDriverWait expWait;
    public static Wait<WebDriver> flueWait;
    public static FluentWait<WebDriver> d;
    public BaseClass() throws IOException {
        FileReader fr = new FileReader(System.getProperty("user.dir")+"//src//main//resources//global.properties");
        Properties prop = new Properties();
        prop.load(fr);
        if(prop.getProperty("Chrome_Options").equals("yes"))
        {
            System.out.println("chrome options enabled");
            ChromeOptions options =  Reusable_Methods.headleass_Testing();
            driver = new ChromeDriver(options);
        }
        else
         driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        expWait = new WebDriverWait(driver,Duration.ofSeconds(20));
        flueWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(40)).
                pollingEvery(Duration.ofSeconds(10)).
                ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
        d = expWait;

        try {
            driver.get(prop.getProperty("URL"));
            driver.manage().window().maximize();
        } catch (Exception e) {
            System.out.println("error is occured in BaseClass while getting the URL");
        }
    }
}
