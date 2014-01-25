package ae.iemq.vims.util;

import java.net.InetAddress;
import java.security.SecureRandom;

import org.apache.log4j.Logger;

/**
 * This is a <i>singleton</i> class that generates a unique 32 charater string.
 * <br/>The String consists of 4 sequences of 8 character strings as follows:
 * <ul>
 * <li>Current milliseconds <code>System.currentTimeMillis</code></li>
 * <li>IP Address <code>InetAddress.getLocalHost()</code></li>
 * <li>Object ID within JVM <code>System.identityHashCode(this)</code></li>
 * <li>Random 32 bit Integer <code>java.security.SecureRandom</code></li>
 * </ul>
 * @author Neil Crow
 * 
 * Implementation - GuidGenerator guidGenerator = GuidGenerator.getInstance();
                    guidGenerator.generateGUID(this);             
 */
public final class GuidGenerator {
    /** The internal logger. */
	static Logger LOG = Logger.getLogger(GuidGenerator.class);

    /** HEX_HIGH_VALUES = 0xFF. */
    private static final int HEX_HIGH_VALUES = 0xFF;

    /** SUBNET_MASK_24_BIT = 24. */
    private static final int SUBNET_MASK_24_BIT = 24;

    /** SHIFT_BIT_8 = 8. */
    private static final int SHIFT_BIT_8 = 8;

    /** Holder for Hex 7F. */
    private static final byte HOLD_7F = 0x7F;

    /** Loopback IP Address. localhost=127.0.0.1 */
    private static final byte[] IP_LOOPBACK =
        new byte[] {HOLD_7F, 0x00, 0x00, 0x01};

    /** Length of guid String = 32. */
    private static final int GUID_LENGTH_32 = 32;

    /** Length of Hex String = 8. */
    private static final int HEX_LENGTH_8 = 8;

    /** Length of Hex String = 16. */
    private static final int HEX_LENGTH_16 = 16;

    /** Cached per JVM server IP. */
    private static GuidGenerator guidGenerator = null;

    /** Cached per JVM server IP. */
    private String hexServerIP = null;

    /** initialise the secure random instance. */
    private final SecureRandom seeder = new SecureRandom();

    /**
     * Returns the singleton instance of the GuidGenerator.
     * @return GuidGenerator The <code>GuidGenerator</code> instance
     */
    public static synchronized GuidGenerator getInstance() {
        if (guidGenerator == null) {
            guidGenerator = new GuidGenerator();
        }

        return guidGenerator;
    }

    /**
     * GuidGenerator private constructor.
     */
    private GuidGenerator() {
        InetAddress localInetAddress = null;
        byte[] serverIP = null;
        try {
            // get the inet address
            localInetAddress = InetAddress.getLocalHost();
            serverIP = localInetAddress.getAddress();
        } catch (java.net.UnknownHostException uhe) {
            LOG.warn(
                "GuidGenerator: Could not get the local IP address using "
                    + "InetAddress.getLocalHost()! Using loopBack 127.0.0.1",
                uhe);
            serverIP = IP_LOOPBACK;
        }

        this.hexServerIP = hexFormat(getInt(serverIP), HEX_LENGTH_8);
    }

    /**
     * A 32 byte GUID generator (Globally Unique ID).
     * These artificial keys SHOULD <strong>NOT </strong> be seen by the user.
     *
     * Usage: Add a guid field (type java.lang.String) to your EJB,
     * and add <code>setGuid(guidGenerator.generateGUID(this));</code>
     * to the ejbCreate method.
     * @param obj The Object for which the GUID will be generated.
     * @return String
     */
    public String generateGUID(final Object obj) {
        StringBuffer tmpBuffer = new StringBuffer(HEX_LENGTH_16);

        String hashcode = hexFormat(System.identityHashCode(obj), HEX_LENGTH_8);
        tmpBuffer.append(this.hexServerIP);
        tmpBuffer.append(hashcode);

        long timeNow = System.currentTimeMillis();
        int timeLow = (int) timeNow & 0xFFFFFFFF;
        int node = seeder.nextInt();

        StringBuffer guid = new StringBuffer(GUID_LENGTH_32);
        guid.append(hexFormat(timeLow, HEX_LENGTH_8));
        guid.append(tmpBuffer.toString());
        guid.append(hexFormat(node, HEX_LENGTH_8));
        return guid.toString();
    }

    /**
     * Returns an integer value for the String representation of an IP Address.
     * @param bytes The IP Address to convert to int.
     * @return int
     */
    private int getInt(final byte[] bytes) {
        int i = 0;
        int j = SUBNET_MASK_24_BIT;
        for (int k = 0; j >= 0; k++) {
            int l = bytes[k] & HEX_HIGH_VALUES;
            i += l << j;
            j -= SHIFT_BIT_8;
        }
        return i;
    }

    /**
     * Returns a String that contains the hexadecimal number of <code>i</code>,
     * The String is padded to the length of <code>j</code>.
     * @param i The Integer to convert to hexadecimal.
     * @param j The length of the resulting hexadecimal String.
     * @return String
     */
    private String hexFormat(final int i, final int j) {
        String s = Integer.toHexString(i);
        return padHex(s, j) + s;
    }

    /**
     * Returns a String that is right-padded with zeroes giving a resulting
     * <code>String.length() = i</code>.
     * @param s The String to pad.
     * @param i The resulting padded length.
     * @return String
     * @todo Consider using StringUtil.rightPad(s, i, "0")
     */
    private String padHex(final String s, final int i) {
        StringBuffer tmpBuffer = new StringBuffer();
        if (s.length() < i) {
            for (int j = 0; j < i - s.length(); j++) {
                tmpBuffer.append('0');
            }
        }
        return tmpBuffer.toString();
    }
}
