/**
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
package com.github.wasiqb.coteafs.appium.device;

import static com.github.wasiqb.coteafs.appium.constants.ErrorMessage.SERVER_STOPPED;
import static com.github.wasiqb.coteafs.appium.utils.ErrorUtils.fail;
import static java.time.Duration.ofSeconds;

import java.util.function.Consumer;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchSessionException;

import com.github.wasiqb.coteafs.appium.checker.DeviceChecker;
import com.github.wasiqb.coteafs.appium.error.AppiumServerStoppedError;
import com.github.wasiqb.coteafs.error.NotImplementedError;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

/**
 * @author wasiq.bhamla
 * @param <D>
 * @param <E>
 * @since 26-Apr-2017 6:39:03 PM
 */
public class DeviceElementActions <D extends AppiumDriver <MobileElement>, E extends Device <D>> {
	private static final Logger log;

	static {
		log = LogManager.getLogger (DeviceElementActions.class);
	}

	private final E				device;
	private final D				driver;
	private final MobileElement	element;
	private final String		name;
	private final TouchAction	touch;

	/**
	 * @author wasiq.bhamla
	 * @param device
	 * @param name
	 * @param element
	 * @since 26-Apr-2017 6:39:03 PM
	 */
	public DeviceElementActions (final E device, final String name, final MobileElement element) {
		this.device = device;
		this.name = name;
		this.element = element;
		this.driver = this.device.getDriver ();
		this.touch = new TouchAction (this.driver);
		DeviceChecker.checkDeviceElementDisplayed (element, name);
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 21, 2017 5:22:04 PM
	 * @param text
	 */
	public void appendText (final String text) {
		final String actionType = String.format ("Appending text [%s] in", text);
		perform (actionType, e -> {
			tap ();
			e.sendKeys (text);
		});
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:49:52 PM
	 */
	public void clear () {
		perform ("Clearing", e -> e.clear ());
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jul 15, 2017 6:12:00 PM
	 */
	public void click () {
		perform ("Clicking on", e -> e.click ());
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:51:07 PM
	 * @return enabled
	 */
	public boolean enabled () {
		return getValue ("Checking if element [%s] is enabled...", e -> e.isEnabled ());
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:31:45 PM
	 * @param text
	 */
	public void enterText (final String text) {
		final String actionType = String.format ("Entering text [%s] in", text);
		perform (actionType, e -> {
			tap ();
			clear ();
			e.sendKeys (text);
		});
	}

	/**
	 * @author wasiq.bhamla
	 * @since 19-May-2017 10:03:16 PM
	 * @return the device
	 */
	public E getDevice () {
		return this.device;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 19-May-2017 10:03:16 PM
	 * @return the driver
	 */
	public D getDriver () {
		return this.driver;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:54:58 PM
	 */
	public void longPress () {
		perform ("Performing long press on", e -> {
			final int beforeTap = this.device.getSetting ()
				.getDelayBeforeTap ();
			final int afterTap = this.device.getSetting ()
				.getDelayAfterTap ();
			this.touch.waitAction (ofSeconds (beforeTap))
				.longPress (e)
				.waitAction (ofSeconds (afterTap))
				.perform ();
		});
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:49:08 PM
	 */
	public void pinch () {
		checkElementEnabled ();
		log.info (String.format ("Pinching on element [%s]...", this.name));
		try {
			fail (NotImplementedError.class, "Pinch! Coming Soon!!");
		}
		catch (final NoSuchSessionException e) {
			fail (AppiumServerStoppedError.class, SERVER_STOPPED, e);
		}
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:50:40 PM
	 * @return selected
	 */
	public boolean selected () {
		return getValue ("Checking if element [%s] is selected...", e -> e.isSelected ());
	}

	/**
	 * @author wasiq.bhamla
	 * @since 06-May-2017 4:56:42 PM
	 */
	public void submit () {
		perform ("Performing submit", e -> e.submit ());
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-May-2017 10:07:14 PM
	 * @param direction
	 */
	public void swipe (final SwipeDirection direction) {
		checkElementEnabled ();
		log.info (String.format ("Swiping [%s] on element [%s]...", direction, this.name));
		try {
			fail (NotImplementedError.class, "Swipe! Coming Soon!!");
		}
		catch (final NoSuchSessionException e) {
			fail (AppiumServerStoppedError.class, SERVER_STOPPED, e);
		}
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-May-2017 10:08:55 PM
	 */
	public void tap () {
		perform ("Tapping on", e -> {
			final int beforeTap = this.device.getSetting ()
				.getDelayBeforeTap ();
			final int afterTap = this.device.getSetting ()
				.getDelayAfterTap ();
			this.touch.waitAction (ofSeconds (beforeTap))
				.tap (e)
				.waitAction (ofSeconds (afterTap))
				.perform ();
		});
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:52:40 PM
	 * @return text
	 */
	public String text () {
		return getValue ("Getting text on element [%s]...", e -> e.getText ());
	}

	/**
	 * @author wasiq.bhamla
	 * @since 19-May-2017 10:09:58 PM
	 * @return verify
	 */
	public DeviceElementVerify <D, E> verifyThat () {
		return new DeviceElementVerify <> (this);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:51:40 PM
	 * @return visible
	 */
	public boolean visible () {
		return getValue ("Checking if element [%s] is visible...", e -> e.isDisplayed ());
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:48:10 PM
	 */
	public void zoom () {
		checkElementEnabled ();
		log.info (String.format ("Zooming on element [%s]...", this.name));
		try {
			fail (NotImplementedError.class, "Zoom! Coming Soon!!");
		}
		catch (final NoSuchSessionException e) {
			fail (AppiumServerStoppedError.class, SERVER_STOPPED, e);
		}
	}

	private void checkElementEnabled () {
		DeviceChecker.checkDeviceElementEnabled (this.element, this.name);
	}

	private <R> R getValue (final String message, final Function <MobileElement, R> func) {
		log.info (String.format (message, this.name));
		try {
			return func.apply (this.element);
		}
		catch (final NoSuchSessionException e) {
			fail (AppiumServerStoppedError.class, SERVER_STOPPED, e);
		}
		return null;
	}

	private void perform (final String action, final Consumer <MobileElement> consumer) {
		checkElementEnabled ();
		log.info (String.format ("%s element [%s]...", action, this.name));
		try {
			consumer.accept (this.element);
		}
		catch (final NoSuchSessionException e) {
			fail (AppiumServerStoppedError.class, SERVER_STOPPED, e);
		}
	}
}