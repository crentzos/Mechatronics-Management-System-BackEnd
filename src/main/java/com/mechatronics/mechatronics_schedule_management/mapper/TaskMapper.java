package com.mechatronics.mechatronics_schedule_management.mapper;


import com.mechatronics.mechatronics_schedule_management.dto.TaskDTO;
import com.mechatronics.mechatronics_schedule_management.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDTO taskToTaskDTO(Task task);

    Task taskDTOToTask(TaskDTO taskDTO);

    void updateTaskFromDTO(TaskDTO taskDTO, @MappingTarget Task task);
}
