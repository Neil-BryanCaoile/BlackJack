/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackgameconsole;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kiet
 */
public class DeckTest {
    
    public DeckTest() {
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
     * Test of toString method, of class Deck.
     */
    @Test
    public void testToStringGood() {
        System.out.println("toString Good case");
        Deck instance = new Deck();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testToStringBad() {
        System.out.println("toString Bad Case");
        Deck instance = new Deck();
        String expResult = "randomString";
        String result = instance.toString();
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testToStringBoundary() {
        System.out.println("toString Boundary case");
        Deck instance = new Deck();
        String expResult = "[]";
        String result = instance.toString();
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
             
    /**
     * Test of deckSize method, of class Deck.
     */
    @Test
    public void testDeckSizeGood() {
        System.out.println("deckSize Good case");
        Deck instance = new Deck();
        int expResult = 0;
        int result = instance.deckSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testDeckSizeBad() {
        System.out.println("deckSize Bad case");
        Deck instance = new Deck();
        int expResult = -9;
        int result = instance.deckSize();
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testDeckSizeBoundary() {
        System.out.println("deckSize Boundary case");
        Deck instance = new Deck();
        int expResult = 32;
        int result = instance.deckSize();
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of cardsValue method, of class Deck.
     */
    @Test
    public void testCardsValueGood() {
        System.out.println("cardsValue Good case");
        Deck instance = new Deck();
        int expResult = 0;
        int result = instance.cardsValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testCardsValueBad() {
        System.out.println("cardsValue bad case");
        Deck instance = new Deck();
        int expResult = -7;
        int result = instance.cardsValue();
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testCardsValueBoundary() {
        System.out.println("cardsValue Boundary case");
        Deck instance = new Deck();
        int expResult = 56;
        int result = instance.cardsValue();
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    } 
       
}
