package com.davioth.readproperties.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextConfigBridgeImpl implements SpringContextConfigBridge, ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public <T> T getConfigProperties(Class<T> beanPropertie) {
        return applicationContext.getBean(beanPropertie);
    }


    public static SpringContextConfigBridge config() {
        return applicationContext.getBean(SpringContextConfigBridge.class);
    }
}
