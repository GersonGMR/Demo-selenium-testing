import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.wikipedia.org");

        //locators
        //id
        Long start = System.currentTimeMillis();
        driver.findElement(By.id("js-link-box-en"));
        Long end = System.currentTimeMillis();

        System.out.println("El tiempo necesario para obtener el locator por id es: " + (end-start));

        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("js-link-box-en"))));
        //xpath
        start = System.currentTimeMillis();
        driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[2]/div[2]"));
        end = System.currentTimeMillis();
        System.out.println("El tiempo necesario para obtener el xpath es: " + (end-start));
        //cssSelector
        start = System.currentTimeMillis();
        driver.findElement(By.cssSelector("#www-wikipedia-org > div.central-featured > div.central-featured-lang.lang3"));
        end = System.currentTimeMillis();
        System.out.println("El tiempo necesario para obtener el cssSelector es: " + (end-start));

        //obtener texto y compararlo para verificar que el test es correcto
        WebElement tittleWebPage = driver.findElement(By.cssSelector("#www-wikipedia-org > div.central-textlogo > h1 > span"));
        String titleText = tittleWebPage.getText();
        String expectedTitleText = "Wikipedia";
        if (titleText.equals(expectedTitleText)) {
            System.out.println("Test has passed.");
        }else {
            System.out.println("Test has failed");
            driver.close();
            throw new Exception();
        }

        //Clicking on a WebPage
        /*WebElement englishButton = driver.findElement(By.id("js-link-box-en"));
        englishButton.click();
        String expectedTextOnClick = "Welcome to Wikipedia,";
        WebElement titleEnglishPage = driver.findElement(By.id("mp-welcome"));
        if(titleEnglishPage.getText().equals(expectedTextOnClick)){
            System.out.println("Test has passed, page is the english one.");
        } else {
            System.out.println("Test has failed! Click() was not successful.");
        }*/

        //Enviando texto en un webpage
        WebElement inputSearch= driver.findElement(By.id("searchInput"));
        String searchStr = "Selenium Webdriver";
        inputSearch.sendKeys(searchStr);
        WebElement searchButton = driver.findElement(By.cssSelector("#search-form > fieldset > button"));
        searchButton.click();

        //Cierra el driver para no consumir memoria en segundo plano
        driver.close();
    }
}
