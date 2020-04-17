package com.psi.mfsv4.mbs.gateway.abstracts;

import java.util.Collections;
import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.HandlerMapping;

import com.psi.mfsv4.mbs.common.http.HttpMethod;
import com.psi.mfsv4.mbs.common.http.HttpPathParam;
import com.psi.mfsv4.mbs.common.http.HttpQueryParams;
import com.psi.mfsv4.mbs.common.http.HttpRequest;
import com.psi.mfsv4.mbs.common.http.QueryParameter;
import com.psi.mfsv4.mbs.common.http.UrlParameter;
import com.psi.mfsv4.mbs.gateway.common.Constant;
import com.psi.mfsv4.mbs.gateway.exceptions.HttpRequestException;
import com.tlc.common.Logger;

public abstract class AbstractGatewayService {

	public HttpRequest parse(HttpMethod method, String raw, HttpServletRequest request) throws HttpRequestException {

		try {
			Hashtable<String, String> headers = new Hashtable<String, String>();
			for (String key : Collections.list(request.getHeaderNames())) {
				String value = request.getHeader(key);
				headers.put(key.toLowerCase(), value);
			}
			headers.put(Constant.HDR_CLIENT_ADDRESS, request.getRemoteAddr());
			
			String resource = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
			UrlParameter nodes = new UrlParameter(resource);
			HttpPathParam pathParams = new HttpPathParam();
			for (int x = 3; x < nodes.size(); x++) {
				pathParams.add(nodes.get(x));
			}

			HttpQueryParams queryParams = new HttpQueryParams();
			QueryParameter query = new QueryParameter(request.getQueryString());
			for (String key : query.getQueryParams().keySet()) {
				queryParams.put(key, query.getQueryParams().get(key));
			}

			HttpRequest req = raw != null ? new HttpRequest(pathParams.toString(), method, raw)
					: new HttpRequest(pathParams.toString(), method);
			req.setHeaders(headers);
			req.setPathParams(pathParams);
			req.setQueryParams(queryParams);
			return req;

		} catch (Exception e) {
			Logger.LogServer(e);
			throw new HttpRequestException();
		}

	}

}
