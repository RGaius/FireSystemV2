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

import xhu.wncg.firesystem.modules.controller.vo.TransferTableVO;
import xhu.wncg.firesystem.modules.controller.qo.TransferTableQO;
import xhu.wncg.firesystem.modules.service.TransferTableService;
import xhu.wncg.common.utils.PageUtils;
import xhu.wncg.common.utils.Query;
import xhu.wncg.common.utils.Fire;

/**
 * 移交书
 * 
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:15
 */
@RestController
@RequestMapping("/fire/transfertable")
public class TransferTableController {
	@Autowired
	private TransferTableService transferTableService;
	
	/**
	 * 列表
	 * @param params
	 * @return Fire
	 */
	@GetMapping("/list")
	@RequiresPermissions("fire:transfertable:list")
	public Fire list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TransferTableVO> transferTableList = transferTableService.queryList(query);
		int total = transferTableService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(transferTableList, total, query.getLimit(), query.getPage());
		
		return Fire.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 * @param transferTableId
	 * @return Fire
	 */
	@GetMapping("/info/{transferTableId}")
	@RequiresPermissions("fire:transfertable:info")
	public Fire info(@PathVariable("transferTableId") Integer transferTableId){
		TransferTableVO transferTable = transferTableService.queryObject(transferTableId);
		
		return Fire.ok().put("transferTable", transferTable);
	}
	
	/**
	 * 保存
	 * @param transferTable
	 * @return Fire
	 */
	@PostMapping("/save")
	@RequiresPermissions("fire:transfertable:save")
	public Fire save(@RequestBody TransferTableQO transferTable){
		transferTableService.save(transferTable);
		
		return Fire.ok();
	}
	
	/**
	 * 修改
	 * @param transferTable
	 * @return Fire
	 */
	@PutMapping("/update")
	@RequiresPermissions("fire:transfertable:update")
	public Fire update(@RequestBody TransferTableQO transferTable){
		transferTableService.update(transferTable);
		
		return Fire.ok();
	}
	
	/**
	 * 删除
	 * @param transferTableIds
	 * @return Fire
	 */
	@DeleteMapping("/delete")
	@RequiresPermissions("fire:transfertable:delete")
	public Fire delete(@RequestBody Integer[] transferTableIds){
		transferTableService.deleteBatch(transferTableIds);
		
		return Fire.ok();
	}
	
}
