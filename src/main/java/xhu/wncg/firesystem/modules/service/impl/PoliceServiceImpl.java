package xhu.wncg.firesystem.modules.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import xhu.wncg.firesystem.modules.mapper.PoliceMapper;
import xhu.wncg.firesystem.modules.service.PoliceService;
import xhu.wncg.firesystem.modules.controller.vo.PoliceVO;
import xhu.wncg.firesystem.modules.controller.qo.PoliceQO;
/**
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:16
 */
@Service("policeService")
public class PoliceServiceImpl implements PoliceService {
	@Autowired
	private PoliceMapper policeMapper;
	
	@Override
	public PoliceVO queryObject(Integer policeId){
		return policeMapper.queryObject(policeId);
	}
	
	@Override
	public List<PoliceVO> queryList(Map<String, Object> map){
		return policeMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return policeMapper.queryTotal(map);
	}
	
	@Override
	public void save(PoliceQO police){
		policeMapper.save(police);
	}
	
	@Override
	public void update(PoliceQO police){
		policeMapper.update(police);
	}
	
	@Override
	public void delete(Integer policeId){
		policeMapper.delete(policeId);
	}
	
	@Override
	public void deleteBatch(Integer[] policeIds){
		policeMapper.deleteBatch(policeIds);
	}
	
}
