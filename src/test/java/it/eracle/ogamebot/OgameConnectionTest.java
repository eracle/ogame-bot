package it.eracle.ogamebot;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.net.URL;

/**
 * Unit test for simple App.
 */
public class OgameConnectionTest
    extends TestCase
{
    public void testlogin() throws Exception {
        String serverUrl="http://en.ogame.gameforge.com/";
        String username="";
        String password="";
        OgameConnection connection = new OgameConnection();
        connection.login(serverUrl, username, password);
        Assert.assertNotNull(connection);
    }



}
