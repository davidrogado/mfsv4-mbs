package com.psi.mfsv4.mbs.common.http;

import java.io.Serializable;
import java.util.Map;

import org.json.simple.parser.JSONParser;

public class HttpRequestBody implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4067122605249866714L;
	protected String raw;
	protected Map<String, Object> params;

	@SuppressWarnings("unchecked")
	public HttpRequestBody(String raw) throws Exception {
		JSONParser p = new JSONParser();
		this.raw = raw;
		this.params = (Map<String, Object>) p.parse(raw);
	}

	@Override
	public String toString() {
		return raw;
	}

	public Object get(String key) {
		return this.params.get(key);
	}

	public boolean contains(String key) {
		return this.params.containsKey(key) && this.params.get(key) != null;
	}
}
