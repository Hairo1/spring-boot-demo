package com.hairo.springbootshiro.mappers;

import static com.hairo.springbootshiro.mappers.PermissionsDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.hairo.springbootshiro.entity.Permissions;
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
 *@date   ：2020/07/20 14:26
*/
@Mapper
public interface PermissionsMapper {
    BasicColumn[] selectList = BasicColumn.columnList(permissionsId, roleId, permissionsName);

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
    int insert(InsertStatementProvider<Permissions> insertStatement);

    /**
     * insertMultiple
     * @param multipleInsertStatement
     * @return 
     */
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Permissions> multipleInsertStatement);

    /**
     * selectOne
     * @param selectStatement
     * @return 
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PermissionsResult")
    Optional<Permissions> selectOne(SelectStatementProvider selectStatement);

    /**
     * selectMany
     * @param selectStatement
     * @return 
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PermissionsResult", value = {
        @Result(column="permissions_id", property="permissionsId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="permissions_name", property="permissionsName", jdbcType=JdbcType.VARCHAR)
    })
    List<Permissions> selectMany(SelectStatementProvider selectStatement);

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
        return MyBatis3Utils.countFrom(this::count, permissions, completer);
    }

    /**
     * delete
     * @param completer
     * @return 
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, permissions, completer);
    }

    /**
     * deleteByPrimaryKey
     * @return 
     */
    default int deleteByPrimaryKey(Integer permissionsId_) {
        return delete(c -> 
            c.where(permissionsId, isEqualTo(permissionsId_))
        );
    }

    /**
     * insert
     * @return 
     */
    default int insert(Permissions record) {
        return MyBatis3Utils.insert(this::insert, record, permissions, c ->
            c.map(permissionsId).toProperty("permissionsId")
            .map(roleId).toProperty("roleId")
            .map(permissionsName).toProperty("permissionsName")
        );
    }

    /**
     * insertMultiple
     * @return 
     */
    default int insertMultiple(Collection<Permissions> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, permissions, c ->
            c.map(permissionsId).toProperty("permissionsId")
            .map(roleId).toProperty("roleId")
            .map(permissionsName).toProperty("permissionsName")
        );
    }

    /**
     * insertSelective
     * @return 
     */
    default int insertSelective(Permissions record) {
        return MyBatis3Utils.insert(this::insert, record, permissions, c ->
            c.map(permissionsId).toPropertyWhenPresent("permissionsId", record::getPermissionsId)
            .map(roleId).toPropertyWhenPresent("roleId", record::getRoleId)
            .map(permissionsName).toPropertyWhenPresent("permissionsName", record::getPermissionsName)
        );
    }

    /**
     * selectOne
     * @param completer
     * @return 
     */
    default Optional<Permissions> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, permissions, completer);
    }

    /**
     * select
     * @param completer
     * @return 
     */
    default List<Permissions> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, permissions, completer);
    }

    /**
     * selectDistinct
     * @param completer
     * @return 
     */
    default List<Permissions> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, permissions, completer);
    }

    /**
     * selectByPrimaryKey
     * @return 
     */
    default Optional<Permissions> selectByPrimaryKey(Integer permissionsId_) {
        return selectOne(c ->
            c.where(permissionsId, isEqualTo(permissionsId_))
        );
    }

    /**
     * update
     * @param completer
     * @return 
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, permissions, completer);
    }

    /**
     * updateAllColumns
     * @return 
     */
    static UpdateDSL<UpdateModel> updateAllColumns(Permissions record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(permissionsId).equalTo(record::getPermissionsId)
                .set(roleId).equalTo(record::getRoleId)
                .set(permissionsName).equalTo(record::getPermissionsName);
    }

    /**
     * updateSelectiveColumns
     * @return 
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Permissions record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(permissionsId).equalToWhenPresent(record::getPermissionsId)
                .set(roleId).equalToWhenPresent(record::getRoleId)
                .set(permissionsName).equalToWhenPresent(record::getPermissionsName);
    }

    /**
     * updateByPrimaryKey
     * @return 
     */
    default int updateByPrimaryKey(Permissions record) {
        return update(c ->
            c.set(roleId).equalTo(record::getRoleId)
            .set(permissionsName).equalTo(record::getPermissionsName)
            .where(permissionsId, isEqualTo(record::getPermissionsId))
        );
    }

    /**
     * updateByPrimaryKeySelective
     * @return 
     */
    default int updateByPrimaryKeySelective(Permissions record) {
        return update(c ->
            c.set(roleId).equalToWhenPresent(record::getRoleId)
            .set(permissionsName).equalToWhenPresent(record::getPermissionsName)
            .where(permissionsId, isEqualTo(record::getPermissionsId))
        );
    }
}