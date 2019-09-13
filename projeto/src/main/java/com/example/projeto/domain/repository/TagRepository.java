package com.example.projeto.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.projeto.domain.entity.Tag;
import com.example.projeto.domain.entity.Tool;

@Repository
public interface TagRepository  extends CrudRepository<Tag, Long> {

}
