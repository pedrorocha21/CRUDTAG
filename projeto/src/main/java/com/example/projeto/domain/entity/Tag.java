package com.example.projeto.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "tag")
public class Tag  implements Serializable {
	

	private static final long serialVersionUID = -5428637819510317267L;

	@Id
	@GeneratedValue
	@Column(name = "idTag")
	private Long idTag;

	@Column(name="name")
	private String name;

}
