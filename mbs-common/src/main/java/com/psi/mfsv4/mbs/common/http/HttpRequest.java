package com.psi.mfsv4.mbs.common.http;

import java.io.Serializable;
import java.util.Hashtable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7991576458905812765L;
	protected Hashtable<String, String> headers = new Hashtable<String, String>();
	protected HttpRequestBody body;
	protected HttpQueryParams queryParams = new HttpQueryParams();
	protected HttpPathParam pathParams = new HttpPathParam();
	protected String raw = "";
	protected HttpMethod type;
	protected String source;

	public HttpRequest(String source, HttpMethod type) {
		this.source = source;
		this.type = type;
	};

	public HttpRequest(String source, HttpMethod type, String raw) throws Exception {
		this.raw = raw;
		this.type = type;
		this.source = source;
		this.body = new HttpRequestBody(raw);
	}

	public void addHeader(String key, String value) {
		headers.put(key.toLowerCase(), value);
	}

	public String getHeader(String key) {
		return this.headers.get(key.toLowerCase());
	}
	
	@Override
	public String toString() {
		return this.raw;
	}

}
