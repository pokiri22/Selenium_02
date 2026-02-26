package ApplicationCode;

import Framework_Code.Framework1;
import PageObjects.BasicObjects;
import Utilities.BaseClass;
import Utilities.Reusable_Methods;
import org.apache.poi.ss.formula.functions.T;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class BasicOperations extends BaseClass {

    public static Framework1 fw;
    BasicObjects BO;
    static Actions act;
    public WebDriver driver_BO = new ChromeDriver();
    public BasicOperations() throws IOException, InterruptedException {
        System.out.println(" Basic Operations object is created");
        fw = new Framework1();
        BO = PageFactory.initElements(driver,BasicObjects.class);
        this.driver_BO = driver;
    }
    public void basic_Authentication(String username,String pass) throws InterruptedException, MalformedURLException {
        // https://username:password@url
        // username = admin , password = admin
        String url_string = "https://"+username+":"+pass+"@the-internet.herokuapp.com/basic_auth";
        driver.get(url_string);
        Thread.sleep(4000);
        driver.navigate().back();
        // method 2 - selenium 4
        // ((HasAuthentication) driver).register(UsernameAndPassword.of("admin", "admin"))
    }
    public void broken_Images() throws InterruptedException {
        System.out.println("start of the fun");
        flueWait.until(ExpectedConditions.visibilityOf(BO.broken_img_link));
        fw.click(BO.broken_img_link);
        System.out.println("the size of the array is "+BO.images.size());
        // selenium itself can't handle broken images. so, we have to use JSExecutor.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Boolean b;
        for(WebElement ele : BO.images)
        {
            b= (Boolean) js.executeScript("return arguments[0].complete && arguments[0].naturalWidth>0",ele);
            if(b==true)
                System.out.println("image is good");
            else
                System.out.println("iimage is broken");
        }
    }

    public void contex_Menu_Area() throws InterruptedException {
        BO.context_menu.click();
        Actions act = new Actions(driver);
        act.moveToElement(BO.context_menu_area).contextClick().perform();
        flueWait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void disappearing_Elements()
    {
        BO.disappearing.click();
        // if we refresh the page 2 or 3 times the disappeared element is being displayed. I have tested it manually
        for(int i = 0;i<4;i++)
        {
            driver.navigate().refresh();
            try {
              WebElement ele =   expWait.until(ExpectedConditions.visibilityOf(BO.disappearing_ele.get(0)));
              if(ele.isDisplayed())
                  System.out.println("shakalaka element is displayed");
            }
            catch (Exception e) {
                System.out.println("element is not present");
            }
        }
    }

    public void drag_And_Drop() throws InterruptedException {
        BO.drap_and_drop_link.click();
        Actions act = new Actions(driver);
        //act.dragAndDrop(BO.dragA,BO.dropB).perform();

        // method 2
        act.clickAndHold(BO.dragA).moveToElement(BO.dropB).release().perform();
        Thread.sleep(400);
    }

    public void entry_Add()
    {
        BO.entry_ad_link.click();
        try {
            WebElement ele = flueWait.until(ExpectedConditions.visibilityOf(BO.modal_popup));
            BO.close.click();
        }
        catch (Exception e)
        {
            System.out.println("error occured");
        }
    }

    public void exit_Intent() throws InterruptedException {
        BO.exit_intent.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(BO.body_ele).perform();
        Rectangle rect = BO.body_ele.getRect();
        System.out.println("the dimentions are "+rect.x+" and "+rect.y);
        actions.scrollByAmount(0,-10).perform();
        actions.moveToElement(BO.body_ele).perform();
        ; // move the mouse cursor from current tab to outside the tab

        WebElement ele = expWait.until(ExpectedConditions.visibilityOf(BO.close2));
        BO.close2.click();
       // Thread.sleep(4000);
    }

    public void file_Download() throws InterruptedException {
        BO.file_download.click();
        BO.file_dowload_link.click();
        String path1 = System.getProperty("user.dir")+"\\tmpdownloads";
        String path2 = System.getProperty("user.dir")+"\\downloads";
        Reusable_Methods.wait_And_Copy_Downloads(path1,path2);
    }

    public void floating_Menu() throws InterruptedException {
        BO.floating_menu.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        BO.floating_menu_news.click();
        long height1 = (long) js.executeScript("return window.innerHeight");
        long height2 =  driver.manage().window().getSize().height;
        long height3 = (long) js.executeScript("return document.body.scrollHeight");

        long temp = height1;
        while(height1<=height3)
        {
            js.executeScript("window.scrollBy(0,arguments[0])",height1);
            height1+=temp;
            Thread.sleep(400);
        }
       js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void form_Authentication()
    {
        BO.form_authentication_link.click();
        BO.email_id.sendKeys("tomsmith");
        BO.password.sendKeys("SuperSecretPassword!");
        if(BO.email_id.getAttribute("value").equals("tomsmith") && BO.password.getAttribute("value").equals("SuperSecretPassword!"))
            System.out.println(" entered correct credentials ");
        else
            System.out.println(" entered wrong credentials ");
        BO.log_in.click();
    }

    public int no=0;
    public void frames()
    {
        BO.frames.click();
        BO.nested_frame.click();
        List<WebElement> list_of_frames = driver.findElements(By.tagName("frame"));
        loop_Frames(list_of_frames);
        System.out.println("the frames count is "+no);
        System.out.println("the size of the list is "+list_of_frames.size());
        driver.switchTo().frame(0);
        WebElement ele = driver.findElement(By.xpath("/html/frameset/frame[2]"));
        driver.switchTo().frame(ele);
        WebElement body = driver.findElement(By.xpath("//*[@id=\"content\"]"));
        String body_value = body.getText();
        System.out.println("the body value is "+body_value);
        driver.switchTo().defaultContent();
    }

    public int loop_Frames(List<WebElement> list)
    {
        if(list.size()<2)
            return 0;
        else {
            no+= list.size();
            System.out.println("the present value is "+no);
            for(int i=0;i<list.size();i++)
            {
                try {
                    driver.switchTo().frame(i);
                    List<WebElement> innerList = driver.findElements(By.tagName("frame"));
                    if(innerList.size()>1)
                        loop_Frames(innerList);
                    driver.switchTo().parentFrame();
                }
                catch (Exception e)
                {
                    return 0;
                }
            }
        }
        return 0;
    }

    public void geolocation() throws InterruptedException {
        BO.geolocation_link.click();
        BO.where_am_I.click();
    }

    public void horizontal_Slider() throws InterruptedException {
        BO.horizontal_slider_link.click();
        WebElement slider = BO.slider;
        act = new Actions(driver);

        slider.click();
        // Method 01:
       // act.dragAndDropBy(slider,10,0).perform();

        // Method 02:
        for(int i=0;i<5;i++) {
            slider.sendKeys(Keys.ARROW_RIGHT); // shifts the slider to Right side for 5 times
            // sometimes the slider points to a default value like ( 2.5 or 5 ) for first ( Keys.RIGHT )
            // It is Browser's mistake not the selenium mistake
        }

    }

    public void hover()
    {
        BO.hover_link.click();
        act = new Actions(driver);
        act.moveToElement(BO.hover_ele1).moveToElement(BO.hover_ele2).click(BO.hover_ele2).perform();
    }

    public void infinite_Scroll() throws InterruptedException {
        BO.infinite_scroll_link.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long present_height = (long) js.executeScript("return document.body.scrollHeight");
        while(true)
        {
            Thread.sleep(2000);
            js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
            long future_height = (long) js.executeScript("return document.body.scrollHeight");
            if(present_height==future_height)
                break;
            System.out.println("the height is "+future_height);
        }
    }

    public void JQuery_UI()
    {
        BO.JQuery_UI_link.click();
        act = new Actions(driver);
        hover_Multiple_Elements(By.xpath("//*[@id=\"ui-id-3\"]/a"),By.xpath("//*[@id=\"ui-id-4\"]/a"),By.xpath("//*[@id=\"ui-id-5\"]/a"));
    }

    public void hover_Multiple_Elements(By...eles)
    {
        act = new Actions(driver);
        int i;
        for(i=0;i< eles.length;i++)
        {
            WebElement curr_ele = expWait.until(ExpectedConditions.visibilityOfElementLocated(eles[i]));
            act.moveToElement(curr_ele).perform();
        }
        WebElement last_ele = expWait.until(ExpectedConditions.visibilityOfElementLocated(eles[i-1]));
        act.click(last_ele).perform();
    }

    public void inputs()
    {
        BO.input_link.click();
        BO.inputs_field.click();
        BO.inputs_field.sendKeys(Keys.ARROW_UP);    BO.inputs_field.sendKeys(Keys.ARROW_UP);
    }

    public void key_Pressing()
    {
        BO.keyPressing_link.click();
        act = new Actions(driver);
        act.keyDown(Keys.TAB).keyDown(Keys.TAB).keyDown(Keys.ENTER).keyDown(Keys.ENTER).perform();
    }

    public void windows() throws InterruptedException {
        String curr = driver.getWindowHandle();
        System.out.println(curr);
        BO.multiple_windows_link.click();
        BO.new_window.click();
        Set<String> set = driver.getWindowHandles();
        for(String x:set)
            System.out.println(x);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.close();
        driver.switchTo().window(curr);
        driver.navigate().back();
        Thread.sleep(4000);
        driver.close();
    }

    public void refreshing_Text()
    {
        BO.notification_link.click();
        String text = BO.txt.getText();
        System.out.println("the previous text is "+text);
        BO.click_for_new_text.click();
        text = BO.txt.getText();
        System.out.println("the Updated text is "+text);
    }

    public void assertions()
    {
        BO.typos_link.click();
        String text = BO.typo_text.getText();
        System.out.println("the actual text is "+text);

        SoftAssert ass = new SoftAssert();
        ass.assertEquals(text,"Sometimes you'll see a typo, other times you won==,t.");
        ass.assertAll();
    }

    public  static void main(String[] args) throws IOException, InterruptedException {
        BasicOperations obj = new BasicOperations();
        obj.assertions();
        //driver.quit();
        WebElement ele = driver.findElement(RelativeLocator.with(By.xpath("")).below(By.xpath("")));
    }
}
