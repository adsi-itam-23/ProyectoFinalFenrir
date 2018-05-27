/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itam.adsi.fenrir.fenrirapi;

import java.util.LinkedList;
import java.util.List;
import mx.itam.adsi.fenrir.models.TradeInfo;
import mx.itam.adsi.fenrir.utils.CryptocurrencyTradeStats;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pablo
 */
public class CyrptocurrencyTradeStatsTest {
    
    private LinkedList<TradeInfo> lista ;
    private LinkedList<TradeInfo> lista2 ;
    
    public CyrptocurrencyTradeStatsTest() {
        lista = new LinkedList<TradeInfo>();
        lista2 = new LinkedList<TradeInfo>();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        lista.add(new TradeInfo("1", "1", Boolean.TRUE));
        lista.add(new TradeInfo("1", "1", Boolean.TRUE));
        lista.add(new TradeInfo("1", "1", Boolean.TRUE));
        lista.add(new TradeInfo("1", "1", Boolean.FALSE));
        lista2.add(new TradeInfo("1", "2", Boolean.FALSE));
        lista2.add(new TradeInfo("5", "5", Boolean.FALSE));
        lista2.add(new TradeInfo("2", "2", Boolean.FALSE));
        lista2.add(new TradeInfo("2", "1", Boolean.FALSE));
    }
    
    @After
    public void tearDown() {
        lista.clear();
        lista2.clear();
    }
    
    @Test
    public void testVolumen() {    
        assertEquals(0, CryptocurrencyTradeStats.averageTradeVolume(new LinkedList<TradeInfo>()),0.000001);
        assertEquals(1, CryptocurrencyTradeStats.averageTradeVolume(lista),0.000001);
        assertEquals(2.5, CryptocurrencyTradeStats.averageTradeVolume(lista2),0.000001);
    } 
    
    @Test
    public void testPrecio() {            
        assertEquals(0, CryptocurrencyTradeStats.averageUnitPrice(new LinkedList<TradeInfo>()),0.000001);
        assertEquals(1, CryptocurrencyTradeStats.averageUnitPrice(lista),0.000001);
        assertEquals(1.125, CryptocurrencyTradeStats.averageUnitPrice(lista2),0.000001);
    } 
    
    @Test
    public void testMakers() {    
        assertEquals(3, CryptocurrencyTradeStats.numberOfTradersThatAreMakers(lista));
        assertEquals(0, CryptocurrencyTradeStats.numberOfTradersThatAreMakers(lista2));
    } 
}
