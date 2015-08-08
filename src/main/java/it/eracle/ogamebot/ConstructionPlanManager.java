package it.eracle.ogamebot;

import it.eracle.ogamebot.it.eracle.ogamebot.buildings.MetalMineConstructionPlan;
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
        this.metalMine = null;
        this.crystalMine = null;
        this.deuteriumMine = null;
    }

    /** Represent the next metal mine construction plan */
    private MetalMineConstructionPlan metalMine;

    /** Represent the next crystal mine construction plan */
    private CrystalMineConstructionPlan crystalMine;

    /** Represent the next deuterium mine construction plan */
    private DeuteriumMineConstructionPlan deuteriumMine;

    public MetalMineConstructionPlan getMetalMine() {
        if(metalMine==null){

        }
        return metalMine;
    }

    public CrystalMineConstructionPlan getCrystalMine() {
        if(this.crystalMine==null){
            this.crystalMine=a;
        }
        return crystalMine;
    }

    public DeuteriumMineConstructionPlan getDeuteriumMine() {
        if(deuteriumMine == null) {
            this.deuteriumMine=a;
        }
        return deuteriumMine;
    }
    //TODO: refactor this, is responsible of the parsing of the attributes of a generic building plan
    {driver.findElement(By.xpath("//ul[@id='menuTable']/li[2]/a/span")).click();
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


        this.metalMine = new MetalMineConstructionPlan(duration,energy,crystal,metal,deuterium);}

}
