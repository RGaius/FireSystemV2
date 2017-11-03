package xhu.wncg.common.mapper;

import java.util.List;
import java.util.Map;

/**
 * T 为查询对象
 * K 为返回对象
 * @author BZhao
 * @version 2017/10/24.
 */
public interface BaseMapper<T, K> {
    /**
     * 保存
     * @param k
     */
    void save(T k);

    /**
     * 保存
     * @param map
     */
    void save(Map<String,Object> map);

    /**
     * 批量保存
     * @param list
     */
    void saveBatch(List<T> list);

    /**
     * 更新
     * @param t
     * @return int
     */
    int update(T t);

    /**
     * 批量更新
     * @param list
     * @return
     */
    int updateBatch(List<T> list);

    /**
     * 删除
     * @param id
     * @return
     */
    int delete(Object id);

    /**
     * 删除
     * @param map
     * @return
     */
    int delete(Map<String, Object> map);

    /**
     * 批量删除
     * @param id
     * @return
     */
    int deleteBatch(Object[] id);

    /**
     * 查询单条数据
     * @param id
     * @return
     */
    K queryObject(Object id);

    /**
     * 查询多条数据
     * @param map
     * @return
     */
    List<K> queryList(Map<String, Object> map);

    /**
     * 查询
     * @param id
     * @return
     */
    List<K> queryList(Object id);

    /**
     * 查询条数
     * @param map
     * @return
     */
    int queryTotal(Map<String, Object> map);

    /**
     *  总条数
     * @return
     */
    int queryTotal();
}
