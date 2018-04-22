package xhu.wncg.firesystem.modules.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import xhu.wncg.FireSystemApplication;
import xhu.wncg.firesystem.modules.controller.qo.UnitQO;
import xhu.wncg.firesystem.modules.pojo.Unit;
import xhu.wncg.firesystem.modules.service.UnitService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author jing
 * @version 2017/11/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FireSystemApplication.class)
@WebAppConfiguration
@ActiveProfiles("dev")
public class UnitServiceImplTest {
    @Autowired
    UnitService unitService;

    @Test
    public void queryCount() throws Exception {
        UnitQO params=new UnitQO();
        params.setCountKeys(null);
        params.setStartTime("2017-09-19 00:11:00");
        params.setEndTime("2017-09-19 23:29:00");
        System.out.println(unitService.queryCount(params));
    }

    @Test
    public void queryById() throws Exception {
        int countId=1;
        unitService.queryById(countId);
    }

}