package ae.iemq.vims.util;

import java.io.Serializable;

/**
 * Key value pair.
 */
public class KeyValue implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * key Object.
	 */
	private Object key = null;

	/**
	 * value Object.
	 */
	private Object value = null;

	/**
	 * Constructor.
	 */
	public KeyValue() {
	}

	/**
	 * Constructor.
	 * 
	 * @param key
	 *            key.
	 * @param value
	 *            value.
	 */
	public KeyValue(final Object key, final Object value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * getKey method.
	 * 
	 * @return the key of type Object.
	 */
	public Object getKey() {
		return key;
	}

	/**
	 * setKey method
	 * 
	 * @param key
	 *            the key of type Object to set.
	 */
	public void setKey(Object key) {
		this.key = key;
	}

	/**
	 * getValue method.
	 * 
	 * @return the value of type Object.
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * setValue method
	 * 
	 * @param value
	 *            the value of type Object to set.
	 */
	public void setValue(Object value) {
		this.value = value;
	}
}
