package xhu.wncg.firesystem.modules.mapper;

import xhu.wncg.firesystem.modules.controller.vo.BranchVO;
import xhu.wncg.firesystem.modules.controller.qo.BranchQO;
import xhu.wncg.common.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 公安分局表
 * 
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:16
 */
@Mapper
public interface BranchMapper extends BaseMapper<BranchQO, BranchVO> {
	
}
