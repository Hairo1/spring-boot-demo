package com.hairo.springbootshiro.mappers;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class PermissionsDynamicSqlSupport {
    public static final Permissions permissions = new Permissions();

    public static final SqlColumn<Integer> permissionsId = permissions.permissionsId;

    public static final SqlColumn<Integer> roleId = permissions.roleId;

    public static final SqlColumn<String> permissionsName = permissions.permissionsName;

    public static final class Permissions extends SqlTable {
        public final SqlColumn<Integer> permissionsId = column("permissions_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> roleId = column("role_id", JDBCType.INTEGER);

        public final SqlColumn<String> permissionsName = column("permissions_name", JDBCType.VARCHAR);

        public Permissions() {
            super("permissions");
        }
    }
}