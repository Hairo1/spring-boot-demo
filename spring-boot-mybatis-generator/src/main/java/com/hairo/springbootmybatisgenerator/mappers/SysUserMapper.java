package com.hairo.springbootmybatisgenerator.mappers;

import static com.hairo.springbootmybatisgenerator.mappers.SysUserDynamicSqlSupport.*;

import com.hairo.springbootmybatisgenerator.entity.SysUser;
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
 *@date   ：2020/07/13 17:24
*/
@Mapper
public interface SysUserMapper {
    BasicColumn[] selectList = BasicColumn.columnList(userName, userPassword, userAge, userId, address);

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
    int insert(InsertStatementProvider<SysUser> insertStatement);

    /**
     * insertMultiple
     * @param multipleInsertStatement
     * @return 
     */
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<SysUser> multipleInsertStatement);

    /**
     * selectOne
     * @param selectStatement
     * @return 
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SysUserResult")
    Optional<SysUser> selectOne(SelectStatementProvider selectStatement);

    /**
     * selectMany
     * @param selectStatement
     * @return 
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SysUserResult", value = {
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_password", property="userPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_age", property="userAge", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR)
    })
    List<SysUser> selectMany(SelectStatementProvider selectStatement);

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
        return MyBatis3Utils.countFrom(this::count, sysUser, completer);
    }

    /**
     * delete
     * @param completer
     * @return 
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, sysUser, completer);
    }

    /**
     * insert
     * @return 
     */
    default int insert(SysUser record) {
        return MyBatis3Utils.insert(this::insert, record, sysUser, c ->
            c.map(userName).toProperty("userName")
            .map(userPassword).toProperty("userPassword")
            .map(userAge).toProperty("userAge")
            .map(userId).toProperty("userId")
            .map(address).toProperty("address")
        );
    }

    /**
     * insertMultiple
     * @return 
     */
    default int insertMultiple(Collection<SysUser> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, sysUser, c ->
            c.map(userName).toProperty("userName")
            .map(userPassword).toProperty("userPassword")
            .map(userAge).toProperty("userAge")
            .map(userId).toProperty("userId")
            .map(address).toProperty("address")
        );
    }

    /**
     * insertSelective
     * @return 
     */
    default int insertSelective(SysUser record) {
        return MyBatis3Utils.insert(this::insert, record, sysUser, c ->
            c.map(userName).toPropertyWhenPresent("userName", record::getUserName)
            .map(userPassword).toPropertyWhenPresent("userPassword", record::getUserPassword)
            .map(userAge).toPropertyWhenPresent("userAge", record::getUserAge)
            .map(userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(address).toPropertyWhenPresent("address", record::getAddress)
        );
    }

    /**
     * selectOne
     * @param completer
     * @return 
     */
    default Optional<SysUser> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, sysUser, completer);
    }

    /**
     * select
     * @param completer
     * @return 
     */
    default List<SysUser> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, sysUser, completer);
    }

    /**
     * selectDistinct
     * @param completer
     * @return 
     */
    default List<SysUser> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, sysUser, completer);
    }

    /**
     * update
     * @param completer
     * @return 
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, sysUser, completer);
    }

    /**
     * updateAllColumns
     * @return 
     */
    static UpdateDSL<UpdateModel> updateAllColumns(SysUser record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userName).equalTo(record::getUserName)
                .set(userPassword).equalTo(record::getUserPassword)
                .set(userAge).equalTo(record::getUserAge)
                .set(userId).equalTo(record::getUserId)
                .set(address).equalTo(record::getAddress);
    }

    /**
     * updateSelectiveColumns
     * @return 
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(SysUser record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userName).equalToWhenPresent(record::getUserName)
                .set(userPassword).equalToWhenPresent(record::getUserPassword)
                .set(userAge).equalToWhenPresent(record::getUserAge)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(address).equalToWhenPresent(record::getAddress);
    }
}