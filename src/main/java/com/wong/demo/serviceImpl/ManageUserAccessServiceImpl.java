package com.wong.demo.serviceImpl;

import com.wong.demo.model.Feature;
import com.wong.demo.repository.ManageUserAccessRepository;
import com.wong.demo.service.ManageUserAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageUserAccessServiceImpl implements ManageUserAccessService {

    @Autowired
    ManageUserAccessRepository manageUserAccessRepository;

    @Override
    public Feature createFeature(String email, String featureName, boolean status) {

        return manageUserAccessRepository.save(new Feature(email,featureName,status));
    }

    @Override
    public Feature getFeature(String email, String featureName) {
        return manageUserAccessRepository.findByEmailAndFeatureName(email,featureName);

    }
}
