package com.davioth.readproperties.config;

public interface SpringContextConfigBridge {

    <T> T getConfigProperties(Class<T> beanPropertie);
}
