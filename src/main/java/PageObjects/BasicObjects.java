package PageObjects;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BasicObjects {

    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[4]/a")
    public WebElement broken_img_link;

    @FindBy(xpath = "//h3[.='Broken Images']//following-sibling::img")
    public List<WebElement> images;

    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[7]/a")
    public WebElement context_menu;

    @FindBy(xpath = "//*[@id=\"hot-spot\"]")
    public WebElement context_menu_area;

    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[9]/a")
    public WebElement disappearing;

    @FindBy(xpath = "//*[@id=\"content\"]/div/ul/li[5]/a")
    public List<WebElement> disappearing_ele;

    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[10]/a")
    public WebElement drap_and_drop_link;

    @FindBy(xpath = "//*[@id=\"column-a\"]")
    public WebElement dragA;

    @FindBy(xpath = "//*[@id=\"column-b\"]")
    public WebElement dropB;

    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[15]/a")
    public WebElement entry_ad_link;

    @FindBy(xpath = "//*[@id=\"modal\"]/div[2]/div[1]/h3")
    public WebElement modal_popup;

    @FindBy(xpath = "//*[@id=\"modal\"]/div[2]/div[3]/p")
    public WebElement close;

    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[16]/a")
    public WebElement exit_intent;

    @FindBy(xpath = "//*[@id=\"ouibounce-modal\"]/div[2]/div[3]/p")
    public WebElement close2;

    @FindBy(xpath ="//*[@id=\"content\"]/div[1]/../../../..")
    public WebElement body_ele;

    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[17]/a")
    public WebElement file_download;

    @FindBy(xpath = "//*[@id=\"content\"]/div/a[32]")
    public WebElement file_dowload_link;

    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[19]/a")
    public WebElement floating_menu;

    @FindBy(xpath = "//*[@id=\"menu\"]/ul/li[2]/a")
    public WebElement floating_menu_news;

    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[21]/a")
    public WebElement form_authentication_link;

    @FindBy(xpath = "//*[@id=\"username\"]")
    public WebElement email_id;

    @FindBy(xpath = "//*[@id=\"password\"]")
    public WebElement password;

    @FindBy(xpath = "//*[@id=\"login\"]/button/i")
    public WebElement log_in;

    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[22]/a")
    public WebElement frames;

    @FindBy(xpath = "//*[@id=\"content\"]/div/ul/li[1]/a")
    public WebElement nested_frame;

    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[23]/a")
    public WebElement geolocation_link;

    @FindBy(xpath = "//*[@id=\"content\"]/div/button")
    public WebElement where_am_I;

    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[24]/a")
    public WebElement horizontal_slider_link;

    @FindBy(xpath = "//input[@type='range']")
    public WebElement slider;

    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[25]/a")
    public WebElement hover_link;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/img")
    public WebElement hover_ele1;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/a")
    public WebElement hover_ele2;

    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[26]/a")
    public WebElement infinite_scroll_link;

    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[27]/a")
    public WebElement input_link;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/input")
    public WebElement inputs_field;

    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[28]/a")
    public WebElement JQuery_UI_link;

    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[31]/a")
    public WebElement keyPressing_link;

    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[33]/a")
    public WebElement multiple_windows_link;

    @FindBy(xpath = "//*[@id=\"content\"]/div/a")
    public WebElement new_window;

    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[35]/a")
    public WebElement notification_link;

    @FindBy(xpath = "//*[@id=\"content\"]/div/p/a")
    public WebElement click_for_new_text;

    @FindBy(xpath = "//*[@id=\"flash\"]")
    public WebElement txt;

    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[43]/a")
    public WebElement typos_link;

    @FindBy(xpath = "//*[@id=\"content\"]/div/p[2]")
    public WebElement typo_text;
}
