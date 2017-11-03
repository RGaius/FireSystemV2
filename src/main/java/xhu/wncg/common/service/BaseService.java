package xhu.wncg.common.service;

import java.util.List;
import java.util.Map;

/**
 * T 为查询对象
 * K 为返回对象
 * @author BZhao
 * @version 2017/10/24.
 */
public interface BaseService<T, K> {
    /**
     * 查询对象
     * @param id
     * @return object
     */
    K queryObject(Integer id);

    /**
     * 查询列表
     * @param map
     * @return list
     */
    List<K> queryList(Map<String, Object> map);

    /**
     * 统计条数
     * @param map
     * @return int
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存
     * @param t
     */
    void save(T t);

    /**
     * 更新
     * @param t
     */
    void update(T t);

    /**
     * 删除
     * @param id
     */
    void delete(Integer id);

    /**
     * 批量删除
     * @param ids
     */
    void deleteBatch(Integer[] ids);
}
