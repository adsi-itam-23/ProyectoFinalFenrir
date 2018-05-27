package mx.itam.adsi.fenrir.fenrirapi;

import java.util.LinkedList;
import mx.itam.adsi.fenrir.utils.BinanceAPIHelper;
import mx.itam.adsi.fenrir.models.BinanceCoinInfo;
import java.util.List;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import mx.itam.adsi.fenrir.models.CoinStat;
import mx.itam.adsi.fenrir.models.Coins;
import mx.itam.adsi.fenrir.models.TradeInfo;
import mx.itam.adsi.fenrir.utils.CryptocurrencyTradeStats;

/**
 *
 * @author Pablo
 */
@Path("crypto")
public class CryptoController {

    private final static Logger LOG = Logger.getLogger(CryptoController.class.getName());
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BinanceCoinInfo> getIt() {
        BinanceAPIHelper helper = new BinanceAPIHelper();
        List<BinanceCoinInfo> response = helper.getCoinData();
        LOG.info("List acquired, sending response");
        return response;
    }
    
}
