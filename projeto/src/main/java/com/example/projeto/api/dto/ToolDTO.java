package com.example.projeto.api.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.projeto.domain.entity.Tag;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ToolDTO implements Serializable{
	

	private static final long serialVersionUID = -1149606213822055866L;

	private Long idTool;

	private String title;
	
	private String link;
	
	private String description;
	
	private List<Tag> tags = new ArrayList<>();

}
