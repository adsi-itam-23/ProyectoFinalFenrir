package mx.itam.adsi.fenrir.fenrirapi;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 * Class made to bind Binance API query operations for easy consumption
 * @author Pablo
 */
public class BinanceAPIHelper {
    
    private Client client;
    private WebTarget target;
    //BITCOIN, ETHEREUM, BITCOIN CASH, RIPPLE, CARDANO, BINANCE COIN, LITECOIN, NEO, QTUM
    private String[] supportedCoins = {"BTC","ETH","BCC","XRP","ADA","BNB","LTC","NEO","QTUM"};
    public  BinanceAPIHelper(){
        client = ClientBuilder.newClient();
    }
    
    /** Returns a list of BinanceAPI queried crypto coins price in USD
    *
    * @return      the list of BinanceCoinInfo of all coins given in USD 
    */
    public List<BinanceCoinInfo> getCoinData() {
        System.out.println("entered nethod");
        target = client.target("https://api.binance.com/api/v1/ticker/24hr");        
        List<BinanceCoinInfo> coins = new LinkedList<BinanceCoinInfo>();
        for(String coin : supportedCoins){
            coins.add(target.queryParam("symbol",coin+"USDT").request(MediaType.APPLICATION_JSON).get(BinanceCoinInfo.class));
        }
        return coins;
        //return target.request(MediaType.APPLICATION_JSON)
        //        .get(new GenericType<List<BinanceCoinInfo>>(){});//.get(BinanceCoinInfo.class);
    }
}
