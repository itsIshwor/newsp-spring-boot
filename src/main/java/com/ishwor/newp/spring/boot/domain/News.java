package com.ishwor.newp.spring.boot.domain;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author iupreti
 */

@Entity
@NamedQueries(value = { @NamedQuery(name = "findAllNews", query = "Select n from News n"),
		@NamedQuery(name = "findAllNewsDesc", query = "Select n from News n order by id desc") })
public class News {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer news_id;

	@NotNull(message = "title can't be null")
	@NotEmpty(message = "title can't be empty.")
	private String title;

	@Lob
	private String newsBody;

	@OneToOne(targetEntity = Categories.class, cascade = CascadeType.DETACH)
	@JoinColumn(name = "categories_id", referencedColumnName = "cId")
	private Categories categories;

	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdDate;

	

	public Integer getNews_id() {
		return news_id;
	}

	public void setNews_id(Integer news_id) {
		this.news_id = news_id;
	}

	

	public News() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNewsBody() {
		return newsBody;
	}

	public void setNewsBody(String newsBody) {
		this.newsBody = newsBody;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public LocalDateTime getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getId() {
		return news_id;
	}

	public void setId(Integer id) {
		this.news_id = id;
	}

	public News(Integer id,
			@NotNull(message = "title can't be null") @NotEmpty(message = "title can't be empty.") String title,
			String newsBody, Categories categories, LocalDateTime lastUpdatedDate, LocalDateTime createdDate) {
		this.news_id = id;
		this.title = title;
		this.newsBody = newsBody;
		this.categories = categories;
		this.lastUpdatedDate = lastUpdatedDate;
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "News [id=" + news_id + ", title=" + title + ", newsBody=" + newsBody + ", categories=" + categories
				+ ", lastUpdatedDate=" + lastUpdatedDate + ", createdDate=" + createdDate + "]";
	}

}
