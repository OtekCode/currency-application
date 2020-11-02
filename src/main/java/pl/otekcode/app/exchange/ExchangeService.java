package pl.otekcode.app.exchange;

public interface ExchangeService {

    ExchangeResult exchange(String from, String to, double money);
}
