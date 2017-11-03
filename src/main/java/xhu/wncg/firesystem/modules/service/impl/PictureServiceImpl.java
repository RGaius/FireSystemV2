package xhu.wncg.firesystem.modules.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import xhu.wncg.firesystem.modules.mapper.PictureMapper;
import xhu.wncg.firesystem.modules.service.PictureService;
import xhu.wncg.firesystem.modules.controller.vo.PictureVO;
import xhu.wncg.firesystem.modules.controller.qo.PictureQO;
/**
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:16
 */
@Service("pictureService")
public class PictureServiceImpl implements PictureService {
	@Autowired
	private PictureMapper pictureMapper;
	
	@Override
	public PictureVO queryObject(Integer pictureId){
		return pictureMapper.queryObject(pictureId);
	}
	
	@Override
	public List<PictureVO> queryList(Map<String, Object> map){
		return pictureMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return pictureMapper.queryTotal(map);
	}
	
	@Override
	public void save(PictureQO picture){
		pictureMapper.save(picture);
	}
	
	@Override
	public void update(PictureQO picture){
		pictureMapper.update(picture);
	}
	
	@Override
	public void delete(Integer pictureId){
		pictureMapper.delete(pictureId);
	}
	
	@Override
	public void deleteBatch(Integer[] pictureIds){
		pictureMapper.deleteBatch(pictureIds);
	}
	
}
