import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class SeleniumTest {
    private WebDriver webDriver;

    @Before
    public void setUp() {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");

        // Get file
        File file = new File("index.html");
        String path = "file://" + file.getAbsolutePath();

        // Create a new ChromeDriver instance
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        webDriver = new ChromeDriver(options);

        // Open the HTML file
        webDriver.get(path);
    }

    @After
    public void tearDown() {
        // Close the browser
        webDriver.quit();
    }

    @Test
    public void testPageText() throws InterruptedException {
        //setup
        WebElement speechPart1 = webDriver.findElement(By.id("opening"));
        String opening = "To be, or not to be, that is the question:";
        WebElement speechPart2 = webDriver.findElement(By.id("theRest"));
        String theRest = "Whether 'tis nobler in the mind to suffer";

        Thread.sleep(6000);

        Assert.assertEquals(opening, speechPart1.getText());
        Assert.assertEquals(theRest, speechPart2.getText().substring(0, 41));
    }


}
