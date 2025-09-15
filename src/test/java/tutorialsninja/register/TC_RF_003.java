package tutorialsninja.register;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
@Test
public class TC_RF_003 {





        public void registerWithMandatoryFields() {
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
            driver.get("https://tutorialsninja.com/demo/");
            driver.findElement(By.xpath("//span[text()='My Account']")).click();
            driver.findElement(By.linkText("Register")).click();
            driver.findElement(By.id("input-firstname")).sendKeys("John");
            driver.findElement(By.id("input-lastname")).sendKeys("Wick");
            driver.findElement(By.id("input-email")).sendKeys(gernarateNewEmail());
            driver.findElement(By.id("input-telephone")).sendKeys("9876543210");
            driver.findElement(By.id("input-password")).sendKeys("John@123");
            driver.findElement(By.id("input-confirm")).sendKeys("John@123");
            driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']")).click();
            driver.findElement(By.name("agree")).click();
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript("window.scrollBy(0,1000)", "");
            Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
            Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());
            String expectedHeading = "Your Account Has Been Created!";
            Assert.assertEquals(driver.findElement(By.cssSelector("#content h1")).getText(), expectedHeading);
            String expectedProperDetailsOne = "our Account Has Been Created!";
            String expectedProperDetailsTwo = "Congratulations! Your new account has been successfully created!";
            String expectedProperDetailsThree = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
            String expectedProperDetailsFour = " If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
            String expectedProperDetailsFive = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please ";
            String expectedProperDetailsSix = "contact us.";


            String actualProperDetails = driver.findElement(By.cssSelector("#content")).getText();
            Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsOne));
            Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsTwo));
            Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsThree));
            Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsFour));
            Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsFive));
            Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsSix));


            driver.findElement(By.xpath("//a[text()='Continue']")).click();
            Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

            driver.quit();

        }

        public String gernarateNewEmail() {

            return new Date().toString().replace(" ", "").replace(":", "") + "@gmail.com";

        }
    }


