package com.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_tbl")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String username;
    private String gender;
    private String email;
    private String userType;
    private String password;
    private Boolean isActive;
    private Date logInAt;
    private Date createdAt;
    private Date updatedAt;

    @PrePersist
    public void onSave(){
        Date currentDate =new Date();
        this.createdAt=currentDate;
        this.updatedAt=currentDate;
    }
    @PostPersist
            public void onUpdate() {

        Date currentDate = new Date();
        this.updatedAt = currentDate;
    }

}
