package it.eracle.ogamebot;

import it.eracle.ogamebot.it.eracle.ogamebot.buildings.MetalMineConstruction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.IllegalFormatException;
import java.util.List;

/**
 * Represent an active current connection with a specified username and password to a specified Ogame server.
 * Created by eracle on 29/07/15.
 */
public class OgameConnection {

    /** Selenium Driver */
    private WebDriver driver;

    /** Connection Status
    private enum status {
        DISCONNECTED, CONNECTED
    }
     */
    //private status connectionStatus;

    /**
     * Constructor which also does the action of login to a specified server, and universe,
     * with a specified username and password.
     * TODO: Finish the documentation after implementation phase. FDAIP
     *
     * @param serverUrl
     * @param universe
     * @param username
     * @param password
     * @return
     */
    public OgameConnection(String serverUrl,  String universe, String username, String password) {
        //class initialization related stuffs
        driver = new FirefoxDriver();
        //this.connectionStatus = status.DISCONNECTED;

        //login stuffs
        if(!serverUrl.equals("") && !serverUrl.startsWith("http://"))
            serverUrl="http://"+serverUrl;

        driver.get(serverUrl);
        driver.findElement(By.id("loginBtn")).click();
        driver.findElement(By.id("usernameLogin")).clear();
        driver.findElement(By.id("usernameLogin")).sendKeys(username);
        driver.findElement(By.id("passwordLogin")).clear();
        driver.findElement(By.id("passwordLogin")).sendKeys(password);

        new Select(driver.findElement(By.id("serverLogin"))).selectByVisibleText(universe);

        driver.findElement(By.id("loginSubmit")).click();

        //old check if the password was wrong
        /*
        try{
            if(driver.findElement(By.cssSelector("div.icon")).getText().equals("Your username or password is wrong!")) {
                this.close();
                throw new IllegalArgumentException("Your username or password is wrong!");
            }
        }catch(org.openqa.selenium.NoSuchElementException e ){
            //this.connectionStatus = status.CONNECTED;
            //TODO: Logging a successful login
            //TODO: A better handling of the exceptions flow
        }
        */
    }


    /**
     * Return the quantity of the metal resource owned.
     * @return Quantity of metal owned.
     */
    public int getMetal(){
        return Integer.parseInt(driver.findElement(By.id("resources_metal")).getText().replace(".",""));
    }

    /**
     * Return the quantity of the crystal resource owned.
     * @return Quantity of crystal owned.
     */
    public int getCrystal(){
        return Integer.parseInt(driver.findElement(By.id("resources_crystal")).getText().replace(".", ""));
    }

        /**
         * Return the quantity of the deuterium resource owned.
         * @return Quantity of deuterium owned.
         */
     public int getDeuterium(){
         return Integer.parseInt(driver.findElement(By.id("resources_deuterium")).getText().replace(".", ""));
     }

    /**
     * Return the quantity of the energy resource owned.
     * @return Quantity of metal owned.
     */
    public int getEnergy(){
        return Integer.parseInt(driver.findElement(By.id("resources_energy")).getText().replace(".",""));
    }

    /**
     * Close the connection.
     */
    public void close(){
        driver.quit();
        //this.connectionStatus = status.DISCONNECTED;
    }

    /**
     * Check if a mine can be build. Return true if it can, false otherwise.
     * @return  True if the mine can be build, false otherwise.
     */
    public boolean canBuildMetalMine() {
        //TODO: the method return true also if the mine is not buildable
        driver.findElement(By.linkText("Resources")).click();
        driver.findElement(By.id("details")).click();

        //I need to wait for the element a.build-it > span
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.build-it > span")));


        String buildStr = myDynamicElement.getText().trim();
        //System.out.print(buildStr);
        return buildStr.equals("Improve");
    }


    /**
     * Build a mine if it can be build.
     */
    public void buildMetalMine() {
       //TODO: finish the doc and implementation
    }


    public MetalMineConstruction getMetalMineConstruction() {

        driver.findElement(By.xpath("//ul[@id='menuTable']/li[2]/a/span")).click();
        driver.findElement(By.id("details")).click();


        //duration parsing:
        //TODO: parse as a time interval (weeks,days,hours,minutes,seconds)
        int duration = Integer.parseInt((new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("buildDuration"))).getText().replace("s", ""));

        //energy parsing
        String energy_str = driver.findElement(By.cssSelector(".production_info > li:nth-child(2) > span:nth-child(1)")).getText().trim();
        int energy = Integer.parseInt(energy_str);

        //metal parsing
        List<WebElement> m_elems = driver.findElements(By.cssSelector("li.tooltip:nth-child(1) > div:nth-child(2)"));
        int metal;
        if(m_elems.size()==0)
            metal=0;
        else if(m_elems.size()==1)
            metal = Integer.parseInt(m_elems.get(0).getText().trim());
        else throw new IllegalArgumentException("two or more metal elements selected by css selector");

        //crystal parsing
        List<WebElement> c_elems = driver.findElements(By.cssSelector("li.tooltip:nth-child(2) > div:nth-child(2)"));
        int crystal;
        if(c_elems.size()==0)
            crystal=0;
        else if(c_elems.size()==1)
            crystal = Integer.parseInt(c_elems.get(0).getText().trim());
        else throw new IllegalArgumentException("two or more crystal elements selected by css selector");

        //deuterium parsing
        List<WebElement> d_elems = driver.findElements(By.cssSelector("li.tooltip:nth-child(3) > div:nth-child(2)"));
        int deuterium;
        if(d_elems.size()==0)
            deuterium = 0;
        else if (d_elems.size()==1)
            deuterium = Integer.parseInt(d_elems.get(0).getText().trim());
        else throw new IllegalArgumentException("two or more deuterium elements selected by css selector");


        return new MetalMineConstruction(duration,energy,crystal,metal,deuterium);

    }

    /**
     * Return true if the construction queue is empty.
     * @return
     */
    public boolean isEmptyConstructionQueue() {
        //TODO: implementation and docs
        return true;
    }
}

