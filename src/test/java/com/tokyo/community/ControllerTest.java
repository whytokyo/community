package com.tokyo.community;

import com.tokyo.community.dao.DiscussPostMapper;
import com.tokyo.community.dao.UserMapper;
import com.tokyo.community.entity.DiscussPost;
import com.tokyo.community.entity.User;
import com.tokyo.community.service.DiscussPostService;
import com.tokyo.community.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)

public class ControllerTest {

    @Autowired
    private UserService userService;

    @Autowired
    private DiscussPostService discussPostService;

    @Test
    public void test1() {

        List<DiscussPost> list = discussPostService.findDiscussPosts(0, 0, 10);
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        if (list != null) {
            for (DiscussPost post : list) {
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);
                User user = userService.findUserById(post.getUserId());
                map.put("user", user);
                discussPosts.add(map);
            }
        }
        System.out.println(discussPosts);

    }

    @Test
    public void test2() {
        int a = 1;
        char ch = '2';
        if (a > ch) {
            System.out.println("111");
        } else if (a < ch) {
            System.out.println("222");
        } else {
            System.out.println("333");
        }
    }

}
