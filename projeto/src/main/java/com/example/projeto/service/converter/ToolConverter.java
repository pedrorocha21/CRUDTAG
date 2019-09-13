package com.example.projeto.service.converter;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.example.projeto.api.dto.ToolDTO;
import com.example.projeto.domain.entity.Tool;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Component
public class ToolConverter {
	
	MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();
	MapperFacade mapper;
	public ToolConverter() {
		
		mapperFactory.classMap(Tool.class, ToolDTO.class).byDefault().register();
		
		mapper = mapperFactory.getMapperFacade();
		
	}
	
	public ToolDTO convertFrom(Tool tool) {
		return mapper.map(tool, ToolDTO.class);
	}
	
	public Tool convertTo(ToolDTO toolDTO) {
		return mapper.map(toolDTO, Tool.class);
	}
	
	public ArrayList<Tool> convertAllTo(ArrayList<ToolDTO> toolDTO) {
		return (ArrayList<Tool>) mapper.mapAsList(toolDTO, Tool.class);
	}
	
	public ArrayList<ToolDTO> convertAllFrom(ArrayList<Tool> tool) {
		return (ArrayList<ToolDTO>)mapper.mapAsList(tool, ToolDTO.class);
	}
	

}
