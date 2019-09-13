package com.example.projeto.service.converter;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.example.projeto.api.dto.TagDTO;
import com.example.projeto.api.dto.ToolDTO;
import com.example.projeto.domain.entity.Tag;
import com.example.projeto.domain.entity.Tool;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Component
public class TagConverter {
	
	MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();
	MapperFacade mapper;
	public TagConverter() {
		
		mapperFactory.classMap(Tag.class, TagDTO.class).byDefault().register();
		
		mapper = mapperFactory.getMapperFacade();
		
	}
	
	public TagDTO convertFrom(Tag tag) {
		return mapper.map(tag, TagDTO.class);
	}
	
	public Tag convertTo(TagDTO tagDTO) {
		return mapper.map(tagDTO, Tag.class);
	}
	
	public ArrayList<Tag> convertAllTo(ArrayList<TagDTO> tagDTO) {
		return (ArrayList<Tag>) mapper.mapAsList(tagDTO, Tag.class);
	}
	
	public ArrayList<TagDTO> convertAllFrom(ArrayList<Tag> tag) {
		return (ArrayList<TagDTO>)mapper.mapAsList(tag, TagDTO.class);
	}

}
