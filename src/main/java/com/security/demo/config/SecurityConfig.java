package com.security.demo.config;

import com.security.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity // 스프링 활성화
// [출처] 시큐리티 설정 :  https://bamdule.tistory.com/53
// [출처] 시큐리티 + JPA : https://victorydntmd.tistory.com/328
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    /**
     * 비밀번호 복호화/암호화하는 로직이 담긴 객체를 Bean으로 등록
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    /**
     * FilterChainProxy를 생성하는 필터
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        // 해당 요청은 인증 대상에서 제외
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
    }

    /**
     * authenticated() : 인증된 유저만 접근 허용
     * permitAll() : 모든 유저 접근 허용
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * HTTP요청에 대한 보안 설정
         */
        http.authorizeRequests()
//                .antMatchers("/**").authenticated()
                .antMatchers("/**").permitAll();

        http.formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .permitAll();
        /**
         * invalidateHttpSession(true/false) : 로그아웃 시 세션 제거
         */
        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true);
        /**
         * 권한이 없는 사용자가 접근했을 경우 이동할 경로를 지정
         */
        http.exceptionHandling()
                .accessDeniedPage("/denied");
    }

}
