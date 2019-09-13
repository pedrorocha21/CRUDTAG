package com.example.projeto.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tool")
@Data
public class Tool implements Serializable{
	
	
	private static final long serialVersionUID = -3986956404035380143L;

	@Id
	@GeneratedValue
	@Column(name = "idTool")
	private Long idTool;

	@Column(name="title")
	private String title;
	
	@Column(name="link")
	private String link;
	
	@Column(name="description")
	private String description;
	
//	@OneToMany(cascade = CascadeType.ALL,
//	        orphanRemoval = true
//	    )
	
	 @ManyToMany
	 @JoinTable(name="tool_tag", joinColumns=
 {@JoinColumn(name="idTool")}, inverseJoinColumns=
   {@JoinColumn(name="idTag")})
	private List<Tag> tags = new ArrayList<>();
	
	

}
