package com.ishwor.newp.spring.boot.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@NamedQuery(name = "findAllCategories", query = "Select c from Categories c")
public class Categories {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer cId;

	@NotNull(message = "Categories name cant be null")
	@NotEmpty(message = "Categories name cant empty")
	@NotBlank(message = "Categories name cant be blank")
	private String categoriesName;

	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdDate;

	public LocalDateTime getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public Categories() {

	}

	public Categories(String categoriesName) {
		this.categoriesName = categoriesName;
	}

	public String getCategoriesName() {
		return categoriesName;
	}

	public void setCategoriesName(String categoriesName) {
		this.categoriesName = categoriesName;
	}

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	@Override
	public String toString() {
		return "Categories [cId=" + cId + ", categoriesName=" + categoriesName + ", lastUpdatedDate=" + lastUpdatedDate
				+ ", createdDate=" + createdDate + "]";
	}

}
