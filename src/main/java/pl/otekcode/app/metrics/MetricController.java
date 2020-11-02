package pl.otekcode.app.metrics;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/metrics")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(value = "Metrics API")
public class MetricController {
    private final MetricService metricService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<MetricEntity>> getMetrics(){
        return ResponseEntity.ok(metricService.getMetrics());
    }

    @RequestMapping(method = RequestMethod.GET,value = "/locally")
    public ResponseEntity<Collection<MetricEntity>> getLocalMetrics(){
        return ResponseEntity.ok(metricService.getLocallyMetrics());
    }

    @RequestMapping(method = RequestMethod.GET,value = "/remote")
    public ResponseEntity<Collection<MetricEntity>> getRemoteMetrics(){
        return ResponseEntity.ok(metricService.getRemoteMetrics());
    }
}
