package com.mechatronics.mechatronics_schedule_management.service;

import com.mechatronics.mechatronics_schedule_management.dao.TaskRepository;
import com.mechatronics.mechatronics_schedule_management.dto.TaskDTO;
import com.mechatronics.mechatronics_schedule_management.entity.Task;
import com.mechatronics.mechatronics_schedule_management.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Autowired
    public TaskService(TaskMapper taskMapper, TaskRepository taskRepository) {
        this.taskMapper = taskMapper;
        this.taskRepository = taskRepository;
    }


    public TaskDTO createTask(TaskDTO taskDTO) {
        try{
            Task task = taskMapper.taskDTOToTask(taskDTO);
            Task createdTask = taskRepository.save(task);

            return taskMapper.taskToTaskDTO(createdTask);
        } catch (Exception e) {
            throw new RuntimeException("Task could not be created: " + e.getMessage(), e);
        }
    }

    public List<TaskDTO> getAllTasks() {
        try {
            return taskRepository.findAll().stream().map(taskMapper::taskToTaskDTO).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Could not retrieve all tasks: " + e.getMessage(), e);
        }
    }

    public TaskDTO getTaskById(Long id) {
        try {
            Optional<Task> taskOptional = taskRepository.findById(id);
            return taskOptional.map(taskMapper::taskToTaskDTO).orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Could not retrieve task by id: " + e.getMessage(), e);
        }
    }

    public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
        try {
            if (taskRepository.existsById(id)) {
                Task task = taskMapper.taskDTOToTask(taskDTO);
                taskMapper.updateTaskFromDTO(taskDTO, task);
                Task updatedTask = taskRepository.save(task);
                return taskMapper.taskToTaskDTO(updatedTask);
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Could not update task by id: " + e.getMessage(), e);
        }
    }

    public boolean deleteTask(Long id) {
        try {
            if (taskRepository.existsById(id)) {
                taskRepository.deleteById(id);
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException("Could not delete task by id: " + e.getMessage(), e);
        }
    }
}
