package xhu.wncg.firesystem.modules.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import xhu.wncg.firesystem.modules.mapper.TaskMapper;
import xhu.wncg.firesystem.modules.service.TaskService;
import xhu.wncg.firesystem.modules.controller.vo.TaskVO;
import xhu.wncg.firesystem.modules.controller.qo.TaskQO;
/**
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:16
 */
@Service("taskService")
public class TaskServiceImpl implements TaskService {
	@Autowired
	private TaskMapper taskMapper;
	
	@Override
	public TaskVO queryObject(Integer taskId){
		return taskMapper.queryObject(taskId);
	}
	
	@Override
	public List<TaskVO> queryList(Map<String, Object> map){
		return taskMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return taskMapper.queryTotal(map);
	}
	
	@Override
	public void save(TaskQO task){
		taskMapper.save(task);
	}
	
	@Override
	public void update(TaskQO task){
		taskMapper.update(task);
	}
	
	@Override
	public void delete(Integer taskId){
		taskMapper.delete(taskId);
	}
	
	@Override
	public void deleteBatch(Integer[] taskIds){
		taskMapper.deleteBatch(taskIds);
	}
	
}
