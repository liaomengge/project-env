package com.sh.lmg.util;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.Properties;

/**
 * Created by liaomengge on 16/4/21.
 */
public final class PropertiesUtil {

    private PropertiesUtil() {
    }

    private static Properties prop = null;

    static {
        try {
            Resource resource = new ClassPathResource("config/env_config.properties");
            EncodedResource encodedResource = new EncodedResource(resource, Charset.defaultCharset());
            prop = PropertiesLoaderUtils.loadProperties(encodedResource);
        } catch (IOException e) {
            throw new IllegalArgumentException("load properties failed", e);
        }
    }

    @SuppressWarnings("all")
    public static String getStringProperty(String key, String... params) {
        if (StringUtils.isBlank(key)) {
            return StringUtils.EMPTY;
        }
        Object[] objs = params;
        return MessageFormat.format(StringUtils.defaultIfBlank(prop.getProperty(key), StringUtils.EMPTY), objs);
    }

    public static String getStringProperty(String key) {
        if (StringUtils.isBlank(key)) {
            return StringUtils.EMPTY;
        }
        return StringUtils.defaultIfBlank(prop.getProperty(key), StringUtils.EMPTY);
    }

    public static Integer getIntProperty(String key) {
        if (StringUtils.isEmpty(key)) {
            return NumberUtils.INTEGER_MINUS_ONE;
        }
        return NumberUtils.toInt(prop.getProperty(key), NumberUtils.INTEGER_MINUS_ONE);
    }

    public static Boolean getBooleanProperty(String key) {
        if (StringUtils.isBlank(key)) {
            return Boolean.FALSE;
        }
        return BooleanUtils.toBoolean(prop.getProperty(key));
    }
}
