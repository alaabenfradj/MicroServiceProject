package com.esprit.microservices.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Event implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7291192279156300175L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String title ;
	private String description ;
	@Enumerated(EnumType.STRING)
	private EventType type ;
	@DateTimeFormat(pattern = "dd-MM-yyy")
	private Date eventDate ;
	private String owner;
	 @Column
	 @ElementCollection(targetClass=String.class)
	private List<String> reclamations =new ArrayList<>();
}
