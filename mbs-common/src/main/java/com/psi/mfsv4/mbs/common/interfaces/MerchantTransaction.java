package com.psi.mfsv4.mbs.common.interfaces;

import javax.ejb.Remote;

import com.psi.mfsv4.mbs.common.objects.Request;
import com.psi.mfsv4.mbs.common.objects.Result;

@Remote
public interface MerchantTransaction {
	Result inquire(Request request);	
	Result payment(Request request);
	Result status(Request request);
	Result rollback(Request request);
}
