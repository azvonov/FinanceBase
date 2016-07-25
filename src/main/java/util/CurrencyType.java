package util;

/**
 * Created with IntelliJ IDEA.
 * User: gam
 * Date: 10.12.13
 * Time: 1:43
 * To change this template use File | Settings | File Templates.
 */
public enum CurrencyType {

    EUR("EUR"),
    RUB("RUB");

    private String text;

    private CurrencyType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
