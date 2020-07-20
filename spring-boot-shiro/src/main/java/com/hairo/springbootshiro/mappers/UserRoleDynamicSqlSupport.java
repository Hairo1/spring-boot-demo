package com.hairo.springbootshiro.mappers;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserRoleDynamicSqlSupport {
    public static final UserRole userRole = new UserRole();

    public static final SqlColumn<Integer> roleId = userRole.roleId;

    public static final SqlColumn<String> roleName = userRole.roleName;

    public static final class UserRole extends SqlTable {
        public final SqlColumn<Integer> roleId = column("role_id", JDBCType.INTEGER);

        public final SqlColumn<String> roleName = column("role_name", JDBCType.VARCHAR);

        public UserRole() {
            super("user_role");
        }
    }
}