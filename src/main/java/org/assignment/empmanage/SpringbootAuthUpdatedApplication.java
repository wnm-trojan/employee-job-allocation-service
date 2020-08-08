/*
"""
    @author - Waruna Nissanka
    @email - warunanissanka44@gmail.com
    @project - Job Allowcation API Service

    @Description - BCrypt Password Encoder
"""
*/

package org.assignment.empmanage;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringbootAuthUpdatedApplication {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
