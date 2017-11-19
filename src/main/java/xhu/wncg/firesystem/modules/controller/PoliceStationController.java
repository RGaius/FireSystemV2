package xhu.wncg.firesystem.modules.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import xhu.wncg.firesystem.modules.controller.vo.PoliceStationVO;
import xhu.wncg.firesystem.modules.controller.qo.PoliceStationQO;
import xhu.wncg.firesystem.modules.service.PoliceStationService;
import xhu.wncg.common.utils.PageUtils;
import xhu.wncg.common.utils.Query;
import xhu.wncg.common.utils.Fire;

/**
 * 派出所表
 * 
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:16
 */
@RestController
@RequestMapping("/fire/policestation")
public class PoliceStationController {
	@Autowired
	private PoliceStationService policeStationService;
	
	/**
	 * 列表
	 * @param params
	 * @return Fire
	 */
	@GetMapping("/list")
	@RequiresPermissions("fire:policestation:list")
	public Fire list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<PoliceStationVO> policeStationList = policeStationService.queryList(query);
		int total = policeStationService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(policeStationList, total, query.getLimit(), query.getPage());
		
		return Fire.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 * @param policeStationId
	 * @return Fire
	 */
	@GetMapping("/info/{policeStationId}")
	@RequiresPermissions("fire:policestation:info")
	public Fire info(@PathVariable("policeStationId") Integer policeStationId){
		PoliceStationVO policeStation = policeStationService.queryObject(policeStationId);
		
		return Fire.ok().put("policeStation", policeStation);
	}
	
	/**
	 * 保存
	 * @param policeStation
	 * @return Fire
	 */
	@PostMapping("/save")
	@RequiresPermissions("fire:policestation:save")
	public Fire save(@RequestBody PoliceStationQO policeStation){
		policeStationService.save(policeStation);
		
		return Fire.ok();
	}
	
	/**
	 * 修改
	 * @param policeStation
	 * @return Fire
	 */
	@PutMapping("/update")
	@RequiresPermissions("fire:policestation:update")
	public Fire update(@RequestBody PoliceStationQO policeStation){
		policeStationService.update(policeStation);
		
		return Fire.ok();
	}
	
	/**
	 * 删除
	 * @param policeStationIds
	 * @return Fire
	 */
	@DeleteMapping("/delete")
	@RequiresPermissions("fire:policestation:delete")
	public Fire delete(@RequestBody Integer[] policeStationIds){
		policeStationService.deleteBatch(policeStationIds);
		
		return Fire.ok();
	}

	/**
	 * 查询派出所数据
	 * @return Fire
	 */
	@GetMapping("/listPoliceStation")
	public Fire listPoliceStation(){
		List<PoliceStationVO> policeStationList = policeStationService.queryList(null);
		return Fire.ok().put("data", policeStationList);
	}
}
