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
 * @author wasiq.bhamla
 * @since Oct 16, 2017 9:34:46 PM
 */
public enum SwipeDirection {
    /**
     * Swipe up.
     */
    DOWN(0, 1),
    /**
     * Swipe left.
     */
    LEFT(-1, 0),
    /**
     * Swipe right.
     */
    RIGHT(1, 0),
    /**
     * Swipe up.
     */
    UP(0, -1);

    private final int x;
    private final int y;

    /**
     * @author wasiq.bhamla
     * @since Oct 20, 2017 7:56:06 PM
     */
    SwipeDirection(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return the x
     * @author wasiq.bhamla
     * @since Oct 20, 2017 7:57:09 PM
     */
    public int getX() {
        return this.x;
    }

    /**
     * @return the y
     * @author wasiq.bhamla
     * @since Oct 20, 2017 7:57:09 PM
     */
    public int getY() {
        return this.y;
    }
}