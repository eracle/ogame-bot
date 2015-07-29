package it.eracle.ogamebot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Represent an active current connection with a specified username and password to a specified Ogame server.
 * Created by eracle on 29/07/15.
 */
public class OgameConnection {

    /** Selenium Driver */
    private WebDriver driver;

    public OgameConnection() {
        driver = new FirefoxDriver();
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

        //I don't know what does this:
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get(serverUrl);
        driver.findElement(By.id("loginBtn")).click();
        driver.findElement(By.id("usernameLogin")).clear();
        driver.findElement(By.id("usernameLogin")).sendKeys(username);
        driver.findElement(By.id("passwordLogin")).clear();
        driver.findElement(By.id("passwordLogin")).sendKeys(password);
        driver.findElement(By.id("loginSubmit")).click();

        if(driver.findElement(By.cssSelector("div.icon")).getText().equals("Your username or password is wrong!")) {
            this.close();
            throw new IllegalArgumentException("Your username or password is wrong!");
        }
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       //

        //TODO: universe selection


    }

    /**
     * Close the connection.
     */
    public void close(){
        driver.quit();
    }
}

