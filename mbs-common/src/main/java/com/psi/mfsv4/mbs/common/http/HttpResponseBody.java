package com.psi.mfsv4.mbs.common.http;

import java.io.Serializable;
import java.util.Map;

public abstract class HttpResponseBody implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2541979364920776540L;
	protected String raw;
	protected Map<String, Object> data;

	public void setData(Map<String, Object> data) {
		this.data = data;
		serialize();
	}

	public void setData(String data) {
		this.raw = data;
	}

	public abstract void serialize();

	@Override
	public String toString() {
		return raw;
	}
}
