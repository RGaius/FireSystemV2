package xhu.wncg.firesystem.modules.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import xhu.wncg.firesystem.modules.pojo.DateType;
import xhu.wncg.firesystem.modules.mapper.DailyTableMapper;
import xhu.wncg.firesystem.modules.pojo.DailyTable;
import xhu.wncg.firesystem.modules.pojo.PoliceCheckSum;
import xhu.wncg.firesystem.modules.service.DailyTableService;
import xhu.wncg.firesystem.modules.controller.vo.DailyTableVO;
import xhu.wncg.firesystem.modules.controller.qo.DailyTableQO;
import xhu.wncg.firesystem.modules.service.PictureService;
import xhu.wncg.firesystem.modules.service.UnitService;

/**
 * @author zhaobo
 * @version 2017-11-02 15:58:16
 * @email 15528330581@163.com
 */
@Service("dailyTableService")
public class DailyTableServiceImpl implements DailyTableService {
    @Autowired
    private DailyTableMapper dailyTableMapper;
    @Autowired
    private PictureService pictureService;
    @Autowired
    private UnitService unitService;

    @Override
    public DailyTableVO queryObject(Integer dailyTableId) {
        return dailyTableMapper.queryObject(dailyTableId);
    }

    @Override
    public List<DailyTableVO> queryList(Map<String, Object> map) {
        return dailyTableMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return dailyTableMapper.queryTotal(map);
    }

    @Override
    public void save(DailyTableQO dailyTable) {
        dailyTableMapper.save(dailyTable);
    }

    @Override
    public void update(DailyTableQO dailyTable) {
        dailyTableMapper.update(dailyTable);
    }

    @Override
    public void delete(Integer dailyTableId) {
        dailyTableMapper.delete(dailyTableId);
    }

    @Override
    public void deleteBatch(Integer[] dailyTableIds) {
        dailyTableMapper.deleteBatch(dailyTableIds);
    }

    @Override
    public List<DailyTable> countDaily(Integer countId) {
        return dailyTableMapper.countDaily(countId);
    }

    @Override
    public DailyTableVO queryAll(Integer dailyTableId) {
        DailyTableVO dailyTableVO;
        dailyTableVO = dailyTableMapper.queryByDailyTableId(dailyTableId);
        dailyTableVO.setPicture(pictureService.queryByDailyTableId(dailyTableId));
        dailyTableVO.setUnit(unitService.queryById(dailyTableVO.getUnitId()));
        return dailyTableVO;
    }

    @Override
    public List<DailyTableVO> count(Object params) {
        return dailyTableMapper.count(params);
    }
    /**
     * 统计警员检查情况
     *
     * @param dateType
     * @param count
     * @param maps
     * @return
     */
    @Override
    public List<PoliceCheckSum> fillPoliceCheckSum(int dateType, List<DailyTableVO> count, HashMap<String, PoliceCheckSum> maps) {
        String key;
        PoliceCheckSum policeCheckSum;
        for (DailyTableVO checkCount : count) {
            switch (DateType.getByValue(dateType)) {
                case Week:
                    // 周分组
                    key = checkCount.getYear() + "年" + checkCount.getWeek() + "周";
                    break;
                case Month:
                    // 月分组
                    key = checkCount.getYear() + "-" + checkCount.getMonth();
                    break;
                case Year:
                    // 年分组
                    key = checkCount.getYear();
                    break;
                default:
                    // 天分组
                    key = checkCount.getCheckdate();
                    break;
            }
            if (maps.containsKey(key)) {
                policeCheckSum = maps.get(key);
                policeCheckSum.setDimensionValue(key);
                policeCheckSum.setAmmount(policeCheckSum.getAmmount() + 1);

            } else {
                policeCheckSum = new PoliceCheckSum();
                policeCheckSum.setDimensionValue(key);
                policeCheckSum.setAmmount(1);
            }
            maps.put(key, policeCheckSum);
    }

        List<PoliceCheckSum> list= new ArrayList<>(maps.values());

        Collections.sort(list, Comparator.comparing(PoliceCheckSum::getDimensionValue));

        return list;
    }
}
