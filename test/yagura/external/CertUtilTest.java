/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yagura.external;

import java.io.File;
import java.security.Key;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author t.isayama
 */
public class CertUtilTest {
    
    public CertUtilTest() {
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

//    /**
//     * Test of loadFromKeyPKCS12 method, of class CertUtil.
//     */
//    @Test
//    public void testLoadFromKeyPKCS12() throws Exception {
//        System.out.println("loadFromKeyPKCS12");
//        File storeFile = null;
//        String password = "";
//        HashMap<String, CertificateInKey> expResult = null;
//        HashMap<String, CertificateInKey> result = CertUtil.loadFromKeyPKCS12(storeFile, password);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of loadFromKeyJKS method, of class CertUtil.
//     */
//    @Test
//    public void testLoadFromKeyJKS() throws Exception {
//        System.out.println("loadFromKeyJKS");
//        File storeFile = null;
//        String password = "";
//        HashMap<String, CertificateInKey> expResult = null;
//        HashMap<String, CertificateInKey> result = CertUtil.loadFromKeyJKS(storeFile, password);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of loadFromKeyStore method, of class CertUtil.
//     */
//    @Test
//    public void testLoadFromKeyStore() throws Exception {
//        System.out.println("loadFromKeyStore");
//        File storeFile = null;
//        String keyPassword = "";
//        String storeType = "";
//        HashMap<String, CertificateInKey> expResult = null;
//        HashMap<String, CertificateInKey> result = CertUtil.loadFromKeyStore(storeFile, keyPassword, storeType);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of exportToPem method, of class CertUtil.
     */
    @Test
    public void testExportToPem_Key_X509Certificate_JKS() throws Exception {
        System.out.println("exportToPem JKS");
        File storeFile = new File("C:\\temp\\server.keystore");
        HashMap<String, CertificateInKey> certMap = CertUtil.loadFromJKS(storeFile, "testtest");
        for (String ailias : certMap.keySet()) {
            CertificateInKey cert = certMap.get(ailias);
            String result = CertUtil.exportToPem(cert.getPrivateKey(), cert.getX509Certificate());
            System.out.println(result);
        }
    }

    /**
     * Test of exportToPem method, of class CertUtil.
     */
    @Test
    public void testExportToPem_Key_X509Certificate_PKCS12() throws Exception {
        System.out.println("exportToPem PKCS12");
        File storeFile = new File("C:\\temp\\burp_custom.p12");
        HashMap<String, CertificateInKey> certMap = CertUtil.loadFromPKCS12(storeFile, "testca");
        for (String ailias : certMap.keySet()) {
            System.out.println("ailias:" + ailias);
            CertificateInKey cert = certMap.get(ailias);
            String result = CertUtil.exportToPem(cert.getPrivateKey(), cert.getX509Certificate());
            System.out.println(result);
        }
    }
    
//    /**
//     * Test of exportToPem method, of class CertUtil.
//     */
//    @Test
//    public void testExportToPem_Key() throws Exception {
//        System.out.println("exportToPem");
//        Key privateKey = null;
//        String expResult = "";
//        String result = CertUtil.exportToPem(privateKey);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of exportToPem method, of class CertUtil.
//     */
//    @Test
//    public void testExportToPem_X509Certificate() throws Exception {
//        System.out.println("exportToPem");
//        X509Certificate x509cert = null;
//        String expResult = "";
//        String result = CertUtil.exportToPem(x509cert);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of exportToDer method, of class CertUtil.
//     */
//    @Test
//    public void testExportToDer_Key() throws Exception {
//        System.out.println("exportToDer");
//        Key privateKey = null;
//        String expResult = "";
//        String result = CertUtil.exportToDer(privateKey);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of exportToDer method, of class CertUtil.
//     */
//    @Test
//    public void testExportToDer_X509Certificate() throws Exception {
//        System.out.println("exportToDer");
//        X509Certificate x509cert = null;
//        String expResult = "";
//        String result = CertUtil.exportToDer(x509cert);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
