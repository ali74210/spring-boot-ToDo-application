package com.sat.springboottodoapplication.service.mapper;

import com.sat.springboottodoapplication.DAO.model.Task;
import com.sat.springboottodoapplication.service.DTO.TaskDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, UserMapper.class})
public interface TaskMapper {
//    @Mapping(target = "title", source = "title")
//    @Mapping(target = "author", source = "author")
    TaskDTO toDto(Task task);
    @InheritInverseConfiguration
    Task toEntity(TaskDTO taskDTO);
}

