package com.hairo.springbootmybatisdynamicsql.mappers;

import static com.hairo.springbootmybatisdynamicsql.mappers.OrderDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.hairo.springbootmybatisdynamicsql.entity.Order;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

/**
 *@author ： Hairo
 *@date   ：2020/07/14 09:44
*/
@Mapper
public interface OrderMapper {
    BasicColumn[] selectList = BasicColumn.columnList(orderId, orderName, orderSize, userId, price, importTime);

    /**
     * count
     * @param selectStatement
     * @return 
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    /**
     * delete
     * @param deleteStatement
     * @return 
     */
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    /**
     * insert
     * @param insertStatement
     * @return 
     */
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Order> insertStatement);

    /**
     * insertMultiple
     * @param multipleInsertStatement
     * @return 
     */
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Order> multipleInsertStatement);

    /**
     * selectOne
     * @param selectStatement
     * @return 
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("OrderResult")
    Optional<Order> selectOne(SelectStatementProvider selectStatement);

    /**
     * selectMany
     * @param selectStatement
     * @return 
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="OrderResult", value = {
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="order_name", property="orderName", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_size", property="orderSize", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="price", property="price", jdbcType=JdbcType.DOUBLE),
        @Result(column="import_time", property="importTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Order> selectMany(SelectStatementProvider selectStatement);

    /**
     * update
     * @param updateStatement
     * @return 
     */
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    /**
     * count
     * @param completer
     * @return 
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, order, completer);
    }

    /**
     * delete
     * @param completer
     * @return 
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, order, completer);
    }

    /**
     * deleteByPrimaryKey
     * @return 
     */
    default int deleteByPrimaryKey(String orderId_) {
        return delete(c -> 
            c.where(orderId, isEqualTo(orderId_))
        );
    }

    /**
     * insert
     * @return 
     */
    default int insert(Order record) {
        return MyBatis3Utils.insert(this::insert, record, order, c ->
            c.map(orderId).toProperty("orderId")
            .map(orderName).toProperty("orderName")
            .map(orderSize).toProperty("orderSize")
            .map(userId).toProperty("userId")
            .map(price).toProperty("price")
            .map(importTime).toProperty("importTime")
        );
    }

    /**
     * insertMultiple
     * @return 
     */
    default int insertMultiple(Collection<Order> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, order, c ->
            c.map(orderId).toProperty("orderId")
            .map(orderName).toProperty("orderName")
            .map(orderSize).toProperty("orderSize")
            .map(userId).toProperty("userId")
            .map(price).toProperty("price")
            .map(importTime).toProperty("importTime")
        );
    }

    /**
     * insertSelective
     * @return 
     */
    default int insertSelective(Order record) {
        return MyBatis3Utils.insert(this::insert, record, order, c ->
            c.map(orderId).toPropertyWhenPresent("orderId", record::getOrderId)
            .map(orderName).toPropertyWhenPresent("orderName", record::getOrderName)
            .map(orderSize).toPropertyWhenPresent("orderSize", record::getOrderSize)
            .map(userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(price).toPropertyWhenPresent("price", record::getPrice)
            .map(importTime).toPropertyWhenPresent("importTime", record::getImportTime)
        );
    }

    /**
     * selectOne
     * @param completer
     * @return 
     */
    default Optional<Order> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, order, completer);
    }

    /**
     * select
     * @param completer
     * @return 
     */
    default List<Order> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, order, completer);
    }

    /**
     * selectDistinct
     * @param completer
     * @return 
     */
    default List<Order> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, order, completer);
    }

    /**
     * selectByPrimaryKey
     * @return 
     */
    default Optional<Order> selectByPrimaryKey(String orderId_) {
        return selectOne(c ->
            c.where(orderId, isEqualTo(orderId_))
        );
    }

    /**
     * update
     * @param completer
     * @return 
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, order, completer);
    }

    /**
     * updateAllColumns
     * @return 
     */
    static UpdateDSL<UpdateModel> updateAllColumns(Order record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(orderId).equalTo(record::getOrderId)
                .set(orderName).equalTo(record::getOrderName)
                .set(orderSize).equalTo(record::getOrderSize)
                .set(userId).equalTo(record::getUserId)
                .set(price).equalTo(record::getPrice)
                .set(importTime).equalTo(record::getImportTime);
    }

    /**
     * updateSelectiveColumns
     * @return 
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Order record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(orderId).equalToWhenPresent(record::getOrderId)
                .set(orderName).equalToWhenPresent(record::getOrderName)
                .set(orderSize).equalToWhenPresent(record::getOrderSize)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(price).equalToWhenPresent(record::getPrice)
                .set(importTime).equalToWhenPresent(record::getImportTime);
    }

    /**
     * updateByPrimaryKey
     * @return 
     */
    default int updateByPrimaryKey(Order record) {
        return update(c ->
            c.set(orderName).equalTo(record::getOrderName)
            .set(orderSize).equalTo(record::getOrderSize)
            .set(userId).equalTo(record::getUserId)
            .set(price).equalTo(record::getPrice)
            .set(importTime).equalTo(record::getImportTime)
            .where(orderId, isEqualTo(record::getOrderId))
        );
    }

    /**
     * updateByPrimaryKeySelective
     * @return 
     */
    default int updateByPrimaryKeySelective(Order record) {
        return update(c ->
            c.set(orderName).equalToWhenPresent(record::getOrderName)
            .set(orderSize).equalToWhenPresent(record::getOrderSize)
            .set(userId).equalToWhenPresent(record::getUserId)
            .set(price).equalToWhenPresent(record::getPrice)
            .set(importTime).equalToWhenPresent(record::getImportTime)
            .where(orderId, isEqualTo(record::getOrderId))
        );
    }
}