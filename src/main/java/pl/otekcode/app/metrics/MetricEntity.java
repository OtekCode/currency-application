package pl.otekcode.app.metrics;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "metrics")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MetricEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "endpoint")
    private String endpoint;

    @Column(name = "web_method")
    private String webMethod;

    @Column(name = "clazz")
    private String clazz;

    @Column(name = "method")
    private String method;

    @Column(name = "type")
    @Enumerated
    private MetricServiceType type;

    @Column(name = "date")
    private Date date;
}
