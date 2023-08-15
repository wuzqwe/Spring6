package com.szq.spring6;

import com.szq.spring6.bean.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring6.xml")
public class SpingJUnit5Test {

    @Autowired
    private User user;

    @Test
    void testUser() {
        System.out.println(user.getName());
    }
}
