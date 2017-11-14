package xhu.wncg.firesystem.modules.mapper;

import xhu.wncg.firesystem.modules.controller.vo.PictureVO;
import xhu.wncg.firesystem.modules.controller.qo.PictureQO;
import xhu.wncg.common.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import xhu.wncg.firesystem.modules.pojo.Picture;

import java.util.List;

/**
 * 表册图片表
 * 
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:16
 */
@Mapper
public interface PictureMapper extends BaseMapper<PictureQO, PictureVO> {
    /**
     * 通过日常检查表id查图片信息
     */
    List<Picture> queryByDailyTableId(Integer dailyTableId);
}
