package xhu.wncg.firesystem.modules.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import xhu.wncg.firesystem.modules.controller.vo.BranchVO;
import xhu.wncg.firesystem.modules.controller.qo.BranchQO;
import xhu.wncg.firesystem.modules.service.BranchService;
import xhu.wncg.common.utils.PageUtils;
import xhu.wncg.common.utils.Query;
import xhu.wncg.common.utils.Fire;

/**
 * 公安分局表
 * 
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:16
 */
@RestController
@RequestMapping("/fire/branch")
public class BranchController {
	@Autowired
	private BranchService branchService;
	
	/**
	 * 列表
	 * @param params
	 * @return Fire
	 */
	@GetMapping("/list")
	@RequiresPermissions("fire:branch:list")
	public Fire list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<BranchVO> branchList = branchService.queryList(query);
		int total = branchService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(branchList, total, query.getLimit(), query.getPage());
		
		return Fire.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 * @param branchId
	 * @return Fire
	 */
	@GetMapping("/info/{branchId}")
	@RequiresPermissions("fire:branch:info")
	public Fire info(@PathVariable("branchId") Integer branchId){
		BranchVO branch = branchService.queryObject(branchId);
		
		return Fire.ok().put("branch", branch);
	}
	
	/**
	 * 保存
	 * @param branch
	 * @return Fire
	 */
	@PostMapping("/save")
	@RequiresPermissions("fire:branch:save")
	public Fire save(@RequestBody BranchQO branch){
		branchService.save(branch);
		
		return Fire.ok();
	}
	
	/**
	 * 修改
	 * @param branch
	 * @return Fire
	 */
	@PutMapping("/update")
	@RequiresPermissions("fire:branch:update")
	public Fire update(@RequestBody BranchQO branch){
		branchService.update(branch);
		
		return Fire.ok();
	}
	
	/**
	 * 删除
	 * @param branchIds
	 * @return Fire
	 */
	@DeleteMapping("/delete")
	@RequiresPermissions("fire:branch:delete")
	public Fire delete(@RequestBody Integer[] branchIds){
		branchService.deleteBatch(branchIds);
		
		return Fire.ok();
	}
	
}
