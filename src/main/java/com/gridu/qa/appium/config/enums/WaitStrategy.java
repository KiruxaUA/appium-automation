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
package com.gridu.qa.appium.config.enums;

/**
 * @author wasiqb
 * @since Oct 20, 2018
 */
public enum WaitStrategy {
    /**
     * Wait until element is enabled.
     */
    ENABLED,
    /**
     * No wait.
     */
    NONE,
    /**
     * Wait until element is present.
     */
    PRESENT,
    /**
     * Wait until element is displayed.
     */
    VISIBLE
}