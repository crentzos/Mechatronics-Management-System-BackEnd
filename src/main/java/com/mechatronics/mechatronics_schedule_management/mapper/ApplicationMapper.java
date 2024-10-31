package com.mechatronics.mechatronics_schedule_management.mapper;

import com.mechatronics.mechatronics_schedule_management.dto.ApplicationDTO;
import com.mechatronics.mechatronics_schedule_management.entity.Application;
import org.mapstruct.factory.Mappers;

public interface ApplicationMapper {
    ApplicationMapper INSTANCE = Mappers.getMapper(ApplicationMapper.class);

    ApplicationDTO applicationToApplicationDTO(Application application);
    Application applicationDTOToApplication(ApplicationDTO applicationDTO);
}
