package com.wong.demo.service;

import com.wong.demo.model.Feature;

public interface ManageUserAccessService {
    public Feature createFeature(String email, String featureName, boolean status);
    public Feature getFeature(String email, String featureName);
}
