package xhu.wncg.firesystem.modules.mapper;

import xhu.wncg.firesystem.modules.controller.vo.PoliceVO;
import xhu.wncg.firesystem.modules.controller.qo.PoliceQO;
import xhu.wncg.common.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 警员表
 * 
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:16
 */
@Mapper
public interface PoliceMapper extends BaseMapper<PoliceQO, PoliceVO> {
	
}
