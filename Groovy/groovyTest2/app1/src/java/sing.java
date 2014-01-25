/**
 * Created by IntelliJ IDEA.
 * User: Saeed
 * Date: Feb 24, 2008
 * Time: 8:41:53 PM
 * To change this template use File | Settings | File Templates.
 */

public class sing {
    private static sing ourInstance = new sing();

    public static sing getInstance() {
        return ourInstance;
    }

    private sing() {
    }
}
