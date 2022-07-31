package com.mengzhiayuan.naruto.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vip.acheng.sea.util.SensitiveFilter;

/**
 * @Author: 清风徐来
 * @Date: 2021/8/27 20:02
 * @Description:
 */

@SpringBootTest
class SensitiveFilterTest {

    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Test
    public void testSensitiveFilter() {
        String text = "罗威你个大沙比!";
        text = sensitiveFilter.filter(text);
        System.out.println(text);

        text = "罗威你个大☆傻☆☆逼,哈哈哈!";
        text = sensitiveFilter.filter(text);
        System.out.println(text);
    }
}