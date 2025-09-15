package tutorialsninja.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMultipart;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class TC_RF_002 {

    public static void main(String args[]) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("amazon password assistance");
        driver.findElement(By.cssSelector("a[ping*='forgotpassword'] h3")).click();
        driver.findElement(By.id("ap_email")).sendKeys("adityadeshpande35@gmail.com");
        driver.findElement(By.id("continue")).click();

        String appPasscode = "ejjk ymdi nqag nsuv";
        String email = "adityadeshpande35@gmail.com";


    }
}
