package com.psi.mfsv4.mbs.common.objects;

import java.io.Serializable;
import java.util.HashMap;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Result implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int code = 99;
	private String message;
	private HashMap<String, Object> data = new HashMap<String, Object>();
	
	public void addData(String key, Object value) {
		this.data.put(key, value);
	}

}
