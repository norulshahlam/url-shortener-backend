package com.shah.urlshortener.entity;

import org.hibernate.annotations.NaturalId;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Url {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false, unique = true)
	private Long id;

	@NaturalId
	@Column(unique = true, nullable = false)
	private String alias;

	@Column(nullable = false)
	private String url;

	public Url() {
		super();
	}

	public Url(String alias, String url) {
		super();
		this.alias = alias;
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
