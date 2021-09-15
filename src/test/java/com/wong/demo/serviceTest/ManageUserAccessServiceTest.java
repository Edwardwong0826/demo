package com.wong.demo.serviceTest;

import com.wong.demo.model.Feature;
import com.wong.demo.repository.ManageUserAccessRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ManageUserAccessServiceTest {

    @Mock
    private ManageUserAccessRepository manageUserAccessRepository;

    @Test
    public void testSuccessGetFeature(){
        Feature feature = new Feature("Wong","xxx@gamil.com",true);

        Mockito.when(manageUserAccessRepository.findByEmailAndFeatureName(any(),any())).thenReturn(feature);
        Feature result = manageUserAccessRepository.findByEmailAndFeatureName("xxx@gmail.com","Wong");
        assertEquals(feature, result);

    }

}
