package com.gestor.gestortareasbackend.model.project.dto;

import com.gestor.gestortareasbackend.model.project.Project;
import com.gestor.gestortareasbackend.model.task.Task;
import com.gestor.gestortareasbackend.model.tag.Tag;
import com.gestor.gestortareasbackend.model.tag.dto.ResponseTag;
import com.gestor.gestortareasbackend.model.task.dto.ResponseTask;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ProjectResponseMapper {

    ProjectResponseMapper INSTANCE = Mappers.getMapper(ProjectResponseMapper.class);

   // @Mapping(source = "user", target = "members")
   // @Mapping(source = "tasks", target = "tasks")
    ResponseProject projectToResponseProject(Project project);

    default Set<ResponseTask> mapTasksToResponseTasks(Set<Task> tasks) {
        if (tasks == null) {
            return null;
        }
        return tasks.stream()
                .map(task -> ResponseTask.builder()
                        .id(task.getId())
                        .name(task.getName())
                        .tags(mapTagsToResponseTags(task.getTags()))
                        .build())
                .collect(Collectors.toSet());
    }

    default Set<ResponseTag> mapTagsToResponseTags(Set<Tag> tags) {
        if (tags == null) {
            return null;
        }
        return tags.stream()
                .map(tag -> ResponseTag.builder()
                        .id(tag.getId())
                        .name(tag.getName())
                        .build())
                .collect(Collectors.toSet());
    }
}
