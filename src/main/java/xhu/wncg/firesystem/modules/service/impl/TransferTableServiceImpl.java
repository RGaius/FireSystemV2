package xhu.wncg.firesystem.modules.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import xhu.wncg.firesystem.modules.mapper.TransferTableMapper;
import xhu.wncg.firesystem.modules.service.TransferTableService;
import xhu.wncg.firesystem.modules.controller.vo.TransferTableVO;
import xhu.wncg.firesystem.modules.controller.qo.TransferTableQO;
/**
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:15
 */
@Service("transferTableService")
public class TransferTableServiceImpl implements TransferTableService {
	@Autowired
	private TransferTableMapper transferTableMapper;
	
	@Override
	public TransferTableVO queryObject(Integer transferTableId){
		return transferTableMapper.queryObject(transferTableId);
	}
	
	@Override
	public List<TransferTableVO> queryList(Map<String, Object> map){
		return transferTableMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return transferTableMapper.queryTotal(map);
	}
	
	@Override
	public void save(TransferTableQO transferTable){
		transferTableMapper.save(transferTable);
	}
	
	@Override
	public void update(TransferTableQO transferTable){
		transferTableMapper.update(transferTable);
	}
	
	@Override
	public void delete(Integer transferTableId){
		transferTableMapper.delete(transferTableId);
	}
	
	@Override
	public void deleteBatch(Integer[] transferTableIds){
		transferTableMapper.deleteBatch(transferTableIds);
	}
	
}
