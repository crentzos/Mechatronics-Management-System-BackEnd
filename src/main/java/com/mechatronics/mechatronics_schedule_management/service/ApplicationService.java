package com.mechatronics.mechatronics_schedule_management.service;

import com.mechatronics.mechatronics_schedule_management.dao.ApplicationRepository;
import com.mechatronics.mechatronics_schedule_management.dto.ApplicationDTO;
import com.mechatronics.mechatronics_schedule_management.entity.Application;
import com.mechatronics.mechatronics_schedule_management.mapper.ApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApplicationService {
    public final ApplicationRepository applicationRepository;
    public final ApplicationMapper applicationMapper;

    @Autowired
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
            throw new RuntimeException("Error creating application: " + e.getMessage());
        }
    }

    public List<ApplicationDTO> getAllApplications() {
        try {
            return applicationRepository.findAll().stream().map(applicationMapper::applicationToApplicationDTO).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error getting applications: " + e.getMessage());
        }
    }

    public ApplicationDTO getApplicationById(Long id) {
        try {
            Optional<Application> applicationOptional = applicationRepository.findById(id);
            return applicationOptional.map(applicationMapper::applicationToApplicationDTO).orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Error getting application: " + e.getMessage());
        }
    }

    public ApplicationDTO updateApplication(Long id, ApplicationDTO applicationDTO) {
        try {
            if (applicationRepository.existsById(id)) {
                Application application = applicationMapper.applicationDTOToApplication(applicationDTO);
                application.setId(id);
                Application updatedApplication = applicationRepository.save(application);
                return applicationMapper.applicationToApplicationDTO(updatedApplication);
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Error updating application: " + e.getMessage());
        }
    }

    public void deleteApplication(Long id) {
        try{
            if (applicationRepository.existsById(id)) {
                applicationRepository.deleteById(id);
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException("Error deleting application: " + e.getMessage());
        }
    }
}
