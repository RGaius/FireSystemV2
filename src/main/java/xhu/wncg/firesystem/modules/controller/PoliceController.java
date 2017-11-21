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

import xhu.wncg.firesystem.modules.controller.vo.PoliceVO;
import xhu.wncg.firesystem.modules.controller.qo.PoliceQO;
import xhu.wncg.firesystem.modules.service.PoliceService;
import xhu.wncg.common.utils.PageUtils;
import xhu.wncg.common.utils.Query;
import xhu.wncg.common.utils.Fire;

/**
 * 警员表
 * 
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:16
 */
@RestController
@RequestMapping("/fire/police")
public class PoliceController {
	@Autowired
	private PoliceService policeService;
	
	/**
	 * 列表
	 * @param params
	 * @return Fire
	 */
	@GetMapping("/list")
	@RequiresPermissions("fire:police:list")
	public Fire list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<PoliceVO> policeList = policeService.queryList(query);
		int total = policeService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(policeList, total, query.getLimit(), query.getPage());
		
		return Fire.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 * @param id
	 * @return Fire
	 */
	@GetMapping("/info/{policeId}")
	@RequiresPermissions("fire:police:info")
	public Fire info(@PathVariable("id") Integer id){
		PoliceVO police = policeService.queryObject(id);
		
		return Fire.ok().put("police", police);
	}
	
	/**
	 * 保存
	 * @param police
	 * @return Fire
	 */
	@PostMapping("/save")
	@RequiresPermissions("fire:police:save")
	public Fire save(@RequestBody PoliceQO police){
		policeService.save(police);
		
		return Fire.ok();
	}
	
	/**
	 * 修改
	 * @param police
	 * @return Fire
	 */
	@PutMapping("/update")
	@RequiresPermissions("fire:police:update")
	public Fire update(@RequestBody PoliceQO police){
		policeService.update(police);
		
		return Fire.ok();
	}
	
	/**
	 * 删除
	 * @param ids
	 * @return Fire
	 */
	@DeleteMapping("/delete")
	@RequiresPermissions("fire:police:delete")
	public Fire delete(@RequestBody Integer[] ids){
		policeService.deleteBatch(ids);
		
		return Fire.ok();
	}
	
}
