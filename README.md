# Spring_JPA_Security

### JPA INSERT 
```java 
    public void insert(HttpServletResponse response, User user) {
        // 아이디 체크
        Boolean checkUserId = userRepository.existsUserByUserId(user.getUserId());
        if(checkUserId == null) {
            JSUtil.alert_replace(response,"NULL 오류 발생","/user");
        } else if(!checkUserId) {
            BCryptPasswordEncoder PWEncoder = new BCryptPasswordEncoder();
            user.setUserPassword(PWEncoder.encode(user.getUserPassword()));
            userRepository.save(user);
            JSUtil.alert_replace(response,"저장되었습니다.","/user");
        } else {
            JSUtil.alert_replace(response,"해당 아이디는 존재합니다.","/user/signUp");
        }
    }
```

```

JPA :       Boolean checkUserId = userRepository.existsUserByUserId(user.getUserId());

MyBatis :   SELECT 
               *
            FROM USER
            WHERE USER_ID = #{user.getUserId()}
```


```
save() 와 persist() 차이 

  1. save() : 해당 Object를 return 

  2. persist() : return되는 값이 없음 
```
