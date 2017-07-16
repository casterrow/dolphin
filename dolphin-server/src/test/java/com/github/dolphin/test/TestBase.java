package com.github.dolphin.test;

import com.github.dolphin.DolphinServer;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Test template for all test cases, default active profile.
 * By default, the application is started with 'prod' profile.
 * @author Stephen Liu
 * @since 2017/3/25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DolphinServer.class)
@ActiveProfiles("dev")
public class TestBase {


}
