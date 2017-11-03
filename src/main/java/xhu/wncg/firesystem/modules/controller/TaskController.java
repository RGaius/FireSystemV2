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

import xhu.wncg.firesystem.modules.controller.vo.TaskVO;
import xhu.wncg.firesystem.modules.controller.qo.TaskQO;
import xhu.wncg.firesystem.modules.service.TaskService;
import xhu.wncg.common.utils.PageUtils;
import xhu.wncg.common.utils.Query;
import xhu.wncg.common.utils.Fire;

/**
 * 任务表
 * 
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:16
 */
@RestController
@RequestMapping("/fire/task")
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	/**
	 * 列表
	 * @param params
	 * @return Fire
	 */
	@GetMapping("/list")
	@RequiresPermissions("fire:task:list")
	public Fire list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TaskVO> taskList = taskService.queryList(query);
		int total = taskService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(taskList, total, query.getLimit(), query.getPage());
		
		return Fire.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 * @param taskId
	 * @return Fire
	 */
	@GetMapping("/info/{taskId}")
	@RequiresPermissions("fire:task:info")
	public Fire info(@PathVariable("taskId") Integer taskId){
		TaskVO task = taskService.queryObject(taskId);
		
		return Fire.ok().put("task", task);
	}
	
	/**
	 * 保存
	 * @param task
	 * @return Fire
	 */
	@PostMapping("/save")
	@RequiresPermissions("fire:task:save")
	public Fire save(@RequestBody TaskQO task){
		taskService.save(task);
		
		return Fire.ok();
	}
	
	/**
	 * 修改
	 * @param task
	 * @return Fire
	 */
	@PutMapping("/update")
	@RequiresPermissions("fire:task:update")
	public Fire update(@RequestBody TaskQO task){
		taskService.update(task);
		
		return Fire.ok();
	}
	
	/**
	 * 删除
	 * @param taskIds
	 * @return Fire
	 */
	@DeleteMapping("/delete")
	@RequiresPermissions("fire:task:delete")
	public Fire delete(@RequestBody Integer[] taskIds){
		taskService.deleteBatch(taskIds);
		
		return Fire.ok();
	}
	
}
