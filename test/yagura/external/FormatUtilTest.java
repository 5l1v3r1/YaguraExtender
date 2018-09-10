/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yagura.external;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author isayan
 */
public class FormatUtilTest {
    
    public FormatUtilTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isURL method, of class FormatUtil.
     */
    @Test
    public void testIsURL_http() {
        System.out.println("isURL");
        String plainURL = "http://example.com/";
        boolean expResult = true;
        boolean result = FormatUtil.isURL(plainURL);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsURL_https() {
        System.out.println("isURL");
        String plainURL = "https://example.com/";
        boolean expResult = true;
        boolean result = FormatUtil.isURL(plainURL);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsURL_file() {
        System.out.println("isURL");
        String plainURL = "file://example.com/";
        boolean expResult = false;
        boolean result = FormatUtil.isURL(plainURL);
        assertEquals(expResult, result);
    }

    
    /**
     * Test of isXML method, of class FormatUtil.
     */
    @Test
    public void testIsXML() {
        System.out.println("isXML");
        String plainXML = "<root><a/><x>z</x></root>";
        boolean expResult = true;
        boolean result = FormatUtil.isXML(plainXML);
        assertEquals(expResult, result);
    }

    /**
     * Test of isJSON method, of class FormatUtil.
     */
    @Test
    public void testIsJSON() {
        System.out.println("isJSON1");
        {
            String plainJson = "[1,true,\"word\"]";
            boolean expResult = true;
            boolean result = FormatUtil.isJSON(plainJson);
            assertEquals(expResult, result);        
        }

        System.out.println("isJSON2");
        {
            String plainJson = "{\"key\":\"value\"}";
            boolean expResult = true;
            boolean result = FormatUtil.isJSON(plainJson);
            assertEquals(expResult, result);        
        }

        System.out.println("isJSON3");
        {
            String plainJson = "\r\n\t[1,true,\"word\"]\r\n\t";
            boolean expResult = true;
            boolean result = FormatUtil.isJSON(plainJson);
            assertEquals(expResult, result);        
        }
        
        System.out.println("isJSON4");
        {
            String plainJson = "\r\n\t{\"key\":\"value\"}\t\r\n";
            boolean expResult = true;
            boolean result = FormatUtil.isJSON(plainJson);
            assertEquals(expResult, result);        
        }

    }

    /**
     * Test of prettyJSON method, of class FormatUtil.
     */
    @Test
    public void testPrettyJSON() throws Exception {
        System.out.println("prettyJSON");
        String plainJson = "[1,true,\"word\"]";
        String expResult = "[\n    1,\n    true,\n    \"word\"\n]";
        String result = FormatUtil.prettyJSON(plainJson);
        assertEquals(expResult, result);
    }
    
}