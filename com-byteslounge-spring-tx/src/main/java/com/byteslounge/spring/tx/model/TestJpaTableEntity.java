package com.byteslounge.spring.tx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="testjpatable")
//@SequenceGenerator(name="TESTJPATABLE_SEQ", initialValue=1, allocationSize=100)
public class TestJpaTableEntity {

	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="TESTJPATABLE_SEQ")
	  @SequenceGenerator(name = "persons_seq", sequenceName = "TESTJPATABLE_SEQ")
	  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persons_seq")
	@Column(name="KEYNUMBER", nullable = false)
	private Integer KEYNUMBER;
	
	@Column(name="NAME", nullable = false)
	private String NAME;
	
	@Column(name="ADDRESS", nullable = false)
	private String ADDRESS;
	
	@Column(name="PHONE", nullable = false)
	private String PHONE;

 
	public Integer getKEYNUMBER() {
		return KEYNUMBER;
	}

	public void setKEYNUMBER(Integer kEYNUMBER) {
		KEYNUMBER = kEYNUMBER;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getADDRESS() {
		return ADDRESS;
	}

	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	public String getPHONE() {
		return PHONE;
	}

	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}

	
	
}
