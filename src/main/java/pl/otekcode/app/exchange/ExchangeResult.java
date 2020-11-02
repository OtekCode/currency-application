package pl.otekcode.app.exchange;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import pl.otekcode.app.currency.Currency;

@Data
@RequiredArgsConstructor
@Builder
public class ExchangeResult {
    private final Currency from;
    private final Currency to;
    private final double result;
}
