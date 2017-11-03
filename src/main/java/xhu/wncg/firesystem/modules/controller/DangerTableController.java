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

import xhu.wncg.firesystem.modules.controller.vo.DangerTableVO;
import xhu.wncg.firesystem.modules.controller.qo.DangerTableQO;
import xhu.wncg.firesystem.modules.service.DangerTableService;
import xhu.wncg.common.utils.PageUtils;
import xhu.wncg.common.utils.Query;
import xhu.wncg.common.utils.Fire;

/**
 * 火灾隐患报告书
 * 
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:15
 */
@RestController
@RequestMapping("/fire/dangertable")
public class DangerTableController {
	@Autowired
	private DangerTableService dangerTableService;
	
	/**
	 * 列表
	 * @param params
	 * @return Fire
	 */
	@GetMapping("/list")
	@RequiresPermissions("fire:dangertable:list")
	public Fire list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<DangerTableVO> dangerTableList = dangerTableService.queryList(query);
		int total = dangerTableService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(dangerTableList, total, query.getLimit(), query.getPage());
		
		return Fire.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 * @param dangerTableId
	 * @return Fire
	 */
	@GetMapping("/info/{dangerTableId}")
	@RequiresPermissions("fire:dangertable:info")
	public Fire info(@PathVariable("dangerTableId") Integer dangerTableId){
		DangerTableVO dangerTable = dangerTableService.queryObject(dangerTableId);
		
		return Fire.ok().put("dangerTable", dangerTable);
	}
	
	/**
	 * 保存
	 * @param dangerTable
	 * @return Fire
	 */
	@PostMapping("/save")
	@RequiresPermissions("fire:dangertable:save")
	public Fire save(@RequestBody DangerTableQO dangerTable){
		dangerTableService.save(dangerTable);
		
		return Fire.ok();
	}
	
	/**
	 * 修改
	 * @param dangerTable
	 * @return Fire
	 */
	@PutMapping("/update")
	@RequiresPermissions("fire:dangertable:update")
	public Fire update(@RequestBody DangerTableQO dangerTable){
		dangerTableService.update(dangerTable);
		
		return Fire.ok();
	}
	
	/**
	 * 删除
	 * @param dangerTableIds
	 * @return Fire
	 */
	@DeleteMapping("/delete")
	@RequiresPermissions("fire:dangertable:delete")
	public Fire delete(@RequestBody Integer[] dangerTableIds){
		dangerTableService.deleteBatch(dangerTableIds);
		
		return Fire.ok();
	}
	
}
