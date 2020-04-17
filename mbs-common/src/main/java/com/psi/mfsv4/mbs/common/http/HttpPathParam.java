package com.psi.mfsv4.mbs.common.http;

import java.util.ArrayList;

public class HttpPathParam extends ArrayList<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8511404299516989358L;
	
	public String fromIndex(int start) {
		return start < this.size()? String.join("/", this.subList(start, this.size())):"";
	}

	@Override
	public String toString(){
		return String.join("/", this);
	}
}
