package com.psi.mfsv4.mbs.gateway.common;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SQLQuery {
	
	@UtilityClass
	public class Native {
		public final String SELECT_WORKFLOWS_BY_REGEX_RESOURCE = "SELECT * FROM tblworkflows WHERE regexp_like(:url, url) and method = :method order by id";
		
	}

}
