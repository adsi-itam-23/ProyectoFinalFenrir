/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itam.adsi.fenrir.models;

/**
 * Enum containing the supported currencies, the ones that binance API
 * have the value in US Dollars
 * @author Pablo
 */
public enum Coins {
    BITCOIN("BTCUSDT","Bitcoin"), 
    ETHEREUM("ETHUSDT","Ethereum"), 
    BITCOIN_CASH("BCCUSDT","Bitcoin cash"),
    RIPPLE("XRPUSDT","Ripple"),
    CARDANO("ADAUSDT","Cardano"),
    BINANCE_COIN("BNBUSDT","Binance coin"),
    LITECOIN ("LTCUSDT","Litecoin"),
    NEO("NEOUSDT","Neo"),
    QTUM("QTUMUSDT","Qtm");
    
    private String binanceSymbol;
    private String coinName;
    
    Coins(String binanceSymbol, String nam) {
        this.binanceSymbol = binanceSymbol;
        this.coinName = nam;
    }

    public String binanceSymbol() {
        return binanceSymbol;
    }
    
    public String coinName() {
        return coinName;
    }
}
