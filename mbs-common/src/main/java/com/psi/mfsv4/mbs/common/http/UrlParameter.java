package com.psi.mfsv4.mbs.common.http;

import java.io.Serializable;

public class UrlParameter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7559809460346309920L;
	private String[] splitPath;
	private String raw;

	public UrlParameter(String unparsedPath) {
		this.raw = unparsedPath;
		splitPath = unparsedPath.split("/");
	}

	public String get(int index) {
		return splitPath[index];
	}

	@Override
	public String toString() {
		return this.raw;
	}

	public int size() {
		return splitPath.length;
	}
}