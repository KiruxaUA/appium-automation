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

import lombok.Data;

/**
 * @author Wasiq Bhamla
 * @since Mar 13, 2021
 */
@Data
public class DelaySetting {
    private long afterSwipe;
    private long afterTap;
    private long beforeSwipe;
    private long beforeTap;
    private int  explicit = 30;
    private int  implicit = 30;
}