package com.jash.service;

import com.jash.dlo.CategoryDTO;
import com.jash.dlo.SalonDTO;
import com.jash.dlo.ServiceDTO;
import com.jash.modal.ServiceOffering;

import java.util.Set;

public interface ServiceOfferingService {

    ServiceOffering createService(SalonDTO salonDTO,
                                         ServiceDTO serviceDTO,
                                         CategoryDTO categoryDTO);

    ServiceOffering updateService(Long serviceId, ServiceOffering service) throws Exception;
    Set<ServiceOffering> getAllServiceBySalonId(Long salonId, Long categoryId);
    Set<ServiceOffering> getServiceByIds(Set<Long> ids);

    ServiceOffering getServiceById(Long id) throws Exception;

}
