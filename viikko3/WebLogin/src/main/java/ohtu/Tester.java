package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {

    public static void main(String[] args) {

        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:4567");

        System.out.println(driver.getPageSource());

//        epäonnistunut kirjautuminen: oikea käyttäjätunnus, väärä salasana
//        WebElement element = driver.findElement(By.linkText("login"));
//        element.click();
//
//        System.out.println(driver.getPageSource());
//
//        element = driver.findElement(By.name("username"));
//        element.sendKeys("Selenium");
//        element = driver.findElement(By.name("password"));
//        element.sendKeys("WrongPassword");
//        element = driver.findElement(By.name("login"));
//        
//        element.submit();
//        
//        System.out.println(driver.getPageSource());
//
//        driver.quit();
//        
//
//
//        uuden käyttäjätunnuksen luominen
//        WebElement element = driver.findElement(By.linkText("register new user"));
//        element.click();
//
//        System.out.println(driver.getPageSource());
//
//        Random rng = new Random();
//        element = driver.findElement(By.name("username"));
//        element.sendKeys("Alan" + rng.nextInt(100000));
//        element = driver.findElement(By.name("password"));
//        element.sendKeys("Turing");
//        element = driver.findElement(By.name("passwordConfirmation"));
//        element.sendKeys("Turing");
//        element = driver.findElement(By.name("signup"));
//        element.submit();
//
//        System.out.println(driver.getPageSource());
//
//        driver.quit();
//        
//
//
//        uuden käyttäjätunnuksen luomisen jälkeen tapahtuva ulkoskirjautuminen sovelluksesta
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        System.out.println(driver.getPageSource());

        Random rng = new Random();
        element = driver.findElement(By.name("username"));
        element.sendKeys("Alan" + rng.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("Turing");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("Turing");
        element = driver.findElement(By.name("signup"));
        element.submit();

        System.out.println(driver.getPageSource());

        WebElement element2 = driver.findElement(By.linkText("continue to application mainpage"));
        element2.click();
        
        System.out.println(driver.getPageSource());

        WebElement element3 = driver.findElement(By.linkText("logout"));
        element3.click();
        
        System.out.println(driver.getPageSource());

        driver.quit();

    }

    private static void sleep(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception e) {
        }
    }
}
