package it.eracle.ogamebot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

/**
 * Represent an active current connection with a specified username and password to a specified Ogame server.
 * Created by eracle on 29/07/15.
 */
public class OgameConnection {
    public void OgameConnection() {
    }

    /**
     * Represent the action of a login to a specified server and with a specified username and password.
     * Once login the <code>OgameConnection</code> object instance is changed.
     * TODO: Finish the documentation after implementation phase. FDAIP
     *
     * @param serverUrl
     * @param username
     * @param password
     * @return
     */
    public void login(String serverUrl, String username, String password) {

        // The Firefox driver supports javascript
        WebDriver driver = new FirefoxDriver();

        // Go to the Google Suggest home page
        driver.get(serverUrl);

        // Enter the query string "Cheese"
        WebElement query = driver.findElement(By.name("q"));
        query.sendKeys("Cheese");

        // Sleep until the div we want is visible or 5 seconds is over
        long end = System.currentTimeMillis() + 5000;
        while (System.currentTimeMillis() < end) {
            WebElement resultsDiv = driver.findElement(By.className("gssb_e"));

            // If results have been returned, the results are displayed in a drop down.
            if (resultsDiv.isDisplayed()) {
                break;
            }
        }

        // And now list the suggestions
        List<WebElement> allSuggestions = driver.findElements(By.xpath("//td[@class='gssb_a gbqfsf']"));

        for (WebElement suggestion : allSuggestions) {
            System.out.println(suggestion.getText());
        }

        driver.quit();
    }
}

