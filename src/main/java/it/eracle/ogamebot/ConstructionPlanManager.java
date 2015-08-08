package it.eracle.ogamebot;

import it.eracle.ogamebot.constructionplans.CrystalMineConstructionPlan;
import it.eracle.ogamebot.constructionplans.DeuteriumMineConstructionPlan;
import it.eracle.ogamebot.constructionplans.MetalMineConstructionPlan;
import it.eracle.ogamebot.constructionplans.ResourceConstructionPlan;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * In MVC this is a control class.
 * Manages and lazily stores information on the building possibilities of Constructions that produces resources.
 * Created by eracle on 07/08/15.
 */
public class ConstructionPlanManager {



    /**
     *
     * @param driver
     */
    public ConstructionPlanManager(WebDriver driver){
        this.driver = driver;
        this.metalMine = null;
        this.crystalMine = null;
        this.deuteriumMine = null;
    }

    /** the webdriver for loading data */
    private WebDriver driver;

    /** Represent the next metal mine construction plan */
    private MetalMineConstructionPlan metalMine;

    /** Represent the next crystal mine construction plan */
    private CrystalMineConstructionPlan crystalMine;

    /** Represent the next deuterium mine construction plan */
    private DeuteriumMineConstructionPlan deuteriumMine;

    public MetalMineConstructionPlan getMetalMine() {
        if(metalMine==null){
            this.driver.findElement(By.xpath("//ul[@id='menuTable']/li[2]/a/span")).click();
            WebDriverWait wait = new WebDriverWait(this.driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".selected > span:nth-child(1)"))).click();

            driver.findElement(By.cssSelector(".supply1 > div:nth-child(1) > a:nth-child(2)")).click();
            this.metalMine = new MetalMineConstructionPlan();
            this.fillConstructionPlan(this.metalMine);
        }
        return metalMine;
    }

    public CrystalMineConstructionPlan getCrystalMine() {
        if(this.crystalMine==null){
            this.driver.findElement(By.xpath("//ul[@id='menuTable']/li[2]/a/span")).click();
            WebDriverWait wait = new WebDriverWait(this.driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".selected > span:nth-child(1)"))).click();

            driver.findElement(By.cssSelector(".supply2 > div:nth-child(1) > a:nth-child(2)")).click();

            this.crystalMine = new CrystalMineConstructionPlan();
            this.fillConstructionPlan(this.crystalMine);
        }
        return crystalMine;
    }

    public DeuteriumMineConstructionPlan getDeuteriumMine() {
        if(deuteriumMine == null) {
            this.driver.findElement(By.xpath("//ul[@id='menuTable']/li[2]/a/span")).click();
            WebDriverWait wait = new WebDriverWait(this.driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".selected > span:nth-child(1)"))).click();

            driver.findElement(By.cssSelector(".supply3 > div:nth-child(1) > a:nth-child(2)")).click();

            this.deuteriumMine = new DeuteriumMineConstructionPlan();
            this.fillConstructionPlan(this.deuteriumMine);
        }
        return deuteriumMine;
    }


    /**
     * Fills the ResourceConstructionPlan passed with the values parsed from the web page.
     * @param toBeFilled The ResourceConstructionPlan to fille with the values parsed from the page.
     */
    private void fillConstructionPlan(ResourceConstructionPlan toBeFilled){
       //
        //this.driver.findElement(By.id("details")).click();


        //duration parsing:
        //TODO: parse as a time interval (weeks,days,hours,minutes,seconds)
        int duration = Integer.parseInt((new WebDriverWait( this.driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("buildDuration"))).getText().replace("s", ""));
        toBeFilled.setProduction_duration(duration);

        //energy parsing
        String energy_str =  this.driver.findElement(By.cssSelector(".production_info > li:nth-child(2) > span:nth-child(1)")).getText().trim();
        int energy = Integer.parseInt(energy_str);
        toBeFilled.setEnergy_needed(energy);

        //metal parsing
        List<WebElement> m_elems = this.driver.findElements(By.cssSelector("li.tooltip:nth-child(1) > div:nth-child(2)"));
        int metal;
        if(m_elems.size()==0)
            metal=0;
        else if(m_elems.size()==1)
            metal = Integer.parseInt(m_elems.get(0).getText().trim());
        else throw new IllegalArgumentException("two or more metal elements selected by css selector");
        toBeFilled.setMetal_required(metal);

        //crystal parsing
        List<WebElement> c_elems = this.driver.findElements(By.cssSelector("li.tooltip:nth-child(2) > div:nth-child(2)"));
        int crystal;
        if(c_elems.size()==0)
            crystal=0;
        else if(c_elems.size()==1)
            crystal = Integer.parseInt(c_elems.get(0).getText().trim());
        else throw new IllegalArgumentException("two or more crystal elements selected by css selector");
        toBeFilled.setCrystal_required(crystal);

        //deuterium parsing
        List<WebElement> d_elems = this.driver.findElements(By.cssSelector("li.tooltip:nth-child(3) > div:nth-child(2)"));
        int deuterium;
        if(d_elems.size()==0)
            deuterium = 0;
        else if (d_elems.size()==1)
            deuterium = Integer.parseInt(d_elems.get(0).getText().trim());
        else throw new IllegalArgumentException("two or more deuterium elements selected by css selector");
        toBeFilled.setDeuterium_required(deuterium);

        //building level parsing
        String level_str = driver.findElement(By.cssSelector("span.level:nth-child(3)")).getText().trim();
        String lvl_int = level_str.split(" ")[1];
        toBeFilled.setBuilding_level(Integer.parseInt(lvl_int));

        String building_name = driver.findElement(By.cssSelector("#content > h2:nth-child(1)")).getText().trim();
        toBeFilled.setBuilding_name(building_name);

    }

}
