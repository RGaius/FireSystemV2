package xhu.wncg.firesystem.modules.controller;

import com.beust.jcommander.internal.Maps;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import xhu.wncg.firesystem.modules.controller.vo.DailyTableVO;
import xhu.wncg.firesystem.modules.controller.qo.DailyTableQO;
import xhu.wncg.firesystem.modules.pojo.DailyTable;
import xhu.wncg.firesystem.modules.pojo.PoliceCheckSum;
import xhu.wncg.firesystem.modules.service.DailyTableService;
import xhu.wncg.common.utils.PageUtils;
import xhu.wncg.common.utils.Query;
import xhu.wncg.common.utils.Fire;
import xhu.wncg.firesystem.modules.service.PictureService;
import xhu.wncg.firesystem.modules.service.UnitService;

/**
 * 日常检查表
 *
 * @author zhaobo
 * @version 2017-11-02 15:58:16
 * @email 15528330581@163.com
 */
@RestController
@RequestMapping("/fire/dailytable")
public class DailyTableController {
    @Autowired
    private DailyTableService dailyTableService;

    /**
     * 列表
     *
     * @param params
     * @return Fire
     */
    @GetMapping("/list")
    @RequiresPermissions("fire:dailytable:list")
    public Fire list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<DailyTableVO> dailyTableList = dailyTableService.queryList(query);
        int total = dailyTableService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(dailyTableList, total, query.getLimit(), query.getPage());

        return Fire.ok().put("page", pageUtil);
    }


    /**
     * 信息
     *
     * @param dailyTableId
     * @return Fire
     */
    @GetMapping("/info/{dailyTableId}")
    @RequiresPermissions("fire:dailytable:info")
    public Fire info(@PathVariable("dailyTableId") Integer dailyTableId) {
        DailyTableVO dailyTable = dailyTableService.queryObject(dailyTableId);

        return Fire.ok().put("dailyTable", dailyTable);
    }

    /**
     * 保存
     *
     * @param dailyTable
     * @return Fire
     */
    @PostMapping("/save")
    @RequiresPermissions("fire:dailytable:save")
    public Fire save(@RequestBody DailyTableQO dailyTable) {
        dailyTableService.save(dailyTable);

        return Fire.ok();
    }

    /**
     * 修改
     *
     * @param dailyTable
     * @return Fire
     */
    @PutMapping("/update")
    @RequiresPermissions("fire:dailytable:update")
    public Fire update(@RequestBody DailyTableQO dailyTable) {
        dailyTableService.update(dailyTable);

        return Fire.ok();
    }

    /**
     * 删除
     *
     * @param dailyTableIds
     * @return Fire
     */
    @DeleteMapping("/delete")
    @RequiresPermissions("fire:dailytable:delete")
    public Fire delete(@RequestBody Integer[] dailyTableIds) {
        dailyTableService.deleteBatch(dailyTableIds);

        return Fire.ok();
    }

    /**
     * 通过场所查询调查表
     *
     * @param countId
     * @return Fire
     */
    @GetMapping("/countDaily")
    public Fire countDaily(Integer countId) {
        List<DailyTable> dailyTables = dailyTableService.countDaily(countId);
        return Fire.ok().put("data", dailyTables);
    }

    /**
     * 通过日常检查id查询所有信息
     *
     * @param dailyTableId
     * @return Fire
     */
    @GetMapping("/queryAll")
    public Fire queryAll(Integer dailyTableId) {
        DailyTableVO dailyTableVO = dailyTableService.queryAll(dailyTableId);
        return Fire.ok().put("data", dailyTableVO);
    }

    /**
     * 根据警员 id 查询警员检查次数
     *
     * @param params 警员 Id,起始时间
     * @return
     */
    @PostMapping("/count")
    public Fire count(DailyTableQO params) {
        List<PoliceCheckSum> list = null;
        if (params.getPoliceId() != null) {
            List<DailyTableVO> countList = dailyTableService.count(params);
            HashMap<String, PoliceCheckSum> maps = new HashMap<String, PoliceCheckSum>();
            list = dailyTableService.fillPoliceCheckSum(params.getDatatype(), countList, maps);
        } else {
            System.out.println("沒有輸入");
        }
        return Fire.ok().put("data", list);
    }
}
