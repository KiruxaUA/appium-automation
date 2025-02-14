/*
 *
 *  Copyright (c) 2020, Wasiq Bhamla.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package com.gridu.qa.appium.config.device;

import java.util.HashMap;
import java.util.Map;

import com.gridu.qa.appium.config.device.android.AndroidDeviceSetting;
import com.gridu.qa.appium.config.device.ios.IOSDeviceSetting;
import com.gridu.qa.appium.config.enums.AutomationType;
import com.gridu.qa.appium.config.enums.Browser;
import com.gridu.qa.appium.config.enums.DeviceType;
import com.gridu.qa.appium.config.enums.Language;
import com.gridu.qa.appium.config.enums.PlatformType;
import lombok.Data;

/**
 * @author wasiq.bhamla
 * @since 12-Apr-2017 8:34:28 PM
 */
@Data
public class DeviceSetting {
    private AndroidDeviceSetting android;
    private boolean              autoWebView;
    private AutomationType       automation        = AutomationType.APPIUM;
    private Browser              browser;
    private Map<String, String>  cloudCapabilities = new HashMap<> ();
    private boolean              headless;
    private IOSDeviceSetting ios;
    private Language             language          = Language.US;
    private String               name;
    private PlatformType         os                = PlatformType.ANDROID;
    private OtherSetting         others            = new OtherSetting ();
    private PlaybackSetting      playback          = new PlaybackSetting ();
    private int                  sessionTimeout    = 60;
    private DeviceType           type              = DeviceType.SIMULATOR;
    private String               version;

    /**
     * @return Cloud Capabilities
     *
     * @author Wasiq Bhamla
     * @since Mar 13, 2021
     */
    public boolean isCloud () {
        return getCloudCapabilities ().size () > 0;
    }
}