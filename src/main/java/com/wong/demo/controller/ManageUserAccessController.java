package com.wong.demo.controller;

import com.wong.demo.model.Feature;
import com.wong.demo.service.ManageUserAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
public class ManageUserAccessController {

    @Autowired
    ManageUserAccessService manageUserAccessService;

    @PostMapping(path="/create")
    public ResponseEntity addEmployee(@RequestBody Feature feature){


        Feature result = manageUserAccessService.createFeature(feature.getFeatureName(),feature.getEmail(),feature.getEnable());

        if(result != null) {
            return ResponseEntity.ok().build();
        }
        else
        {
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/feature")
    public ResponseEntity<Feature> getUserAccessStatus(@RequestParam String email, @RequestParam String featureName) {

        Feature result = manageUserAccessService.getFeature(email,featureName);

        if(result != null) {
            return ResponseEntity.ok().body(result);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }

    }
}
