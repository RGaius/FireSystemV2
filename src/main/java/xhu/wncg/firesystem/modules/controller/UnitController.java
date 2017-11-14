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

import xhu.wncg.firesystem.modules.controller.vo.UnitVO;
import xhu.wncg.firesystem.modules.controller.qo.UnitQO;
import xhu.wncg.firesystem.modules.pojo.Unit;
import xhu.wncg.firesystem.modules.service.UnitService;
import xhu.wncg.common.utils.PageUtils;
import xhu.wncg.common.utils.Query;
import xhu.wncg.common.utils.Fire;

/**
 * 场所表
 * 
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:16
 */
@RestController
@RequestMapping("/fire/unit")
public class UnitController {
	@Autowired
	private UnitService unitService;
	
	/**
	 * 列表
	 * @param params
	 * @return Fire
	 */
	@GetMapping("/list")
	@RequiresPermissions("fire:unit:list")
	public Fire list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<UnitVO> unitList = unitService.queryList(query);
		int total = unitService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(unitList, total, query.getLimit(), query.getPage());
		
		return Fire.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 * @param unitId
	 * @return Fire
	 */
	@GetMapping("/info/{unitId}")
	@RequiresPermissions("fire:unit:info")
	public Fire info(@PathVariable("unitId") Integer unitId){
		UnitVO unit = unitService.queryObject(unitId);
		
		return Fire.ok().put("unit", unit);
	}
	
	/**
	 * 保存
	 * @param unit
	 * @return Fire
	 */
	@PostMapping("/save")
	@RequiresPermissions("fire:unit:save")
	public Fire save(@RequestBody UnitQO unit){
		unitService.save(unit);
		
		return Fire.ok();
	}
	
	/**
	 * 修改
	 * @param unit
	 * @return Fire
	 */
	@PutMapping("/update")
	@RequiresPermissions("fire:unit:update")
	public Fire update(@RequestBody UnitQO unit){
		unitService.update(unit);
		
		return Fire.ok();
	}
	
	/**
	 * 删除
	 * @param unitIds
	 * @return Fire
	 */
	@DeleteMapping("/delete")
	@RequiresPermissions("fire:unit:delete")
	public Fire delete(@RequestBody Integer[] unitIds){
		unitService.deleteBatch(unitIds);
		return Fire.ok();
	}

	/**
	 * 统计各派出所下场所情况
	 * @param policeStationId 派出所id
	 * @return object
	 */
	@GetMapping("/count")
	@RequiresPermissions("fire:unit:count")
	public Fire count(Integer policeStationId){
		List<UnitVO> countList = unitService.count(policeStationId);
		return Fire.ok().put("data", countList);
	}

	/**
	 * 模糊查询场所
	 * @param countKeys 关键字
	 * @return object
	 */
	@GetMapping("/queryCount")
	public Fire queryCount(String countKeys){
		List<Unit> countList=unitService.queryCount(countKeys);
		return Fire.ok().put("data",countList);
	}

	
}
