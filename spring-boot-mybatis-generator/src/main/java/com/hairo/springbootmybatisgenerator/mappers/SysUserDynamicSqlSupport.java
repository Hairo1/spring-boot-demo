package com.hairo.springbootmybatisgenerator.mappers;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

/**
 * @author Hairo
 */
public final class SysUserDynamicSqlSupport {
    public static final SysUser sysUser = new SysUser();

    /**
     * 
     *   用户名
     */
    public static final SqlColumn<String> userName = sysUser.userName;

    /**
     * 
     *   密码
     */
    public static final SqlColumn<String> userPassword = sysUser.userPassword;

    /**
     * 
     *   年龄
     */
    public static final SqlColumn<Integer> userAge = sysUser.userAge;

    /**
     * 
     *   用户ID
     */
    public static final SqlColumn<Integer> userId = sysUser.userId;

    /**
     * 
     *   地址
     */
    public static final SqlColumn<String> address = sysUser.address;

    public static final class SysUser extends SqlTable {
        public final SqlColumn<String> userName = column("user_name", JDBCType.VARCHAR);

        public final SqlColumn<String> userPassword = column("user_password", JDBCType.VARCHAR);

        public final SqlColumn<Integer> userAge = column("user_age", JDBCType.INTEGER);

        public final SqlColumn<Integer> userId = column("user_id", JDBCType.INTEGER);

        public final SqlColumn<String> address = column("address", JDBCType.VARCHAR);

        public SysUser() {
            super("sys_user");
        }
    }
}