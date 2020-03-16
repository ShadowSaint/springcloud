package com.owlyowl.myribbon;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRibbonRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();
//        return new RoundRobinRule();
//        return new RetryRule();
//        return new WeightedResponseTimeRule();
//        return new BestAvailableRule();
//        return new AvailabilityFilteringRule();
//        return new ZoneAvoidanceRule();
    }
}
