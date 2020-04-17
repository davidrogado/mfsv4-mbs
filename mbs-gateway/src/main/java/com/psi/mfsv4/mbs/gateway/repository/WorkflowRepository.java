package com.psi.mfsv4.mbs.gateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.psi.mfsv4.mbs.gateway.common.SQLQuery;
import com.psi.mfsv4.mbs.gateway.entity.WorkflowEntity;

public interface WorkflowRepository extends JpaRepository<WorkflowEntity, Long>{
	
	@Query(value = SQLQuery.Native.SELECT_WORKFLOWS_BY_REGEX_RESOURCE, nativeQuery = true) 
	WorkflowEntity findByResource(String url, String method);
	
}
