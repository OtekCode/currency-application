package pl.otekcode.app.metrics;

import java.util.Collection;

public interface MetricService {

    void saveMetric(String endpoint,String webMethod,String clazz, String methodName, MetricServiceType type);

    Collection<MetricEntity> getMetrics();

    Collection<MetricEntity> getLocallyMetrics();

    Collection<MetricEntity> getRemoteMetrics();
}
