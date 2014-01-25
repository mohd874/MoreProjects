package ae.iemq.vims.util;

import java.util.Comparator;

import ae.iemq.vims.domain.BaseEntity;

public class BaseEntityCreateDateComparetor implements Comparator<BaseEntity> {

	public int compare(BaseEntity o1, BaseEntity o2) {
		if(o1.getCreateDateTime()==null)
		{
			return 1;
		}else if(o2.getCreateDateTime()==null){
			return -1;
		}
		return o2.getCreateDateTime().compareTo(o1.getCreateDateTime());
	}

}
