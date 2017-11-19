package xhu.wncg.firesystem.modules.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import xhu.wncg.FireSystemApplication;
import xhu.wncg.firesystem.modules.controller.vo.UnitVO;
import xhu.wncg.firesystem.modules.pojo.Unit;

import java.util.List;

/**
 * @author BZhao
 * @version 2017/11/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FireSystemApplication.class)
@WebAppConfiguration
@ActiveProfiles("dev")
public class UnitServiceTest {
    @Autowired
    private UnitService unitService;

    /**
     * 场所统计
     *
     * @throws Exception
     */
    @Test
    public void count() throws Exception {
        List<UnitVO> list = unitService.count(null);
        for (UnitVO o : list) {
            System.out.println(o.toString());
        }

    }

}