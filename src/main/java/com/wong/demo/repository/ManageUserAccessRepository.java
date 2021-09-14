package com.wong.demo.repository;

import com.wong.demo.model.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManageUserAccessRepository extends JpaRepository<Feature,Long> {
    Feature findByEmailAndFeatureName(String email, String featureName);
}
