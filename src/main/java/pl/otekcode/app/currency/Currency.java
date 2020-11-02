package pl.otekcode.app.currency;


import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class Currency {
    private final String name,code;
    private final double ask,bid;
}
