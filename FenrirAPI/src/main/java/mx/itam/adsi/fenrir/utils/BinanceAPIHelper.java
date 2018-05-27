package mx.itam.adsi.fenrir.utils;

import mx.itam.adsi.fenrir.models.Coins;
import mx.itam.adsi.fenrir.models.BinanceCoinInfo;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import mx.itam.adsi.fenrir.models.TradeInfo;

/**
 * Class made to bind Binance API query operations for easy consumption
 * @author Pablo
 */
public class BinanceAPIHelper {
    
    private final static Logger LOG = Logger.getLogger(BinanceAPIHelper.class.getName());
    private Client client;
    private WebTarget target;
    //BITCOIN, ETHEREUM, BITCOIN CASH, RIPPLE, CARDANO, BINANCE COIN, LITECOIN, NEO, QTUM
    private String[] supportedCoins = {"BTC","ETH","BCC","XRP","ADA","BNB","LTC","NEO","QTUM"};
    
    /** Constructor for the BinanceAPIHelper, sets up the Client to query the API 
    */
    public  BinanceAPIHelper(){
        client = ClientBuilder.newClient();
    }
    
    /** Returns a list of BinanceAPI queried crypto coins price in USD
    * @return   the list of BinanceCoinInfo of all coins given in USD 
    */
    public List<BinanceCoinInfo> getCoinData() {
        LOG.info("Querying Binance API to get Coins values in USD");
        
        target = client.target("https://api.binance.com/api/v1/ticker/24hr"); 
        List<BinanceCoinInfo> coins = new LinkedList<BinanceCoinInfo>();
      
        LOG.info("Num elems:" + Coins.values().length);
        for(Coins coin : Coins.values()){
            LOG.info(coin.binanceSymbol());
            coins.add(target.queryParam("symbol",coin.binanceSymbol()).request(MediaType.APPLICATION_JSON).get(BinanceCoinInfo.class));
        }
        return coins;
        //return target.request(MediaType.APPLICATION_JSON)
        //        .get(new GenericType<List<BinanceCoinInfo>>(){});//.get(BinanceCoinInfo.class);
    }
    
    /** Returns a list of BinanceAPI queried trades from an specific currency
     * @param coin the coin to obtain trades of
    * @return   the list of TradeInfo 
    */
    public List<TradeInfo> getTrades(String coin){
        LOG.info("Querying Binance API to get trades");
        target = client.target("https://api.binance.com/api/v1/trades");        
        return target.queryParam("symbol",coin).request(MediaType.APPLICATION_JSON)
               .get(new GenericType<List<TradeInfo>>(){});
    }
}
