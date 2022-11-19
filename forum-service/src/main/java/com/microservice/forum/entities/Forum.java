package com.microservice.forum.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Forum implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String topic;
	@Enumerated(EnumType.STRING)
	private ForumType type;
	@CreationTimestamp
	private Date created;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private String createdBy;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "forum")
	private List<Post> posts;
}
