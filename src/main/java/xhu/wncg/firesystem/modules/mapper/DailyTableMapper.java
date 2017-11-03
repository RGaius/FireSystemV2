package xhu.wncg.firesystem.modules.mapper;

import xhu.wncg.firesystem.modules.controller.vo.DailyTableVO;
import xhu.wncg.firesystem.modules.controller.qo.DailyTableQO;
import xhu.wncg.common.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 日常检查表
 * 
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:16
 */
@Mapper
public interface DailyTableMapper extends BaseMapper<DailyTableQO, DailyTableVO> {
	
}
