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
package com.gridu.qa.appium.error;

/**
 * @author wasiq.bhamla
 * @since 06-May-2017 4:07:48 PM
 */
public class DeviceDriverInitializationFailedError extends CoteafsAppiumError {
    private static final long serialVersionUID = -3202324172947020043L;

    /**
     * @param message
     * @author wasiq.bhamla
     * @since 06-May-2017 4:07:48 PM
     */
    public DeviceDriverInitializationFailedError(final String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     * @author wasiq.bhamla
     * @since 06-May-2017 4:07:48 PM
     */
    public DeviceDriverInitializationFailedError(final String message, final Throwable cause) {
        super(message, cause);
    }
}