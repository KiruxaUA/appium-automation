package com.github.wasiqb.coteafs.appium.device;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;

/**
 * @author wasiq.bhamla
 * @param <TDriver>
 * @since 26-Apr-2017 6:39:03 PM
 */
public class DeviceElementActions <TDriver extends AppiumDriver <MobileElement>> {
	private static final Logger log;

	static {
		log = LogManager.getLogger (DeviceElementActions.class);
	}

	private final TDriver		driver;
	private final MobileElement	element;
	private final String		name;
	private final TouchAction	touch;

	/**
	 * @author wasiq.bhamla
	 * @param driver
	 * @param name
	 * @param element
	 * @since 26-Apr-2017 6:39:03 PM
	 */
	public DeviceElementActions (final TDriver driver, final String name, final MobileElement element) {
		this.driver = driver;
		this.name = name;
		this.element = element;
		this.touch = new TouchAction (this.driver);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:49:52 PM
	 */
	public void clear () {
		log.info (String.format ("Clearing element %s...", this.name));
		this.element.clear ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:51:07 PM
	 * @return enabled
	 */
	public boolean enabled () {
		log.info (String.format ("Checking if element %s is enabled...", this.name));
		return this.element.isEnabled ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:31:45 PM
	 * @param text
	 */
	public void enterText (final String text) {
		clear ();
		log.info (String.format ("Entering text [%s] in element %s...", text, this.name));
		this.element.sendKeys (text);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:54:58 PM
	 */
	public void longPress () {
		log.info (String.format ("Performing long press on element %s...", this.name));
		this.touch.longPress (this.element)
			.perform ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:55:59 PM
	 * @param duration
	 */
	public void longPress (final int duration) {
		log.info (String.format ("Performing long press on element %s till %d ms...", this.name, duration));
		this.touch.longPress (this.element, duration)
			.perform ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:49:08 PM
	 */
	public void pinch () {
		log.info (String.format ("Pinching on element %s...", this.name));
		this.element.pinch ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:50:40 PM
	 * @return selected
	 */
	public boolean selected () {
		log.info (String.format ("Checking if element %s is selected...", this.name));
		return this.element.isSelected ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:47:41 PM
	 * @param direction
	 */
	public void swipe (final SwipeElementDirection direction) {
		log.info (String.format ("Swiping to %s on element %s...", direction, this.name));
		this.element.swipe (direction, 100);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 7:36:44 PM
	 * @param delay
	 */
	public void tap (final int delay) {
		log.info (String.format ("Tapping on element %s till %d ms...", this.name, delay));
		this.element.tap (1, delay);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:52:40 PM
	 * @return text
	 */
	public String text () {
		log.info (String.format ("Getting text on element %s...", this.name));
		return this.element.getText ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:51:40 PM
	 * @return visible
	 */
	public boolean visible () {
		log.info (String.format ("Checking if element %s is visible...", this.name));
		return this.element.isDisplayed ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:48:10 PM
	 */
	public void zoom () {
		log.info (String.format ("Zooming on element %s...", this.name));
		this.element.zoom ();
	}
}