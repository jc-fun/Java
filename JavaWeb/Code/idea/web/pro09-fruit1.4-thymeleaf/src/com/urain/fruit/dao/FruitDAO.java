package com.urain.fruit.dao;

import com.urain.fruit.pojo.Fruit;

import java.util.List;

/**
 * @Author: supertain
 * @Date: 2022/4/7 9:55
 * @Description:
 */
public interface FruitDAO {
    // 获取所有的库存列表信息
    List<Fruit> getFruitList();
}
