package com.jash.controller;

import com.jash.dlo.CategoryDTO;
import com.jash.dlo.SalonDTO;
import com.jash.dlo.ServiceDTO;
import com.jash.modal.ServiceOffering;
import com.jash.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/service-offering/salon-owner")
public class SalonServiceOfferingController {
    private final ServiceOfferingService serviceOfferingService;

    @PostMapping
    public ResponseEntity<ServiceOffering> createService(
            @RequestBody ServiceDTO serviceDTO
    ){

        SalonDTO salonDTO=new SalonDTO();
        salonDTO.setId(1L);

        CategoryDTO categoryDTO=new CategoryDTO();
        categoryDTO.setId(serviceDTO.getCategory());

        ServiceOffering serviceOfferings=serviceOfferingService
                .createService(salonDTO,serviceDTO,categoryDTO);
        return ResponseEntity.ok(serviceOfferings);


    }

    //update service

    @PostMapping("/{id}")
    public ResponseEntity<ServiceOffering> updateService(
            @RequestBody Long id,
            @RequestBody ServiceOffering serviceOffering
    ) throws Exception {

        SalonDTO salonDTO=new SalonDTO();
        salonDTO.setId(1L);

        CategoryDTO categoryDTO=new CategoryDTO();
        categoryDTO.setId(1L);

        ServiceOffering serviceOfferings=serviceOfferingService
                .updateService(id,serviceOffering);
        return ResponseEntity.ok(serviceOfferings);


    }

}
