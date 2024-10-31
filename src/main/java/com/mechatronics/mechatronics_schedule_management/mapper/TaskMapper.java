package com.mechatronics.mechatronics_schedule_management.mapper;

import com.mechatronics.mechatronics_schedule_management.dto.TaskDTO;
import com.mechatronics.mechatronics_schedule_management.entity.Task;
import org.mapstruct.factory.Mappers;

public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskDTO taskToTaskDTO(Task task);
    Task taskDTOToTask(TaskDTO taskDTO);

}
