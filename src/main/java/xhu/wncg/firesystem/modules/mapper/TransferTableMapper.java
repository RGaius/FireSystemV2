package xhu.wncg.firesystem.modules.mapper;

import xhu.wncg.firesystem.modules.controller.vo.TransferTableVO;
import xhu.wncg.firesystem.modules.controller.qo.TransferTableQO;
import xhu.wncg.common.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 移交书
 * 
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:15
 */
@Mapper
public interface TransferTableMapper extends BaseMapper<TransferTableQO, TransferTableVO> {
	
}
