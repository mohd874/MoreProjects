/*
 * Copyright (c) 2004 STRATE Limited.
 * All rights reserved.
 */
package ae.iemq.vims.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity
@Table(name = "vims_log")
@NamedQueries( {})
public class VimsLog extends BaseEntity {

	public static final int LOG_TYPE_NUM_USER = 1;

	public static final int LOG_TYPE_NUM_DELETE = 2;

	public static final String LOG_TYPE_DESC_USER = "User";

	public static final String LOG_TYPE_DESC_DELETE = "Deleted Record";

	public static final String LOG_TYPE_DESC_INVALID = "Invalid Log Type";

	@Column(name = "log_type")
	private int logType;

	@Column(name = "message")
	private String message;

	@Override
	public String toString() {
		return message;
	}

	/**
	 * Returns the logType description.
	 * 
	 * @return String
	 */
	public String getLogTypeDesc() {
		String logTypeDesc = null;

		switch (this.logType) {
		case LOG_TYPE_NUM_USER:
			logTypeDesc = LOG_TYPE_DESC_USER;
			break;
		case LOG_TYPE_NUM_DELETE:
			logTypeDesc = LOG_TYPE_DESC_DELETE;
			break;
		default:
			logTypeDesc = LOG_TYPE_DESC_INVALID;
			break;
		}
		return logTypeDesc;
	}

	public int getLogType() {
		return logType;
	}

	public void setLogType(int logType) {
		this.logType = logType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}