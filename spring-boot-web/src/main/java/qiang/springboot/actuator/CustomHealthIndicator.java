package qiang.springboot.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        double random = Math.random();
        if (random > 0.5) {
            return Health.status(Consts.FAIL).withDetail("error code", "XXX检查失败").build();
        } else {
            return Health.up().withDetail("success code", "自定义项XXX检查成果").build();


        }
    }

}
