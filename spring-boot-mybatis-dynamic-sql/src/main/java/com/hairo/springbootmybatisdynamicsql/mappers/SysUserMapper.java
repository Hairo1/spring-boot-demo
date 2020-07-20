package com.hairo.springbootmybatisdynamicsql.mappers;

import static com.hairo.springbootmybatisdynamicsql.mappers.SysUserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.hairo.springbootmybatisdynamicsql.entity.SysUser;
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
public interface SysUserMapper {
    BasicColumn[] selectList = BasicColumn.columnList(userId, userName, userPassword, userAge, address);

    /**
     * count
     * @param selectStatement 1
     * @return  11 11
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    /**
     * delete
     * @param deleteStatement 1
     * @return  11 11
     */
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    /**
     * insert
     * @param insertStatement 1
     * @return  11 11
     */
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<SysUser> insertStatement);

    /**
     * insertMultiple
     * @param multipleInsertStatement 1
     * @return  11 11
     */
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<SysUser> multipleInsertStatement);

    /**
     * selectOne
     * @param selectStatement
     * @return  11 11
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SysUserResult")
    Optional<SysUser> selectOne(SelectStatementProvider selectStatement);

    /**
     * selectMany
     * @param selectStatement 1
     * @return  11 11
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SysUserResult", value = {
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_password", property="userPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_age", property="userAge", jdbcType=JdbcType.INTEGER),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR)
    })
    List<SysUser> selectMany(SelectStatementProvider selectStatement);

    /**
     * update
     * @param updateStatement 1
     * @return  11 11
     */
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    /**
     * count
     * @param completer 1
     * @return  11 11
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, sysUser, completer);
    }

    /**
     * delete
     * @param completer 1
     * @return  11 11
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, sysUser, completer);
    }

    /**
     * deleteByPrimaryKey
     * @param userId_ 1
     * @return  11 11
     */
    default int deleteByPrimaryKey(Integer userId_) {
        return delete(c -> 
            c.where(userId, isEqualTo(userId_))
        );
    }

    /**
     * insert
     * @param record a
     * @return  11 11
     */
    default int insert(SysUser record) {
        return MyBatis3Utils.insert(this::insert, record, sysUser, c ->
            c.map(userId).toProperty("userId")
            .map(userName).toProperty("userName")
            .map(userPassword).toProperty("userPassword")
            .map(userAge).toProperty("userAge")
            .map(address).toProperty("address")
        );
    }

    /**
     * insertMultiple
     * @param records u
     * @return  11 11插入行数
     */
    default int insertMultiple(Collection<SysUser> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, sysUser, c ->
            c.map(userId).toProperty("userId")
            .map(userName).toProperty("userName")
            .map(userPassword).toProperty("userPassword")
            .map(userAge).toProperty("userAge")
            .map(address).toProperty("address")
        );
    }

    /**
     * insertSelective
     * @return  11 11
     */
    default int insertSelective(SysUser record) {
        return MyBatis3Utils.insert(this::insert, record, sysUser, c ->
            c.map(userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(userName).toPropertyWhenPresent("userName", record::getUserName)
            .map(userPassword).toPropertyWhenPresent("userPassword", record::getUserPassword)
            .map(userAge).toPropertyWhenPresent("userAge", record::getUserAge)
            .map(address).toPropertyWhenPresent("address", record::getAddress)
        );
    }

    /**
     * selectOne
     * @param completer
     * @return  11 11一行数据
     */
    default Optional<SysUser> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, sysUser, completer);
    }

    /**
     * select
     * @param completer 1
     * @return  11 111
     */
    default List<SysUser> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, sysUser, completer);
    }

    /**
     * selectDistinct
     * @param completer 1
     * @return  11 11
     */
    default List<SysUser> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, sysUser, completer);
    }

    /**
     * selectByPrimaryKey
     * @return  11 11
     */
    default Optional<SysUser> selectByPrimaryKey(Integer userId_) {
        return selectOne(c ->
            c.where(userId, isEqualTo(userId_))
        );
    }

    /**
     * update
     * @param completer 1
     * @return  11 11
     */
    default int update(final UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, sysUser, completer);
    }

    /**
     * updateAllColumns
     * @param dsl  a
     * @param record a
     * @return  11 11
     */
    static UpdateDSL<UpdateModel> updateAllColumns(SysUser record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalTo(record::getUserId)
                .set(userName).equalTo(record::getUserName)
                .set(userPassword).equalTo(record::getUserPassword)
                .set(userAge).equalTo(record::getUserAge)
                .set(address).equalTo(record::getAddress);
    }

    /**
     * updateSelectiveColumns
     * @param record 1
     * @param dsl 1
     * @return  11 11
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(SysUser record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalToWhenPresent(record::getUserId)
                .set(userName).equalToWhenPresent(record::getUserName)
                .set(userPassword).equalToWhenPresent(record::getUserPassword)
                .set(userAge).equalToWhenPresent(record::getUserAge)
                .set(address).equalToWhenPresent(record::getAddress);
    }

    /**
     * updateByPrimaryKey
     * @return  11 11
     */
    default int updateByPrimaryKey(SysUser record) {
        return update(c ->
            c.set(userName).equalTo(record::getUserName)
            .set(userPassword).equalTo(record::getUserPassword)
            .set(userAge).equalTo(record::getUserAge)
            .set(address).equalTo(record::getAddress)
            .where(userId, isEqualTo(record::getUserId))
        );
    }

    /**
     * updateByPrimaryKeySelective
     * @param record s
     * @return  11 11
     */
    default int updateByPrimaryKeySelective(final SysUser record) {
        return this.update(c ->
            c.set(userName).equalToWhenPresent(record::getUserName)
            .set(userPassword).equalToWhenPresent(record::getUserPassword)
            .set(userAge).equalToWhenPresent(record::getUserAge)
            .set(address).equalToWhenPresent(record::getAddress)
            .where(userId, isEqualTo(record::getUserId))
        );
    }
}