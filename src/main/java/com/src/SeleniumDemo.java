package com.src;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumDemo {
    WebDriver driver = null;
   public DesiredCapabilities chromeDriver(){
       DesiredCapabilities dc;
       dc = DesiredCapabilities.chrome();
      /* System.setProperty("http.proxyHost", "127.0.0.1");
       System.setProperty("http.proxyPort", "9090");
       System.setProperty("https.proxyHost", "127.0.0.1");
       System.setProperty("https.proxyPort", "9090");*/
       ChromeOptions options = new ChromeOptions();
       options.addArguments("start-maximized");
       options.addArguments("--disable-extensions");
       dc.setCapability(ChromeOptions.CAPABILITY, options);
        return dc;
   }
   @BeforeTest
   public void getDriver(){
       System.setProperty("webdriver.chrome.driver", "E:\\software\\chrome\\chromedriver.exe");
       driver =  new ChromeDriver();
   }
   @Test
   public void launch(){
       driver.get("https://www.facebook.com/");
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       driver.manage().window().maximize();
       Assert.assertTrue(true);
   }
    @AfterTest
    public void closeBrowser(){
           driver.quit();
    }

    /*public static void main1(String[] args) {
        SeleniumDemo sd = new SeleniumDemo();
        sd.getDriver("chrome");
       // sd.launch("https://www.facebook.com/");

        System.out.println(sd.driver.getTitle());
        sd.closeBrowser();
    }*/
}
