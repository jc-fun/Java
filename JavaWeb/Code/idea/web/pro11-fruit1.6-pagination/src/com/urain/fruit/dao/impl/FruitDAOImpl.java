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
    public List<Fruit> getFruitList(Integer pageNo) {
        return super.executeQuery("select * from t_fruit limit ?, 5", (pageNo - 1) * 5);
    }

    @Override
    public Fruit getFruitByFid(Integer fid) {
        return super.load("select * from t_fruit where fid = ?", fid);
    }

    @Override
    public void updateFruit(Fruit fruit) {
        String sql = "update t_fruit set fname = ?, price = ?, fcount = ?, remark = ? where fid = ?";
        super.executeUpdate(sql, fruit.getFname(), fruit.getPrice(), fruit.getFcount(), fruit.getRemark(), fruit.getFid());
    }

    @Override
    public void delFruit(Integer fid) {
        super.executeUpdate("delete from t_fruit where fid = ?", fid);
    }

    @Override
    public void addFruit(Fruit fruit) {
        String sql = "insert into t_fruit values(0, ?, ?, ?, ?)";
        super.executeUpdate(sql, fruit.getFname(), fruit.getPrice(), fruit.getFcount(), fruit.getRemark());
    }

    @Override
    public long getFruitCount() {
        return (long)super.executeComplexQuery("select count(*) from t_fruit")[0];
    }
}
