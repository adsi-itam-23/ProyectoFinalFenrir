package mx.itam.adsi.fenrir.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Pablo
 */
public class CoinStat {
    
    @SerializedName("coinName")
    @Expose
    private String coin;
    @SerializedName("stat")
    @Expose
    private String statName;
    @SerializedName("value")
    @Expose
    private double stat;
    
    public CoinStat() {
        this.coin = "";
        this.statName = "";
        this.stat = 0.0d;
    }
    
    public CoinStat(String coin, String statName, double stat) {
        this.coin = coin;
        this.statName = statName;
        this.stat = stat;
    }
    
    
    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }
    
    public CoinStat withCoin(String coin) {
        this.coin = coin;
        return this;
    }

    public String getStatName() {
        return statName;
    }

    public void setStatName(String statName) {
        this.statName = statName;
    }
    
    public CoinStat withStatName(String statName) {
        this.statName = statName;
        return this;
    }

    public double getStat() {
        return stat;
    }

    public void setStat(double stat) {
        this.stat = stat;
    }
    
    public CoinStat withCoin(double stat) {
        this.stat = stat;
        return this;
    }
    
}
