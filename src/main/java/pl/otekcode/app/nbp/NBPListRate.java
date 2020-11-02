package pl.otekcode.app.nbp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.otekcode.app.currency.CurrencyInput;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class NBPListRate implements CurrencyInput {
    @JsonProperty("currency")
    private String name;
    private String code;
    private double ask,bid;
}
