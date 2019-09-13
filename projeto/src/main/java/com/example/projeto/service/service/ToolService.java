package com.example.projeto.service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.projeto.api.dto.TagDTO;
import com.example.projeto.api.dto.ToolDTO;
import com.example.projeto.domain.entity.Tag;
import com.example.projeto.domain.entity.Tool;
import com.example.projeto.domain.repository.TagRepository;
import com.example.projeto.domain.repository.ToolRepository;
import com.example.projeto.service.converter.TagConverter;
import com.example.projeto.service.converter.ToolConverter;



@Service
public class ToolService {

		@Autowired
		ToolRepository toolRepository;
		
		@Autowired
		TagRepository tagRepository;
		
		@Autowired
		TagConverter tagConverter;
		
		@Autowired
		ToolConverter toolConverter;
		


	    public List<ToolDTO> getAll() {
	        List<Tool> tools = (List<Tool>) toolRepository.findAll();
	        List<ToolDTO> dtos = tools.stream().map(s -> toolConverter.convertFrom(s))
					.collect(Collectors.toList());
	        
	        return dtos;
	    }
	    
	    public List<TagDTO> getAllTag() {
	        List<Tag> tags = (List<Tag>) tagRepository.findAll();
	        List<TagDTO> dtos = tags.stream().map(s -> tagConverter.convertFrom(s))
					.collect(Collectors.toList());
	        
	        return dtos;
	    }

	    public ToolDTO getById(Long id) {
	        Tool tag = new Tool();
	        ToolDTO dto = null;
	        try {
		       dto = toolConverter.convertFrom(toolRepository.findById(id).get());
	    	}catch(Exception e) {
	    		//Gerar Log de Erro;
	    	}
	        return dto;
	    }

	    public void saveOrUpdate(ToolDTO tool) {
	    	try {
		    	toolRepository.save(toolConverter.convertTo(tool));
	    	}catch(Exception e) {
	    		//Gerar Log de Erro;
	    	}
	    }
	    
	    public void saveOrUpdateTag(TagDTO tag) {
	    	try {
		    	tagRepository.save(tagConverter.convertTo(tag));
	    	}catch(Exception e) {
	    		//Gerar Log de Erro;
	    	}
	    }


	    public void delete(Long id) {
	    	try {
		    	toolRepository.deleteById(id);
	    	}catch(Exception e) {
	    		//Gerar Log de Erro;
	    	}
	    }
	    
	    public List<ToolDTO> procurar(String name) {
	    	 List<Tool> tools = null;
	    	 List<ToolDTO> toolsDTO = null;

	    	try {
	    		tools = (List<Tool>) toolRepository.procura(name);
	    		toolsDTO = toolConverter.convertAllFrom((ArrayList<Tool>) tools);
	    	}catch(Exception e) {
	    		//Gerar Log de Erro;
	    	}
	    	return toolsDTO;
	    }
	    
	  
	

}
