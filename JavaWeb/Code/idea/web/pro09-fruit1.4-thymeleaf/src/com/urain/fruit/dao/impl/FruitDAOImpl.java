package com.urain.fruit.dao.impl;

import com.urain.fruit.dao.FruitDAO;
import com.urain.fruit.pojo.Fruit;
import com.urain.myssm.basedao.BaseDAO;

import java.util.List;

/**
 * @Author: supertain
 * @Date: 2022/4/7 9:56
 * @Description:
 */
public class FruitDAOImpl extends BaseDAO<Fruit> implements FruitDAO {

    @Override
    public List<Fruit> getFruitList() {
        return super.executeQuery("select * from t_fruit");
    }
}
