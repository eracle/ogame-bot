package it.eracle.ogamebot;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.net.URL;

/**
 * Unit test for simple App.
 */
public class LoginTest
    extends TestCase
{
    public void testlogin() throws Exception {
        String serverUrl="";
        String username="";
        String password="";
        OgameConnection connection = Login.login(serverUrl, username, password);
        Assert.assertNull(connection);
    }



}
