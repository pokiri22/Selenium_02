package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.text.html.Option;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Reusable_Methods {
    public static ChromeOptions options = new ChromeOptions();;
    public static ChromeOptions set_Chrome_Options() throws IOException {
         // I want to add some configurations to the chrome before launching it
        String path = System.getProperty("user.dir")+"\\tmpdownloads";
        Files.createDirectories(Paths.get(path));
        System.out.println("the path is "+path);
        Map<String,Object> map = new HashMap<>(); // I can add configurations through map
        map.put("download.default_directory",path); // tells the browser to store the downloaded file at this location
        map.put("download.prompt_for_download",false); // it disables - SaveAs popup becuase, selenium can't handle these kind of OS popups. and it leads to auto download to the default directory location
        map.put("download.directory_upgrade",true); // enables overwriting
        map.put("safebrowsing.enabled", true);
        options.setExperimentalOption("prefs",map);
        System.out.println("chrome options are added");
        return options;
    }
    public static void wait_And_Copy_Downloads(String temp_download_path,String copy_download_path) throws InterruptedException {
        File F1 = new File(temp_download_path);
        // Thread.sleep(Duration.ofMinutes(1));
        Thread.sleep(6000);
        File[] files = F1.listFiles();
        if(files.length>0)
            System.out.println("files are downloaded");
        else
            System.out.println("files are not downloaded");
    }
    public static ChromeOptions geolocation_Option()
    {
        Map<String,Object> map = new HashMap<>();
        map.put("profile.default_content_setting_values.geolocation",1);
        options.setExperimentalOption("prefs",map);
        return options;
    }

    public static ChromeOptions headleass_Testing()
    {
        options.addArguments("--headless=new");
        return options;
    }

}
