package xhu.wncg.firesystem.modules.mapper;

import xhu.wncg.firesystem.modules.controller.vo.DangerTableVO;
import xhu.wncg.firesystem.modules.controller.qo.DangerTableQO;
import xhu.wncg.common.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 火灾隐患报告书
 * 
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:15
 */
@Mapper
public interface DangerTableMapper extends BaseMapper<DangerTableQO, DangerTableVO> {
	
}
