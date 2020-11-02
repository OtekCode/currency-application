package pl.otekcode.app.metrics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface MetricRepository extends JpaRepository<MetricEntity,Long> {

    List<MetricEntity> findAllByType(MetricServiceType type);
}
