package com.mechatronics.mechatronics_schedule_management.service;

import com.mechatronics.mechatronics_schedule_management.dao.ApplicationRepository;
import com.mechatronics.mechatronics_schedule_management.dto.ApplicationDTO;
import com.mechatronics.mechatronics_schedule_management.entity.Application;
import com.mechatronics.mechatronics_schedule_management.mapper.ApplicationMapper;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {
    public final ApplicationRepository applicationRepository;
    public final ApplicationMapper applicationMapper;

    public ApplicationService(ApplicationRepository applicationRepository, ApplicationMapper applicationMapper) {
        this.applicationRepository = applicationRepository;
        this.applicationMapper = applicationMapper;
    }

    public ApplicationDTO createApplication(ApplicationDTO applicationDTO) {
        try {
            Application application = applicationMapper.applicationDTOToApplication(applicationDTO);
            Application createdApplication = applicationRepository.save(application);
            return applicationMapper.applicationToApplicationDTO(createdApplication);
        } catch (Exception e) {
            throw new Exception("")
        }
    }
}
