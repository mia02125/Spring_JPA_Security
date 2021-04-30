package com.security.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 생성을 DB에 위임
    @Column(name = "user_idx")
    private Long userIdx;
    @Column(name = "user_name", length = 10, nullable = false)
    private String userName;
    @Column(name = "user_email", length = 30, nullable = false)
    private String userEmail;
    @Column(name = "user_password", length = 30, nullable = false)
    private String userPassword;



}
