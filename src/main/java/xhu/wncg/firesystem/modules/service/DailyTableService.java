package xhu.wncg.firesystem.modules.service;

import xhu.wncg.firesystem.modules.controller.vo.DailyTableVO;
import xhu.wncg.firesystem.modules.controller.qo.DailyTableQO;
import xhu.wncg.common.service.BaseService;
import xhu.wncg.firesystem.modules.pojo.DailyTable;

import java.util.List;

/**
 * 日常检查表
 * 
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:16
 */
public interface DailyTableService extends BaseService<DailyTableQO, DailyTableVO> {

    /**
     * 通过场所查询检查表
     * @param countId
     * @return list
     */
    List<DailyTable> countDaily(Integer countId);

    /**
     * 通过日常检查记录id查检查表及所有信息
     * @param dailyTableId
     * @return DailyTableVo
     */
    DailyTableVO queryAll(Integer dailyTableId);

}
