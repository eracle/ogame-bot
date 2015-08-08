package it.eracle.ogamebot.constructionplans;

import it.eracle.ogamebot.ConstructionPlanManager;
import it.eracle.ogamebot.OgameConnection;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by eracle on 08/08/15.
 */
public class ConstructionPlanManagerTest {


    private ConstructionPlanManager sut;
    private OgameConnection connection;

    @Before
    public void setUp() throws Exception {
        String username="cocorito";
        String password="cocorito";
        String url="en.ogame.gameforge.com";
        String universe="Ganimed";

        this.connection = new OgameConnection(url,universe, username, password);

        this.sut = connection.getConstructionPlanManager();
    }

    @After
    public void tearDown() throws Exception {
        this.connection.close();
    }

    @Test
    public void testGetMetalMine() throws Exception {

        MetalMineConstructionPlan mm = this.sut.getMetalMine();

        Assert.assertNotNull(mm);
        Assert.assertEquals("Metal Mine", mm.getBuilding_name());


        int level = mm.getBuilding_level();

        if(level == 0){
            Assert.assertTrue(mm.getMetal_required() == 60);

            Assert.assertTrue(mm.getCrystal_required() == 15);

            Assert.assertTrue(mm.getDeuterium_required() == 0);

            Assert.assertTrue(mm.getEnergy_needed() == 11);

            Assert.assertTrue(mm.getProduction_duration() == 7);
        }
        else {
            Assert.assertTrue(mm.getMetal_required() > 0);

            Assert.assertTrue(mm.getCrystal_required() > 0);

            Assert.assertTrue(mm.getDeuterium_required() >= 0);

            Assert.assertTrue(mm.getEnergy_needed() > 0);

            Assert.assertTrue(mm.getProduction_duration() > 0);
        }
        boolean canBuildmm = ( connection.getMetal()>=mm.getMetal_required() &&
                connection.getCrystal()>=mm.getCrystal_required() &&
                connection.getDeuterium()>=mm.getDeuterium_required() &&
                connection.isEmptyConstructionQueue()
        );

        Assert.assertTrue("Can or cannot build a mine", connection.canBuildMetalMine() == canBuildmm);


    }

    @Test
    public void testGetCrystalMine() throws Exception {
        CrystalMineConstructionPlan cm = this.sut.getCrystalMine();

        Assert.assertNotNull(cm);
        Assert.assertEquals("Crystal Mine", cm.getBuilding_name());

        int level = cm.getBuilding_level();
        if(level == 0){
            Assert.assertTrue(cm.getMetal_required() == 48);

            Assert.assertTrue(cm.getCrystal_required() == 24);

            Assert.assertTrue(cm.getDeuterium_required() == 0);

            Assert.assertTrue(cm.getEnergy_needed() == 11);

            Assert.assertTrue(cm.getProduction_duration() == 7);
        }else {
            Assert.assertTrue(cm.getMetal_required() > 0);

            Assert.assertTrue(cm.getCrystal_required() > 0);

            Assert.assertTrue(cm.getDeuterium_required() >= 0);

            Assert.assertTrue(cm.getEnergy_needed() > 0);

            Assert.assertTrue(cm.getProduction_duration() > 0);
        }
    }

    @Test
    public void testGetDeuteriumMine() throws Exception {
        DeuteriumMineConstructionPlan dm = this.sut.getDeuteriumMine();
        Assert.assertNotNull(dm);
        Assert.assertEquals("Deuterium Synthesizer",dm.getBuilding_name());


        int level = dm.getDeuterium_required();

        if(level == 1 ){
            Assert.assertTrue(dm.getMetal_required() == 337);

            Assert.assertTrue(dm.getCrystal_required() == 112);

            Assert.assertTrue(dm.getDeuterium_required() == 0);

            Assert.assertTrue(dm.getEnergy_needed() == 27);

            Assert.assertTrue(dm.getProduction_duration() == 54);
        }else {

            Assert.assertTrue(dm.getMetal_required() > 0);

            Assert.assertTrue(dm.getCrystal_required() > 0);

            Assert.assertTrue(dm.getDeuterium_required() >= 0);

            Assert.assertTrue(dm.getEnergy_needed() > 0);

            Assert.assertTrue(dm.getProduction_duration() > 0);
        }
    }

    //@Test
    public void testAllMinePlans(){

    }
}