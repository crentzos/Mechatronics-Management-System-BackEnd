package com.mechatronics.mechatronics_schedule_management.mapper;

import com.mechatronics.mechatronics_schedule_management.dto.TaskDTO;
import com.mechatronics.mechatronics_schedule_management.entity.Task;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDTO taskToTaskDTO(Task task);

    Task taskDTOToTask(TaskDTO taskDTO);

}
