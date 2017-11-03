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

import xhu.wncg.firesystem.modules.controller.vo.PictureVO;
import xhu.wncg.firesystem.modules.controller.qo.PictureQO;
import xhu.wncg.firesystem.modules.service.PictureService;
import xhu.wncg.common.utils.PageUtils;
import xhu.wncg.common.utils.Query;
import xhu.wncg.common.utils.Fire;

/**
 * 表册图片表
 * 
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:16
 */
@RestController
@RequestMapping("/fire/picture")
public class PictureController {
	@Autowired
	private PictureService pictureService;
	
	/**
	 * 列表
	 * @param params
	 * @return Fire
	 */
	@GetMapping("/list")
	@RequiresPermissions("fire:picture:list")
	public Fire list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<PictureVO> pictureList = pictureService.queryList(query);
		int total = pictureService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(pictureList, total, query.getLimit(), query.getPage());
		
		return Fire.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 * @param pictureId
	 * @return Fire
	 */
	@GetMapping("/info/{pictureId}")
	@RequiresPermissions("fire:picture:info")
	public Fire info(@PathVariable("pictureId") Integer pictureId){
		PictureVO picture = pictureService.queryObject(pictureId);
		
		return Fire.ok().put("picture", picture);
	}
	
	/**
	 * 保存
	 * @param picture
	 * @return Fire
	 */
	@PostMapping("/save")
	@RequiresPermissions("fire:picture:save")
	public Fire save(@RequestBody PictureQO picture){
		pictureService.save(picture);
		
		return Fire.ok();
	}
	
	/**
	 * 修改
	 * @param picture
	 * @return Fire
	 */
	@PutMapping("/update")
	@RequiresPermissions("fire:picture:update")
	public Fire update(@RequestBody PictureQO picture){
		pictureService.update(picture);
		
		return Fire.ok();
	}
	
	/**
	 * 删除
	 * @param pictureIds
	 * @return Fire
	 */
	@DeleteMapping("/delete")
	@RequiresPermissions("fire:picture:delete")
	public Fire delete(@RequestBody Integer[] pictureIds){
		pictureService.deleteBatch(pictureIds);
		
		return Fire.ok();
	}
	
}
