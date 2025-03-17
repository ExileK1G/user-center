package com.yupi.usercenter;


import com.yupi.usercenter.model.domain.User;
import com.yupi.usercenter.service.UserService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testAddUser(){
        User user = new User();
        user.setUsername("dogYupi");
        user.setUserAccount("123");
        user.setAvatarUrl("https://www.baidu.com/img/flexible/logo/pc/peak-result.png");
        user.setGender(0);
        user.setUserPassword("xxx");
        user.setPhone("123");
        user.setEmail("456");

        boolean result = userService.save(user);
        System.out.println(user.getId());
        //断言，用来测试使用，看实际结果是否等于期望的结果，一般单元测试都需要加断言
        Assertions.assertTrue(result);
    }

    @Test
    void userRegister() {
        long result = userService.userRegister("dogYupi", "12345678", "12345678");
        result = userService.userRegister("qiuheng", "123", "123");
        Assertions.assertEquals(-1,result);
    }
}
