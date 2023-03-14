import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.wikipedia.org");

        //locators
        //id
        Long start = System.currentTimeMillis();
        driver.findElement(By.id("js-link-box-en"));
        Long end = System.currentTimeMillis();

        System.out.println("El tiempo necesario para obtener el locator por id es: " + (end-start));

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

        driver.close();
    }
}
