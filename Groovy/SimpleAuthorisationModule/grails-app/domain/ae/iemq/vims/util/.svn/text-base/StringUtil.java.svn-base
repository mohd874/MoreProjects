/*
 * Copyright (c) IeMQ.
 * All rights reserved.
 */
package ae.iemq.vims.util;

import org.apache.log4j.Logger;

/**
 * StringUtil.
 */
public final class StringUtil {

	/** Logger. */
	static Logger LOG = Logger.getLogger(StringUtil.class);

	/** QUESTIONMARK = _. */
	public static final String QUESTIONMARK = "?";

	/** A space. */
	public static final char SPACE = ' ';

	/** Non-breaking space = &nbsp;. */
	public static final String NON_BREAKING_SPACE = "&nbsp;";

	/** Forward slash = /. */
	public static final String FORWARD_SLASH = "/";

	/** Back slash = /. */
	public static final String BACK_SLASH = "\\";

	/** FULL_STOP. */
	public static final String FULL_STOP = ".";

	/** COMMA. */
	public static final String COMMA = ",";

	/** DASH: -. */
	public static final String DASH = "-";

	/** LEFT_BRACKET. */
	public static final String LEFT_BRACKET = "(";

	/** RIGHT_BRACKET. */
	public static final String RIGHT_BRACKET = ")";

	/** COLON. */
	public static final String COLON = ":";

	/**
	 * Empty private constructor.
	 */
	private StringUtil() {
	}

	/**
	 * Clean a string, by trimming any whitespace on either end. Treats NULL as
	 * an empty string.
	 * 
	 * @param str
	 *            The string to check.
	 * @return String
	 */
	public static String clean(final String str) {
		if (str == null) {
			return "";
		} else {
			return str.trim();
		}
	}

	/**
	 * Clean a string, by trimming any whitespace on either end. Treats NULL as
	 * a NULL.
	 * 
	 * @param str
	 *            The string to check.
	 * @return String - The string trimmed
	 */
	public static String trim(final String str) {
		if (str == null) {
			return null;
		} else {
			return str.trim();
		}
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param str
	 *            The string to check.
	 * @return String - The string processed
	 */
	public static String replaceXml(String str) {
		LOG.debug("Before check string is--->"+str);
		if (str == null) {
			return null;
		} 

			str=str.replaceAll("%", "%25");
		
			str=str.replaceAll("&", "%26");
		
			str.replace("�", "%E2%82%AC");
		
			str.replace("�", "");
	
			str=str.replaceAll("<", "&lt");
		
			str=str.replaceAll(">", "&gt");
		
			str=str.replaceAll("'", "%26apos;");
			LOG.debug("After check string is--->"+str);
		
		return str;
	}
	
    /**
     * Replace a given String token with a replacement String in a String.
     * @param inputString -
     *            The string to search
     * @param tokenString -
     *            The string being saught
     * @param replacementString -
     *            The string to replace with
     * @return String
     */
    public static String replace(final String inputString,
        final String tokenString, final String replacementString) {
        int pos = 0, curPos = 0;
        StringBuffer tmp = new StringBuffer();
        pos = inputString.indexOf(tokenString);
        if (pos < 0) {
            return inputString;
        }
        if (pos == 0) {
            tmp.append(replacementString);
            curPos = tokenString.length();
            if (curPos >= inputString.length()) {
                return tmp.toString();
            }
            pos = inputString.indexOf(tokenString, curPos);
        }
        while (pos > 0) {
            tmp.append(inputString.substring(curPos, pos));
            tmp.append(replacementString);
            curPos = pos + tokenString.length();
            pos = inputString.indexOf(tokenString, curPos);
        }
        if (curPos < inputString.length()) {
            tmp.append(inputString.substring(curPos, inputString.length()));
        }
        return tmp.toString();
    }


	/**
	 * Clean a string, by trimming any whitespace on either end. Treats NULL as
	 * a NULL and Treats empty String as NULL.
	 * 
	 * @param str
	 *            The string to check.
	 * @return String
	 */
	public static String trimToNull(final String str) {
		String trimmedStr = StringUtil.trim(str);
		if (trimmedStr != null && trimmedStr.length() == 0) {
			trimmedStr = null;
		}
		return trimmedStr;
	}

	/**
	 * This method strips all non-digits from the supplied String and returns
	 * the numeric String result.
	 * 
	 * @param str -
	 *            The String from which to extract numbers.
	 * @return String
	 */
	public static String getOnlyDigits(final String str) {
		String numString = null;
		if (str != null) {
			numString = "";
			char[] chars = str.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				if (Character.isDigit(chars[i])) {
					numString += String.valueOf(chars[i]);
				}
			}
		}
		return numString;
	}

	/**
	 * Test if a given string is numeric.
	 * 
	 * @param str
	 *            The string to check.
	 * @return boolean
	 */
	public static boolean isNumeric(final String str) {
		boolean result = true;
		if (str == null) {
			result = false;
		} else {
			int sz = str.length();
			for (int i = 0; (i < sz) && (result); i++) {
				result = Character.isDigit(str.charAt(i));
			}
		}

		return result;
	}

	/**
	 * This method will return a cleaned string with numerics and decimals only.
	 * 
	 * @param str
	 *            The string to check.
	 * @return String
	 */
	public static String getNumericValueIncludingDecimal(final String str) {
		StringBuffer newString = new StringBuffer();
		if (str != null) {
			newString = new StringBuffer();
			int sz = str.length();
			for (int i = 0; i < sz; i++) {
				char thisChar = str.charAt(i);
				if (Character.isDigit(thisChar) || thisChar == '.') {
					newString.append(thisChar);
				}
			}
		}
		return newString.toString();
	}
}