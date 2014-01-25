package ae.iemq.vims.domain;

import java.util.Comparator;

public class CreateDateComparator implements Comparator {

	public int compare(Object arg0, Object arg1) {
		return ((Comment)arg0).getCreateDateTime().compareTo(((Comment)arg1).getCreateDateTime());
	}

}
