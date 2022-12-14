package com.pirvate.store.mapper;

import com.pirvate.store.entity.Cart;
import com.pirvate.store.entity.CartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CartMapper {



    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cart
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    int countByExample(CartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cart
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    int deleteByExample(CartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cart
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    int deleteByPrimaryKey(Integer cid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cart
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    int insert(Cart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cart
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    int insertSelective(Cart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cart
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    List<Cart> selectByExample(CartExample example);

    /**
     *  自定义查询 购物车和商品表联查
     * @param example
     * @return
     */
    List<Cart> selectByExampleWithProduct(CartExample example);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cart
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    Cart selectByPrimaryKey(Integer cid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cart
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    int updateByExampleSelective(@Param("record") Cart record, @Param("example") CartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cart
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    int updateByExample(@Param("record") Cart record, @Param("example") CartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cart
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    int updateByPrimaryKeySelective(Cart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cart
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    int updateByPrimaryKey(Cart record);
}