package pl.otekcode.app.exchange;


import lombok.*;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class ExchangeDto {
    private String from,to;
    private double value;
}
