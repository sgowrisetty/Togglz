package com.togglz.configuration;

import com.togglz.service.FeatureNew;
import com.togglz.service.FirstFeature;
import com.togglz.service.SecondFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.togglz.spring.proxy.FeatureProxyFactoryBean;

@Configuration
public class FeatureConfiguration {

    @Bean
    public FeatureNew getFirstFeature() {
        return new FirstFeature();
    }

    @Bean
    public FeatureNew getSecondFeature() {
        return new SecondFeature();
    }

    //This method is for Feature Toggling between the First Feature and the Second Feature
    @Bean
    public FeatureProxyFactoryBean setActiveFeature() {
        FeatureProxyFactoryBean proxyFactoryBean = new FeatureProxyFactoryBean();
        proxyFactoryBean.setFeature(FeatureTogglz.USE_FEATURE.name());
        proxyFactoryBean.setProxyType(FeatureNew.class);
        proxyFactoryBean.setActive(this.getSecondFeature());
        proxyFactoryBean.setInactive(this.getFirstFeature());
        return proxyFactoryBean;
    }

    @Bean
    @Primary
    public FeatureNew getFeature(@Autowired FeatureProxyFactoryBean proxiedSomeService) throws Exception {
        return (FeatureNew) proxiedSomeService.getObject();
    }

}
