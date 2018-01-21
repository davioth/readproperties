package com.davioth.readproperties.noSpringBean;

import com.davioth.readproperties.config.AppConfigProperties;
import com.davioth.readproperties.config.SpringContextConfigBridgeImpl;

public class ClaseNoSpring {

    public String getPropertie() {
        return SpringContextConfigBridgeImpl.config()
                .getConfigProperties(AppConfigProperties.class).getPruebaConcepto();
    }
}
