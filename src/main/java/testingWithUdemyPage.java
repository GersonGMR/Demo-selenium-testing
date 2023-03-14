import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class testingWithUdemyPage {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.udemy.com");

        //Click with JavaScriptExecutor
        WebElement signUpButton = driver.findElement(By.cssSelector("#es > div.ud-main-content-wrapper > div.ud-app-loader.ud-component--header-v6--header.ud-header.ud-app-loaded > div.ud-text-sm.header--header--1SLKV.header--flex-middle--2QeVR > div:nth-child(9) > a > span"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", signUpButton);

        //Setting up timeouts
        ((JavascriptExecutor) driver).executeAsyncScript("window.setTimeout(arguments[arguments.length-1], 1000");

        driver.close();
    }
}
