package com.psi.mfsv4.mbs.common.http;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Map;

import org.json.simple.JSONObject;

import lombok.Getter;

@Getter
public class HttpResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5524128332916071691L;
	private Hashtable<String, String> headers = new Hashtable<String, String>();
	private HttpResponseBody body;
	private Map<String, Object> data;
	private String raw;
	private int httpStatus;

	public HttpResponse(int status) {
		this.httpStatus = status;
	}

	public HttpResponse(int status, Map<String, Object> data) {
		this.data = data;
		this.httpStatus = status;
		this.raw = new JSONObject(data).toJSONString();
	}

	public HttpResponse(int status, String data) {
		this.raw = data;
		this.httpStatus = status;
	}

	public void addHeader(String key, String value) {
		headers.put(key, value);
	}

	@Override
	public String toString() {
		return this.raw;
	}
}
