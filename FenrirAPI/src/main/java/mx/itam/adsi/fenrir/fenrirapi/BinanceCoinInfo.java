/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itam.adsi.fenrir.fenrirapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * POJO used to model the Binance API response
 *
 * @author Pablo
 */

public class BinanceCoinInfo {

    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("priceChange")
    @Expose
    private String priceChange;
    @SerializedName("priceChangePercent")
    @Expose
    private String priceChangePercent;
    @SerializedName("weightedAvgPrice")
    @Expose
    private String weightedAvgPrice;
    @SerializedName("prevClosePrice")
    @Expose
    private String prevClosePrice;
    @SerializedName("lastPrice")
    @Expose
    private String lastPrice;
    @SerializedName("lastQty")
    @Expose
    private String lastQty;
    @SerializedName("bidPrice")
    @Expose
    private String bidPrice;
    @SerializedName("askPrice")
    @Expose
    private String askPrice;
    @SerializedName("openPrice")
    @Expose
    private String openPrice;
    @SerializedName("highPrice")
    @Expose
    private String highPrice;
    @SerializedName("lowPrice")
    @Expose
    private String lowPrice;
    @SerializedName("volume")
    @Expose
    private String volume;
    @SerializedName("quoteVolume")
    @Expose
    private String quoteVolume;
    @SerializedName("openTime")
    @Expose
    private Integer openTime;
    @SerializedName("closeTime")
    @Expose
    private Integer closeTime;
    @SerializedName("fristId")
    @Expose
    private Integer fristId;
    @SerializedName("lastId")
    @Expose
    private Integer lastId;
    @SerializedName("count")
    @Expose
    private Integer count;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BinanceCoinInfo withSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public String getPriceChange() {
        return priceChange;
    }

    public void setPriceChange(String priceChange) {
        this.priceChange = priceChange;
    }

    public BinanceCoinInfo withPriceChange(String priceChange) {
        this.priceChange = priceChange;
        return this;
    }

    public String getPriceChangePercent() {
        return priceChangePercent;
    }

    public void setPriceChangePercent(String priceChangePercent) {
        this.priceChangePercent = priceChangePercent;
    }

    public BinanceCoinInfo withPriceChangePercent(String priceChangePercent) {
        this.priceChangePercent = priceChangePercent;
        return this;
    }

    public String getWeightedAvgPrice() {
        return weightedAvgPrice;
    }

    public void setWeightedAvgPrice(String weightedAvgPrice) {
        this.weightedAvgPrice = weightedAvgPrice;
    }

    public BinanceCoinInfo withWeightedAvgPrice(String weightedAvgPrice) {
        this.weightedAvgPrice = weightedAvgPrice;
        return this;
    }

    public String getPrevClosePrice() {
        return prevClosePrice;
    }

    public void setPrevClosePrice(String prevClosePrice) {
        this.prevClosePrice = prevClosePrice;
    }

    public BinanceCoinInfo withPrevClosePrice(String prevClosePrice) {
        this.prevClosePrice = prevClosePrice;
        return this;
    }

    public String getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }

    public BinanceCoinInfo withLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
        return this;
    }

    public String getLastQty() {
        return lastQty;
    }

    public void setLastQty(String lastQty) {
        this.lastQty = lastQty;
    }

    public BinanceCoinInfo withLastQty(String lastQty) {
        this.lastQty = lastQty;
        return this;
    }

    public String getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(String bidPrice) {
        this.bidPrice = bidPrice;
    }

    public BinanceCoinInfo withBidPrice(String bidPrice) {
        this.bidPrice = bidPrice;
        return this;
    }

    public String getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(String askPrice) {
        this.askPrice = askPrice;
    }

    public BinanceCoinInfo withAskPrice(String askPrice) {
        this.askPrice = askPrice;
        return this;
    }

    public String getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(String openPrice) {
        this.openPrice = openPrice;
    }

    public BinanceCoinInfo withOpenPrice(String openPrice) {
        this.openPrice = openPrice;
        return this;
    }

    public String getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(String highPrice) {
        this.highPrice = highPrice;
    }

    public BinanceCoinInfo withHighPrice(String highPrice) {
        this.highPrice = highPrice;
        return this;
    }

    public String getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(String lowPrice) {
        this.lowPrice = lowPrice;
    }

    public BinanceCoinInfo withLowPrice(String lowPrice) {
        this.lowPrice = lowPrice;
        return this;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public BinanceCoinInfo withVolume(String volume) {
        this.volume = volume;
        return this;
    }

    public String getQuoteVolume() {
        return quoteVolume;
    }

    public void setQuoteVolume(String quoteVolume) {
        this.quoteVolume = quoteVolume;
    }

    public BinanceCoinInfo withQuoteVolume(String quoteVolume) {
        this.quoteVolume = quoteVolume;
        return this;
    }

    public Integer getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Integer openTime) {
        this.openTime = openTime;
    }

    public BinanceCoinInfo withOpenTime(Integer openTime) {
        this.openTime = openTime;
        return this;
    }

    public Integer getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Integer closeTime) {
        this.closeTime = closeTime;
    }

    public BinanceCoinInfo withCloseTime(Integer closeTime) {
        this.closeTime = closeTime;
        return this;
    }

    public Integer getFristId() {
        return fristId;
    }

    public void setFristId(Integer fristId) {
        this.fristId = fristId;
    }

    public BinanceCoinInfo withFristId(Integer fristId) {
        this.fristId = fristId;
        return this;
    }

    public Integer getLastId() {
        return lastId;
    }

    public void setLastId(Integer lastId) {
        this.lastId = lastId;
    }

    public BinanceCoinInfo withLastId(Integer lastId) {
        this.lastId = lastId;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BinanceCoinInfo withCount(Integer count) {
        this.count = count;
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(lastQty).append(count).append(fristId).append(symbol).append(lastPrice).append(prevClosePrice).append(openTime).append(openPrice).append(quoteVolume).append(weightedAvgPrice).append(priceChange).append(lowPrice).append(bidPrice).append(closeTime).append(priceChangePercent).append(lastId).append(volume).append(highPrice).append(askPrice).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BinanceCoinInfo) == false) {
            return false;
        }
        BinanceCoinInfo rhs = ((BinanceCoinInfo) other);
        return new EqualsBuilder().append(lastQty, rhs.lastQty).append(count, rhs.count).append(fristId, rhs.fristId).append(symbol, rhs.symbol).append(lastPrice, rhs.lastPrice).append(prevClosePrice, rhs.prevClosePrice).append(openTime, rhs.openTime).append(openPrice, rhs.openPrice).append(quoteVolume, rhs.quoteVolume).append(weightedAvgPrice, rhs.weightedAvgPrice).append(priceChange, rhs.priceChange).append(lowPrice, rhs.lowPrice).append(bidPrice, rhs.bidPrice).append(closeTime, rhs.closeTime).append(priceChangePercent, rhs.priceChangePercent).append(lastId, rhs.lastId).append(volume, rhs.volume).append(highPrice, rhs.highPrice).append(askPrice, rhs.askPrice).isEquals();
    }

}
