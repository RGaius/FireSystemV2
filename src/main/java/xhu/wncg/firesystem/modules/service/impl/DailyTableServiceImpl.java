package xhu.wncg.firesystem.modules.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import xhu.wncg.firesystem.modules.mapper.DailyTableMapper;
import xhu.wncg.firesystem.modules.pojo.DailyTable;
import xhu.wncg.firesystem.modules.service.DailyTableService;
import xhu.wncg.firesystem.modules.controller.vo.DailyTableVO;
import xhu.wncg.firesystem.modules.controller.qo.DailyTableQO;
import xhu.wncg.firesystem.modules.service.PictureService;
import xhu.wncg.firesystem.modules.service.UnitService;

/**
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:16
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
	public DailyTableVO queryObject(Integer dailyTableId){
		return dailyTableMapper.queryObject(dailyTableId);
	}
	
	@Override
	public List<DailyTableVO> queryList(Map<String, Object> map){
		return dailyTableMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return dailyTableMapper.queryTotal(map);
	}
	
	@Override
	public void save(DailyTableQO dailyTable){
		dailyTableMapper.save(dailyTable);
	}
	
	@Override
	public void update(DailyTableQO dailyTable){
		dailyTableMapper.update(dailyTable);
	}
	
	@Override
	public void delete(Integer dailyTableId){
		dailyTableMapper.delete(dailyTableId);
	}
	
	@Override
	public void deleteBatch(Integer[] dailyTableIds){
		dailyTableMapper.deleteBatch(dailyTableIds);
	}

	@Override
	public List<DailyTable> countDaily(Integer countId){
		return dailyTableMapper.countDaily(countId);
	}

	@Override
	public DailyTableVO queryAll(Integer dailyTableId){
		DailyTableVO dailyTableVO;
		dailyTableVO=dailyTableMapper.queryByDailyTableId(dailyTableId);
		dailyTableVO.setPicture(pictureService.queryByDailyTableId(dailyTableId));
		dailyTableVO.setUnit(unitService.queryById(dailyTableVO.getUnitId()));
		return dailyTableVO;
	}

	@Override
	public List<DailyTableVO> count(Integer policeId){
		return dailyTableMapper.count(policeId);
	}
}
