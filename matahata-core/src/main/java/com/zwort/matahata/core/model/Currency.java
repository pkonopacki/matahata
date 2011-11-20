package com.zwort.matahata.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//@NamedQueries({
//	@NamedQuery(name = "findCurrencyById", query = "select c from Currency c where c.isoCode = ?1"),
//	@NamedQuery(name = "findCurrencyByISOCode", query = "select c from Currency c where c.id = ?1"),
//	@NamedQuery(name = "findAllCurrencies", query = "select c from Currency c"),
//	@NamedQuery(name = "findActiveCurrencies", query = "select c from Currency c where c.active = 1")
//})

@Entity
@Table(name = "currency")
public class Currency extends AbstractDictionaryEntity {

	private static final long serialVersionUID = 3131808682545104111L;
	
	@Column(name = "iso_code", nullable = false)
	private String isoCode;
	
	@Column(name = "is_default", nullable = false)
	private boolean defaultCurrency;

	
	public String getIsoCode() {
		return isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	public boolean isDefaultCurrency() {
		return defaultCurrency;
	}

	public void setDefaultCurrency(boolean defaultCurrency) {
		this.defaultCurrency = defaultCurrency;
	}

}
