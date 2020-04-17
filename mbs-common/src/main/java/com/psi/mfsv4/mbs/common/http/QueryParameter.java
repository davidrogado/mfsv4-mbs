package com.psi.mfsv4.mbs.common.http;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Hashtable;

public class QueryParameter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6819762851952868951L;
	private Hashtable<String, String> queryParams = new Hashtable<String, String>();
	private String raw;

	public QueryParameter(String unparsedQuery) throws UnsupportedEncodingException {
		if(unparsedQuery == null) return;
		this.raw = unparsedQuery;
		String[] pairs = unparsedQuery.split("&");
		for (String pair : pairs) {
			int idx = pair.indexOf("=");
			queryParams.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"),
					URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
		}
	}
	
	public Hashtable<String, String> getQueryParams() {
		return queryParams;
	}

	@Override
	public String toString() {
		return this.raw;
	}
}
