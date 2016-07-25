package Entity;

/**
 * User: gam
 * Date: 14.12.13
 * Time: 23:15
 */
public class ExchangeRateEntity {
    private String bankName;
    private String bid;
    private String ask;

    public ExchangeRateEntity() {
    }

    public ExchangeRateEntity(String bankName, String ask, String bid) {
        this.bankName = bankName;
        this.bid = bid;
        this.ask = ask;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public boolean equals(Object obj)
    {
        if(obj == this)
            return true;
        if(obj == null)
            return false;
        if(!(getClass() == obj.getClass()))
            return false;
        else
        {
            ExchangeRateEntity tmp = (ExchangeRateEntity)obj;
            if(tmp.getBankName() == this.getBankName())
                return true;
            else
                return false;
        }
    }
}
