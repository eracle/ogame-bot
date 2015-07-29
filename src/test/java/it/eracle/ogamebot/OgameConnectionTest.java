package it.eracle.ogamebot;


import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class OgameConnectionTest
{
    @Test(expected=IllegalArgumentException.class)
    public void testlogin_empty_usernamepassword() throws Exception {
        String serverUrl="http://en.ogame.gameforge.com/";
        String username="";
        String password="";
        OgameConnection connection = new OgameConnection();
        connection.login(serverUrl, username, password);
        //Assert.assertNotNull(connection);
        connection.close();
    }

    @Test(expected = org.openqa.selenium.NoSuchElementException.class)
    public void testlogin_wrongurl() throws Exception {
        String serverUrl="";
        String username="";
        String password="";
        OgameConnection connection = new OgameConnection();
        try{
            connection.login(serverUrl, username, password);
        }catch(org.openqa.selenium.NoSuchElementException e){
            connection.close();
            throw e;
        }
        //Assert.assertNotNull(connection);
        connection.close();
    }


}
