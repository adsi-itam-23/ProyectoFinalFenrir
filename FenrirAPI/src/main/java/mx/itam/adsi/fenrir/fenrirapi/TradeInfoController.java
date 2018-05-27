/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itam.adsi.fenrir.fenrirapi;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import mx.itam.adsi.fenrir.models.BinanceCoinInfo;
import mx.itam.adsi.fenrir.models.CoinStat;
import mx.itam.adsi.fenrir.models.Coins;
import mx.itam.adsi.fenrir.models.TradeInfo;
import mx.itam.adsi.fenrir.utils.BinanceAPIHelper;
import mx.itam.adsi.fenrir.utils.CryptocurrencyTradeStats;

/**
 *
 * @author Pablo
 */
@Path("tradeStats")
public class TradeInfoController {

    private final static Logger LOG = Logger.getLogger(CryptoController.class.getName());
    /**
     * Method handling HTTP GET requests. Returns the coint specified stat for
     * all of the handled coins     *
     * @return A list containing the stat of interest.
     */
    @GET
    @Path("/{stat}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CoinStat> getIt(@PathParam("stat") String statName) {
        
        List<CoinStat> response = new LinkedList<CoinStat>();
        
        if(statName.equals("makers")){
            fillMakersStatList(response);
        }else if(statName.equals("volume")){
            fillVolumeStatList(response);
        }else if(statName.equals("unitprice")){
            fillUnitPriceStatList(response);
        }
        
        return response;
    }
    
    @GET
    @Path("/alltrades")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TradeInfo> getIt() {
 
        BinanceAPIHelper helper = new BinanceAPIHelper();
        
        return helper.getTrades(Coins.BITCOIN.binanceSymbol());
    }
    
    /**
     * Method to generate the list of average volume per trade of supported coins
     * 
     */
    private void fillVolumeStatList(List<CoinStat> stats){
        LOG.info("Volume stat chosen");
        BinanceAPIHelper helper = new BinanceAPIHelper();
        for(Coins coin : Coins.values()){
            List<TradeInfo> trades = helper.getTrades(coin.binanceSymbol());
            LOG.info("No trades: "+trades.size());
            double average = CryptocurrencyTradeStats.averageTradeVolume(trades);
            stats.add(new CoinStat(coin.coinName(),"Average Trade Volume",average));
        }
    }
    
    /**
     * Method to generate the list of average unit price of supported coins
     * 
     */
    private void fillUnitPriceStatList(List<CoinStat> stats){
        LOG.info("Unit price average stat chosen");
        BinanceAPIHelper helper = new BinanceAPIHelper();
        for(Coins coin : Coins.values()){
            double average = CryptocurrencyTradeStats.averageTradeVolume(helper.getTrades(coin.binanceSymbol()));
            stats.add(new CoinStat(coin.coinName(),"Average Unit Price",average));
        }
    }
    
    /**
     * Method to generate the list how many traders are makers of supported coins
     * 
     */
    private void fillMakersStatList(List<CoinStat> stats){
        LOG.info("Traders that are makers stat chosen");
        BinanceAPIHelper helper = new BinanceAPIHelper();
        for(Coins coin : Coins.values()){
            double average = CryptocurrencyTradeStats.averageTradeVolume(helper.getTrades(coin.binanceSymbol()));
            stats.add(new CoinStat(coin.coinName(),"No. of traders that are makers",average));
        }
    }
}
