package xhu.wncg.firesystem.system.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import xhu.wncg.FireSystemApplication;
import xhu.wncg.firesystem.system.pojo.SysMenu;

import static org.junit.Assert.*;

/**
 * @author BZhao
 * @version 2017/11/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FireSystemApplication.class)
@WebAppConfiguration
@ActiveProfiles("dev")
public class SysMenuServiceTest {
    @Autowired
    private SysMenuService sysMenuService;

    @Test
    public void queryListParentId() throws Exception {
    }

    @Test
    public void queryListParentId1() throws Exception {
    }

    @Test
    public void queryNotButtonList() throws Exception {
    }

    @Test
    public void getUserMenuList() throws Exception {
    }

    @Test
    public void queryObject() throws Exception {
    }

    @Test
    public void queryList() throws Exception {
    }

    @Test
    public void queryTotal() throws Exception {
    }

    /**
     * 保存菜单
     * @throws Exception
     */
    @Test
    public void save() throws Exception {
        SysMenu menu = new SysMenu();
        menu.setParentId(0L);
        menu.setName("测试数据");
        menu.setType(0);
        menu.setOrderNum(0);
        sysMenuService.save(menu);
    }

    /**
     * 更新菜单
     * @throws Exception
     */
    @Test
    public void update() throws Exception {
        SysMenu menu = new SysMenu();
        menu.setMenuId(49L);
        menu.setName("测试更新");
        sysMenuService.update(menu);
    }

    @Test
    public void deleteBatch() throws Exception {
    }

    @Test
    public void queryUserList() throws Exception {
    }

}