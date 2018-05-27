/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itam.adsi.fenrir.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import mx.itam.adsi.fenrir.utils.CryptocurrencyTradeStats;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * POJO representing a cryptocurrency transaction 
 * @author Pablo
 */
public class TradeInfo {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("qty")
    @Expose
    private String qty;
    @SerializedName("time")
    @Expose
    private Integer time;
    @SerializedName("isBuyerMaker")
    @Expose
    private Boolean isBuyerMaker;
    @SerializedName("isBestMatch")
    @Expose
    private Boolean isBestMatch;

    public TradeInfo(String price, String qty, Boolean isBuyerMaker) {
        this.price = price;
        this.qty = qty;
        this.isBuyerMaker = isBuyerMaker;
    }

    public TradeInfo() {
    }
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TradeInfo withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public TradeInfo withPrice(String price) {
        this.price = price;
        return this;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public TradeInfo withQty(String qty) {
        this.qty = qty;
        return this;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public TradeInfo withTime(Integer time) {
        this.time = time;
        return this;
    }

    public Boolean getIsBuyerMaker() {
        return isBuyerMaker;
    }

    public void setIsBuyerMaker(Boolean isBuyerMaker) {
        this.isBuyerMaker = isBuyerMaker;
    }

    public TradeInfo withIsBuyerMaker(Boolean isBuyerMaker) {
        this.isBuyerMaker = isBuyerMaker;
        return this;
    }

    public Boolean getIsBestMatch() {
        return isBestMatch;
    }

    public void setIsBestMatch(Boolean isBestMatch) {
        this.isBestMatch = isBestMatch;
    }

    public TradeInfo withIsBestMatch(Boolean isBestMatch) {
        this.isBestMatch = isBestMatch;
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(time).append(price).append(qty).append(isBestMatch).append(isBuyerMaker).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CryptocurrencyTradeStats) == false) {
            return false;
        }
        TradeInfo rhs = ((TradeInfo) other);
        return new EqualsBuilder().append(id, rhs.id).append(time, rhs.time).append(price, rhs.price).append(qty, rhs.qty).append(isBestMatch, rhs.isBestMatch).append(isBuyerMaker, rhs.isBuyerMaker).isEquals();
    }

}
