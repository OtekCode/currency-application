package pl.otekcode.app.nbp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NBPListCurrencies {
    private Character table;
    private String no;
    private Date tradingDate, effectiveDate;
    private Collection<NBPListRate> rates;
}
