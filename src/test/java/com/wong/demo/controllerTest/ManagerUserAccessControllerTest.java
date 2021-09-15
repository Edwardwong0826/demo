package com.wong.demo.controllerTest;

import com.wong.demo.controller.ManageUserAccessController;
import com.wong.demo.dto.FeatureDTO;
import com.wong.demo.model.Feature;
import com.wong.demo.serviceImpl.ManageUserAccessServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class ManagerUserAccessControllerTest {

    @InjectMocks
    @Autowired
    private ManageUserAccessController manageUserAccessController;

    @Mock
    private ManageUserAccessServiceImpl mockServiceImpl;

    @Test
    public void testSuccessGetFeature(){

        Feature feature = new Feature("Wong","xxx@gmail.com",true);
        FeatureDTO featureDTO = new FeatureDTO(feature.getEnable());
        Mockito.when(mockServiceImpl.getFeature(any(),any())).thenReturn(feature);
        ResponseEntity<FeatureDTO> testResponse = manageUserAccessController.getUserAccessStatus("xxx@gmail.com","Wong");
        assertEquals(HttpStatus.OK,testResponse.getStatusCode());
        assertEquals(featureDTO,testResponse.getBody());

    }

    @Test
    public void testSuccessCreateFeature(){

        Feature feature = new Feature("Wong","xxx@gmail.com",true);
        Mockito.when(mockServiceImpl.createFeature(any(),any(),anyBoolean())).thenReturn(feature);
        ResponseEntity<Feature> testResponse = manageUserAccessController.createUserInfo(feature);
        assertEquals(HttpStatus.OK,testResponse.getStatusCode());

    }
}
