package xhu.wncg.firesystem.modules.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import xhu.wncg.firesystem.modules.mapper.UnitMapper;
import xhu.wncg.firesystem.modules.pojo.Unit;
import xhu.wncg.firesystem.modules.service.UnitService;
import xhu.wncg.firesystem.modules.controller.vo.UnitVO;
import xhu.wncg.firesystem.modules.controller.qo.UnitQO;
/**
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:16
 */
@Service("unitService")
public class UnitServiceImpl implements UnitService {
	@Autowired
	private UnitMapper unitMapper;
	
	@Override
	public UnitVO queryObject(Integer unitId){
		return unitMapper.queryObject(unitId);
	}
	
	@Override
	public List<UnitVO> queryList(Map<String, Object> map){
		return unitMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return unitMapper.queryTotal(map);
	}
	
	@Override
	public void save(UnitQO unit){
		unitMapper.save(unit);
	}
	
	@Override
	public void update(UnitQO unit){
		unitMapper.update(unit);
	}
	
	@Override
	public void delete(Integer unitId){
		unitMapper.delete(unitId);
	}
	
	@Override
	public void deleteBatch(Integer[] unitIds){
		unitMapper.deleteBatch(unitIds);
	}

	@Override
	public List<UnitVO> count(Integer policeStationId) {
		return unitMapper.count(policeStationId);
	}
	@Override
	public  List<Unit> queryCount(String countKeys){
		return unitMapper.queryCount(countKeys);
	}
	@Override
	public Unit queryById(Integer countId){
		return unitMapper.queryById(countId);
	}
}
