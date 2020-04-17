package com.psi.mfsv4.mbs.gateway.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tblworkflows")
@Setter @Getter @ToString
public class WorkflowEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column private long id;
	@Column private String url;
	@Column private String workflow;
	@Column private String params;
	@Column private String method;

}
