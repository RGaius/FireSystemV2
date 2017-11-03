package xhu.wncg.firesystem.modules.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import xhu.wncg.firesystem.modules.mapper.DangerTableMapper;
import xhu.wncg.firesystem.modules.service.DangerTableService;
import xhu.wncg.firesystem.modules.controller.vo.DangerTableVO;
import xhu.wncg.firesystem.modules.controller.qo.DangerTableQO;
/**
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:15
 */
@Service("dangerTableService")
public class DangerTableServiceImpl implements DangerTableService {
	@Autowired
	private DangerTableMapper dangerTableMapper;
	
	@Override
	public DangerTableVO queryObject(Integer dangerTableId){
		return dangerTableMapper.queryObject(dangerTableId);
	}
	
	@Override
	public List<DangerTableVO> queryList(Map<String, Object> map){
		return dangerTableMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return dangerTableMapper.queryTotal(map);
	}
	
	@Override
	public void save(DangerTableQO dangerTable){
		dangerTableMapper.save(dangerTable);
	}
	
	@Override
	public void update(DangerTableQO dangerTable){
		dangerTableMapper.update(dangerTable);
	}
	
	@Override
	public void delete(Integer dangerTableId){
		dangerTableMapper.delete(dangerTableId);
	}
	
	@Override
	public void deleteBatch(Integer[] dangerTableIds){
		dangerTableMapper.deleteBatch(dangerTableIds);
	}
	
}
