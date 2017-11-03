package xhu.wncg.firesystem.modules.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import xhu.wncg.firesystem.modules.mapper.PoliceStationMapper;
import xhu.wncg.firesystem.modules.service.PoliceStationService;
import xhu.wncg.firesystem.modules.controller.vo.PoliceStationVO;
import xhu.wncg.firesystem.modules.controller.qo.PoliceStationQO;
/**
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:16
 */
@Service("policeStationService")
public class PoliceStationServiceImpl implements PoliceStationService {
	@Autowired
	private PoliceStationMapper policeStationMapper;
	
	@Override
	public PoliceStationVO queryObject(Integer policeStationId){
		return policeStationMapper.queryObject(policeStationId);
	}
	
	@Override
	public List<PoliceStationVO> queryList(Map<String, Object> map){
		return policeStationMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return policeStationMapper.queryTotal(map);
	}
	
	@Override
	public void save(PoliceStationQO policeStation){
		policeStationMapper.save(policeStation);
	}
	
	@Override
	public void update(PoliceStationQO policeStation){
		policeStationMapper.update(policeStation);
	}
	
	@Override
	public void delete(Integer policeStationId){
		policeStationMapper.delete(policeStationId);
	}
	
	@Override
	public void deleteBatch(Integer[] policeStationIds){
		policeStationMapper.deleteBatch(policeStationIds);
	}
	
}
