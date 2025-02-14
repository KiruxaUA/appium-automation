/*
 * Copyright (c) 2017, Wasiq Bhamla.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gridu.qa.appium.utils;

import com.gridu.qa.appium.checker.DeviceChecker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author wasiq.bhamla
 * @since 08-May-2017 7:51:42 PM
 */
public final class CapabilityUtils {
    private static final Logger log = LogManager.getLogger ();

    public static <T> void setCapability (final String key, final T value, final DesiredCapabilities capabilities) {
        setCapability (key, value, null, capabilities);
    }

    /**
     * @param key Capability key
     * @param value Capability value
     * @param defaultValue Capability default value
     * @param capabilities Capabilities
     *
     * @author wasiq.bhamla
     * @since 12-May-2017 9:54:46 PM
     */
    public static <T> void setCapability (final String key, final T value, final T defaultValue,
        final DesiredCapabilities capabilities) {
        setCapability (key, value, defaultValue, capabilities, false);
    }

    /**
     * @param key Capability key
     * @param value Capability value
     * @param defaultValue Capability default value
     * @param capabilities Capabilities
     * @param mandatory Is mandatory
     *
     * @author wasiq.bhamla
     * @since 08-May-2017 7:53:28 PM
     */
    public static <T> void setCapability (final String key, final T value, final T defaultValue,
        final DesiredCapabilities capabilities, final boolean mandatory) {
        if (mandatory) {
            DeviceChecker.checkCapabilitiesParams (key, value);
        }
        if (value != null && value != defaultValue) {
            if (value instanceof Integer && (Integer) value == 0) {
                return;
            }
            log.trace ("Setting capability [key: {}, value: {}]...", key, value);
            capabilities.setCapability (key, value);
        }
    }

    /**
     * @author wasiq.bhamla
     * @since Jul 23, 2017 2:47:32 PM
     */
    private CapabilityUtils () {
        // Utility class.
    }
}