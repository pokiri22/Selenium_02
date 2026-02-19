package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

import static Utilities.BaseClass.driver;

public class Relative_Objects {
    public By locator1 = By.xpath("//html/body/div/input");
    public WebElement password_Ele()
    {
        return  driver.findElement(RelativeLocator.with(By.xpath("//div[.='something']")).below(locator1));
    }
    // @Find never supports RelativeLocator so, the best practice for these RelativeLocators is like this
    // @FindBy only supports standard locator strategies. Relative locators must be used with driver.findElement() directly inside methods.
}
