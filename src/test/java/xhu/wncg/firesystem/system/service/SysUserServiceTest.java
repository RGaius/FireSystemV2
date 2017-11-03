package xhu.wncg.firesystem.system.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import xhu.wncg.FireSystemApplication;
import xhu.wncg.firesystem.system.pojo.SysUser;

import static org.junit.Assert.*;

/**
 * @author BZhao
 * @version 2017/11/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FireSystemApplication.class)
@WebAppConfiguration
@ActiveProfiles("dev")
public class SysUserServiceTest {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 用户查询
     * @throws Exception
     */
    @Test
    public void queryByUsername() throws Exception {
        SysUser user = sysUserService.queryByUsername("admin");
        System.out.println(user.toString());
    }

}