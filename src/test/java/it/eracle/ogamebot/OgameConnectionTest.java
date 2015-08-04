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
        String universe="";
        OgameConnection connection = new OgameConnection();
        connection.login(serverUrl, username, password, universe);
        //Assert.assertNotNull(connection);
        connection.close();
    }

    @Test(expected = org.openqa.selenium.NoSuchElementException.class)
    public void testlogin_wrongurl() throws Exception {
        String serverUrl="";
        String username="";
        String password="";
        String universe="";
        OgameConnection connection = new OgameConnection();
        try{
            connection.login(serverUrl, username, password, universe);
        }catch(org.openqa.selenium.NoSuchElementException e){
            connection.close();
            throw e;
        }
        //Assert.assertNotNull(connection);
        connection.close();
    }

    @Test
    public void testlogin_correct(){
        String username="cocorito";
        String password="cocorito";
        String url="en.ogame.gameforge.com";
        String universe="Ganimed";

        OgameConnection connection = new OgameConnection();
        connection.login(url, username, password,universe);
        connection.close();
    }
    //@Test
    //TODO:test the open properties functionality
    public void testopenProperties(){
      //  OgameConnection connection = new OgameConnection();

       // connection.login(
    }


}
