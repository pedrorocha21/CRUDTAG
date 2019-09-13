package com.example.projeto.api.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TagDTO implements Serializable{
	

	private static final long serialVersionUID = 9213651667527905428L;

	private Long idTag;

	private String name;
	


}
