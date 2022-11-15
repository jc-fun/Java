package com.urain.fruit.service.impl;

import com.urain.fruit.dao.FruitDAO;
import com.urain.fruit.pojo.Fruit;
import com.urain.fruit.service.FruitService;

import java.util.List;

/**
 * @Author: supertain
 * @Date: 2022/4/10 12:04
 * @Description:
 */
public class FruitServiceImpl implements FruitService {
    private FruitDAO fruitDAO =null;
    @Override
    public List<Fruit> getFruitList(String keyword, Integer pageNo) {
        return fruitDAO.getFruitList(keyword, pageNo);
    }

    @Override
    public void addFruit(Fruit fruit) {
        fruitDAO.addFruit(fruit);
    }

    @Override
    public Fruit getFruitByFid(Integer fid) {
        return fruitDAO.getFruitByFid(fid);
    }

    @Override
    public void delFruit(Integer fid) {
        fruitDAO.delFruit(fid);
    }

    @Override
    public long getPageCount(String keyword) {
        long count = fruitDAO.getFruitCount(keyword);
        return (count / 5) + 1;
    }

    @Override
    public void updateFruit(Fruit fruit) {
        fruitDAO.updateFruit(fruit);
    }
}
