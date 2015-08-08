package it.eracle.ogamebot;


import org.junit.Assert;
import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class OgameConnectionTest
{
    @Test(expected = org.openqa.selenium.NoSuchElementException.class)
    public void test_constructor_empty_usernamepassword() throws Exception {
        String serverUrl="http://en.ogame.gameforge.com/";
        String username="";
        String password="";
        String universe="";
        OgameConnection connection = new OgameConnection(serverUrl,universe, username, password);
        //Assert.assertNotNull(connection);


        connection.close();
    }

    @Test(expected = org.openqa.selenium.NoSuchElementException.class)
    public void testconstructor_wrongurl() throws Exception {
        String serverUrl="";
        String username="";
        String password="";
        String universe="";

        OgameConnection connection;

        connection = new OgameConnection(serverUrl,universe, username, password);

        //Assert.assertNotNull(connection);
        connection.close();
    }

    @Test
    public void testconstructor_login_correct(){
        String username="cocorito";
        String password="cocorito";
        String url="en.ogame.gameforge.com";
        String universe="Ganimed";

        OgameConnection connection = new OgameConnection(url,universe, username, password);

        Assert.assertTrue("Not Positive Value of metal", connection.getMetal() > 0);
        Assert.assertTrue("Not Positive Value of crystal", connection.getCrystal() > 0);
        Assert.assertTrue("Not Positive or zero Value of deuterium", connection.getDeuterium() >= 0);
        Assert.assertTrue("Not Positive or zero Value of energy", connection.getEnergy() >= 0);

        connection.close();
    }



}
