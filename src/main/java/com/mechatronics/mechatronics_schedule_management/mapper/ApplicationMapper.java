package com.mechatronics.mechatronics_schedule_management.mapper;

import com.mechatronics.mechatronics_schedule_management.dto.ApplicationDTO;
import com.mechatronics.mechatronics_schedule_management.entity.Application;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ApplicationMapper {

    ApplicationDTO applicationToApplicationDTO(Application application);
    Application applicationDTOToApplication(ApplicationDTO applicationDTO);
}
