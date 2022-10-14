package com.tokyo.community;

import com.tokyo.community.dao.DiscussPostMapper;
import com.tokyo.community.dao.UserMapper;
import com.tokyo.community.entity.DiscussPost;
import com.tokyo.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectUser() {
        User user = userMapper.selectById(101);
        System.out.println(user);
        user = userMapper.selectByName("liubei");
        System.out.println(user);
    }

    @Test
    public void testSelectPosts() {
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0,0, 10);
        for (DiscussPost discussPost : list) {
            System.out.println(discussPost);
        }
        int res = discussPostMapper.selectDiscussPostsRows(149);
        System.out.println(res);
    }

}
