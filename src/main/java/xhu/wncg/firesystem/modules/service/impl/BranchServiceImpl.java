package xhu.wncg.firesystem.modules.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import xhu.wncg.firesystem.modules.mapper.BranchMapper;
import xhu.wncg.firesystem.modules.service.BranchService;
import xhu.wncg.firesystem.modules.controller.vo.BranchVO;
import xhu.wncg.firesystem.modules.controller.qo.BranchQO;
/**
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:16
 */
@Service("branchService")
public class BranchServiceImpl implements BranchService {
	@Autowired
	private BranchMapper branchMapper;
	
	@Override
	public BranchVO queryObject(Integer branchId){
		return branchMapper.queryObject(branchId);
	}
	
	@Override
	public List<BranchVO> queryList(Map<String, Object> map){
		return branchMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return branchMapper.queryTotal(map);
	}
	
	@Override
	public void save(BranchQO branch){
		branchMapper.save(branch);
	}
	
	@Override
	public void update(BranchQO branch){
		branchMapper.update(branch);
	}
	
	@Override
	public void delete(Integer branchId){
		branchMapper.delete(branchId);
	}
	
	@Override
	public void deleteBatch(Integer[] branchIds){
		branchMapper.deleteBatch(branchIds);
	}
	
}
