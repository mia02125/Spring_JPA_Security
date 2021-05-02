package com.security.demo.user;

import com.sun.org.apache.xpath.internal.operations.Bool;
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
        // 아이디 체크
        Boolean checkUserId = userRepository.existsUserByUserId(user.getUserId());
        if(checkUserId == null) {
            JSUtil.alert_replace(response,"오류 발생 / 오류 사유 : 데이터 NULL","/user");
        } else if(!checkUserId) {
            BCryptPasswordEncoder PWEncoder = new BCryptPasswordEncoder();
            user.setUserPassword(PWEncoder.encode(user.getUserPassword()));
            userRepository.save(user);
            JSUtil.alert_replace(response,"저장되었습니다.","/user");
        } else {
            JSUtil.alert_replace(response,"해당 아이디는 존재합니다.","/user/signUp");
        }
    }

}
