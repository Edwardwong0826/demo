package com.wong.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="userinfo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="email")
    private String email;


    @Column(name = "feature_name")
    private String featureName;


    @Column(name="enable")
    private Boolean enable;

    public Feature(String featureName, String email, Boolean status)
    {
        this.featureName = featureName;
        this.email = email;
        this.enable = status;
    }

}
