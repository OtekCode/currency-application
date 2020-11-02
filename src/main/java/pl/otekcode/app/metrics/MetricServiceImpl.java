package pl.otekcode.app.metrics;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.Instant;
import java.util.Collection;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MetricServiceImpl implements MetricService{
    private final MetricRepository repository;

    @Override
    @Transactional
    public void saveMetric(String endpoint, String webMethod, String clazz, String methodName, MetricServiceType type) {
        final MetricEntity entity = MetricEntity.builder()
                .clazz(clazz)
                .endpoint(endpoint)
                .webMethod(webMethod)
                .method(methodName)
                .type(type)
                .date(Date.from(Instant.now()))
                .build();
        repository.save(entity);
    }

    @Override
    public Collection<MetricEntity> getMetrics() {
        return repository.findAll();
    }

    @Override
    public Collection<MetricEntity> getLocallyMetrics() {
        return repository.findAllByType(MetricServiceType.LOCAL);
    }

    @Override
    public Collection<MetricEntity> getRemoteMetrics() {
        return repository.findAllByType(MetricServiceType.EXTERNAL);
    }
}
