package com.security.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.doosan.dls.common.JSUtil;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> selectUser(User user) {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    public void insert(HttpServletResponse response, User user) {
        User checkUserId = userRepository.findAllByUserId(user.getUserId());
        if(checkUserId == null) {
            JSUtil.alert_replace(response,"NULL오류 발생","/user");
        } else if(checkUserId.getUserId().equals(user.getUserId())) {
            BCryptPasswordEncoder PWEncoder = new BCryptPasswordEncoder();
            user.setUserPassword(PWEncoder.encode(user.getUserPassword()));
            userRepository.save(user);
        } else {
            JSUtil.alert_replace(response,"해당 아이디는 존재합니다.","/user/signUp");
        }
    }

}
