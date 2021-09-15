package com.wong.demo.controller;

import com.wong.demo.dto.FeatureDTO;
import com.wong.demo.model.Feature;
import com.wong.demo.service.ManageUserAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// the data will save into h2 memory database, after start the spring boot application can view by http://localhost:8080/h2-console
@RequestMapping("/feature")
@RestController
public class ManageUserAccessController {

    @Autowired
    ManageUserAccessService manageUserAccessService;

    @PostMapping
    public ResponseEntity createUserInfo(@RequestBody Feature feature){


        Feature result = manageUserAccessService.createFeature(feature.getFeatureName(),feature.getEmail(),feature.getEnable());

        if(result != null) {
            return ResponseEntity.ok().build();
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
    }

    @GetMapping
    public ResponseEntity<FeatureDTO> getUserAccessStatus(@RequestParam String email, @RequestParam String featureName) {

        Feature result = manageUserAccessService.getFeature(email,featureName);

        if(result != null) {
            FeatureDTO dto = new FeatureDTO(result.getEnable());
            return ResponseEntity.ok().body(dto);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }

    }
}
