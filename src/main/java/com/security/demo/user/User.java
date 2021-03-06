package com.security.demo.user;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user")
@NoArgsConstructor // 파라미터가 없는 생성자 | 출처 : https://dingue.tistory.com/14
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 생성을 DB에 위임
    @Column(name = "user_idx")
    private Long userIdx;
    @Column(name = "user_name", length = 10, nullable = false)
    private String userName;
    @Column(name = "user_id", length = 30, nullable = false, unique = true)
    private String userId;
    @Column(name = "user_password", length = 30, nullable = false)
    private String userPassword;

    @Builder
    public User(String userName, String userId, String userPassword) {
        this.userName = userName;
        this.userId = userId;
        this.userPassword = userPassword;
    }


}
