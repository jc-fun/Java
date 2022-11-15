package com.urain.fruit.dao;

import com.urain.fruit.pojo.Fruit;

import java.util.List;

/**
 * @Author: supertain
 * @Date: 2022/4/7 9:55
 * @Description:
 */
public interface FruitDAO {
    // 获取指定页码上的所有的库存列表信息,每页显示5条
    List<Fruit> getFruitList(Integer pageNo);

    // 根据fid获取特定的水果库存信息
    Fruit getFruitByFid(Integer fid);

    // 修改指定的库存记录
    void updateFruit(Fruit fruit);

    // 根据fid删除指定的库存记录
    void delFruit(Integer fid);

    // 添加新库存记录
    void addFruit(Fruit fruit);

    // 查询库存总记录条数
    long getFruitCount();
}
