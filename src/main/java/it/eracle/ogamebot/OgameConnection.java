package it.eracle.ogamebot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import org.openqa.selenium.support.ui.Select;

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
     * @param universe
     * @return
     */
    public void login(String serverUrl, String username, String password, String universe) {

        //I don't know what does this:
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        if(!serverUrl.startsWith("http://"))
            serverUrl="http://"+serverUrl;

        driver.get(serverUrl);
        driver.findElement(By.id("loginBtn")).click();
        driver.findElement(By.id("usernameLogin")).clear();
        driver.findElement(By.id("usernameLogin")).sendKeys(username);
        driver.findElement(By.id("passwordLogin")).clear();
        driver.findElement(By.id("passwordLogin")).sendKeys(password);

        new Select(driver.findElement(By.id("serverLogin"))).selectByVisibleText(universe);

        driver.findElement(By.id("loginSubmit")).click();

        try{
            if(driver.findElement(By.cssSelector("div.icon")).getText().equals("Your username or password is wrong!")) {
                this.close();
                throw new IllegalArgumentException("Your username or password is wrong!");
            }
        }catch(org.openqa.selenium.NoSuchElementException e ){
            //TODO: Logging a successful login
            //TODO: A better handling of the exceptions flow
        }




    }

    /**
     * Close the connection.
     */
    public void close(){
        driver.quit();
    }
}

