package com.hairo.springbootshiro.mappers;

import static com.hairo.springbootshiro.mappers.UserRoleDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.hairo.springbootshiro.entity.UserRole;
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
public interface UserRoleMapper {
    BasicColumn[] selectList = BasicColumn.columnList(roleId, roleName);

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
    int insert(InsertStatementProvider<UserRole> insertStatement);

    /**
     * insertMultiple
     * @param multipleInsertStatement
     * @return 
     */
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<UserRole> multipleInsertStatement);

    /**
     * selectOne
     * @param selectStatement
     * @return 
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserRoleResult")
    Optional<UserRole> selectOne(SelectStatementProvider selectStatement);

    /**
     * selectMany
     * @param selectStatement
     * @return 
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserRoleResult", value = {
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR)
    })
    List<UserRole> selectMany(SelectStatementProvider selectStatement);

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
        return MyBatis3Utils.countFrom(this::count, userRole, completer);
    }

    /**
     * delete
     * @param completer
     * @return 
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, userRole, completer);
    }

    /**
     * deleteByPrimaryKey
     * @return 
     */
    default int deleteByPrimaryKey(Integer roleId_) {
        return delete(c -> 
            c.where(roleId, isEqualTo(roleId_))
        );
    }

    /**
     * insert
     * @return 
     */
    default int insert(UserRole record) {
        return MyBatis3Utils.insert(this::insert, record, userRole, c ->
            c.map(roleId).toProperty("roleId")
            .map(roleName).toProperty("roleName")
        );
    }

    /**
     * insertMultiple
     * @return 
     */
    default int insertMultiple(Collection<UserRole> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, userRole, c ->
            c.map(roleId).toProperty("roleId")
            .map(roleName).toProperty("roleName")
        );
    }

    /**
     * insertSelective
     * @return 
     */
    default int insertSelective(UserRole record) {
        return MyBatis3Utils.insert(this::insert, record, userRole, c ->
            c.map(roleId).toPropertyWhenPresent("roleId", record::getRoleId)
            .map(roleName).toPropertyWhenPresent("roleName", record::getRoleName)
        );
    }

    /**
     * selectOne
     * @param completer
     * @return 
     */
    default Optional<UserRole> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, userRole, completer);
    }

    /**
     * select
     * @param completer
     * @return 
     */
    default List<UserRole> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, userRole, completer);
    }

    /**
     * selectDistinct
     * @param completer
     * @return 
     */
    default List<UserRole> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, userRole, completer);
    }

    /**
     * selectByPrimaryKey
     * @return 
     */
    default Optional<UserRole> selectByPrimaryKey(Integer roleId_) {
        return selectOne(c ->
            c.where(roleId, isEqualTo(roleId_))
        );
    }

    /**
     * update
     * @param completer
     * @return 
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, userRole, completer);
    }

    /**
     * updateAllColumns
     * @return 
     */
    static UpdateDSL<UpdateModel> updateAllColumns(UserRole record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(roleId).equalTo(record::getRoleId)
                .set(roleName).equalTo(record::getRoleName);
    }

    /**
     * updateSelectiveColumns
     * @return 
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(UserRole record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(roleId).equalToWhenPresent(record::getRoleId)
                .set(roleName).equalToWhenPresent(record::getRoleName);
    }

    /**
     * updateByPrimaryKey
     * @return 
     */
    default int updateByPrimaryKey(UserRole record) {
        return update(c ->
            c.set(roleName).equalTo(record::getRoleName)
            .where(roleId, isEqualTo(record::getRoleId))
        );
    }

    /**
     * updateByPrimaryKeySelective
     * @return 
     */
    default int updateByPrimaryKeySelective(UserRole record) {
        return update(c ->
            c.set(roleName).equalToWhenPresent(record::getRoleName)
            .where(roleId, isEqualTo(record::getRoleId))
        );
    }
}