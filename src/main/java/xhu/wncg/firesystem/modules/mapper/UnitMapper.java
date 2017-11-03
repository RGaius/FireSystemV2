package xhu.wncg.firesystem.modules.mapper;

import xhu.wncg.firesystem.modules.controller.vo.UnitVO;
import xhu.wncg.firesystem.modules.controller.qo.UnitQO;
import xhu.wncg.common.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 场所表
 * 
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:16
 */
@Mapper
public interface UnitMapper extends BaseMapper<UnitQO, UnitVO> {

    /**
     * 统计派出所辖区内场所分布情况
     * @param policeStationId 派出所id
     * @return list
     */
    List<UnitVO> count(Integer policeStationId);
}
