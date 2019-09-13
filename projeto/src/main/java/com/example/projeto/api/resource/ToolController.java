package com.example.projeto.api.resource;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.projeto.api.dto.TagDTO;
import com.example.projeto.api.dto.ToolDTO;
import com.example.projeto.domain.entity.Tag;
import com.example.projeto.domain.entity.Tool;
import com.example.projeto.service.service.ToolService;


@RestController
public class ToolController {
	
	@Autowired
    ToolService toolService;

    @GetMapping("/tools")
    private List<ToolDTO> getAllTools() {
        return toolService.getAll();
    }
    
    @GetMapping("/procurar/{name}")
    private List<ToolDTO> procurar(@PathVariable("name") String name)  {
        return toolService.procurar(name);
    }
    
    @GetMapping("/tags")
    private List<TagDTO> getAllTag() {
        return toolService.getAllTag();
    }

    @GetMapping("/tool/{id}")
    private ToolDTO getTool(@PathVariable("id") Long id) {
        return toolService.getById(id);
    }

    @DeleteMapping("/tool/{id}")
    private void deleteTool(@PathVariable("id") Long id) {
    	toolService.delete(id);
    }

    @PostMapping("/tool")
    private ToolDTO saveTool(@RequestBody ToolDTO tool) {
    	toolService.saveOrUpdate(tool);
        return tool;
    }
    
    @PostMapping("/tag")
    private TagDTO saveTag(@RequestBody TagDTO tag) {
    	toolService.saveOrUpdateTag(tag);
        return tag;
    }
	
	
}
