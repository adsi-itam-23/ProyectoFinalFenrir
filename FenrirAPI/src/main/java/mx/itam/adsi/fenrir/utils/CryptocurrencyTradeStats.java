/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itam.adsi.fenrir.utils;

import mx.itam.adsi.fenrir.models.TradeInfo;
import java.util.List;
import java.util.logging.Logger;
import mx.itam.adsi.fenrir.fenrirapi.CryptoController;

/**
 * Class used to calculate statistics from cryptocurrencies tradings
 * @author Pablo
 */
public class CryptocurrencyTradeStats {
    
    private final static Logger LOG = Logger.getLogger(CryptocurrencyTradeStats.class.getName());
    /**
     * Returns the average number of traded coins for a given List of trades
     * @param trades List containig the trades
     * @return the average trade volume (0 if list is empty)
     */
    public static double averageTradeVolume(List<TradeInfo> trades){
        LOG.info("Computing average volume for "+ trades.size() + " trades");
        double average = 0.0d;
        for(TradeInfo trade : trades){
            //LOG.info("trade: " + trade.getQty());
            average += Double.parseDouble(trade.getQty());
        }        
        //avoid returning NaN
        if(trades.size()>0){
            average/=trades.size();
        }
        return average;
    }
    
    /**
     * Returns the average unit price of a coin given a list of trades
     * @param trades the list of trades to analize
     * @return the average unit price (0 if list is empty)
     */
    public static double averageUnitPrice(List<TradeInfo> trades){
        LOG.info("Computing average unit price for "+ trades.size() + " trades");
        double average = 0.0d;
        for(TradeInfo trade : trades){
            average += (Double.parseDouble(trade.getPrice())/Double.parseDouble(trade.getQty()));
        }
        //avoid returning NaN
        if(trades.size()>0){
            average/=trades.size();
        }
        return average;
    }
    
    /**
     * Returns how many of the traders actually mined the coin in the given list
     * @param trades the list of trades to analize
     * @return number of miners that traded their mined coins
     */
    public static int numberOfTradersThatAreMakers(List<TradeInfo> trades){
        LOG.info("Computing number of makers for "+ trades.size() + " trades");
        
        int count = 0;
        
        for(TradeInfo trade : trades){
            if(trade.getIsBuyerMaker())
                count++;
        }
        
        return count;
    }
    
}
