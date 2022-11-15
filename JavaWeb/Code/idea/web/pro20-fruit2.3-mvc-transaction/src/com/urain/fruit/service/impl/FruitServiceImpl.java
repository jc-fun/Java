package com.urain.fruit.service.impl;

import com.urain.fruit.dao.FruitDAO;
import com.urain.fruit.pojo.Fruit;
import com.urain.fruit.service.FruitService;
import com.urain.myssm.basedao.ConnUtil;

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
        System.out.println("getFruitList ->" + ConnUtil.getConn());
        return fruitDAO.getFruitList(keyword, pageNo);
    }

    @Override
    public void addFruit(Fruit fruit) {
        fruitDAO.addFruit(fruit);
        Fruit fruit2 = fruitDAO.getFruitByFid(2);
        fruit2.setFcount(200);
        fruitDAO.updateFruit(fruit2);
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
        System.out.println("getPageCount ->" + ConnUtil.getConn());

        long count = fruitDAO.getFruitCount(keyword);
        return (count / 5) + 1;
    }

    @Override
    public void updateFruit(Fruit fruit) {
        fruitDAO.updateFruit(fruit);
    }
}
