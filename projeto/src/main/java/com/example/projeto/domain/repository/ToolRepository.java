package com.example.projeto.domain.repository;

import java.awt.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.projeto.domain.entity.Tool;

@Repository
public interface ToolRepository  extends CrudRepository<Tool, Long> {

	@Query(value = "select t from tool t join tool_tag tt on t.idTool = tt.idTool  join tag ta on tt.idTag = ta.idTag where ta.name = ? ", nativeQuery = true)
	List procura(String name);
	
}
