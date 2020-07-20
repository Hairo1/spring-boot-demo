package com.hairo.springbootmybatisdynamicsql.mappers;

import java.sql.JDBCType;
import java.util.Date;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

/**
 * @author Hairo
 */
public final class OrderDynamicSqlSupport {
    public static final Order order = new Order();

    /**
     * 
     *   订单ID
     */
    public static final SqlColumn<String> orderId = order.orderId;

    /**
     * 
     *   订单名称
     */
    public static final SqlColumn<String> orderName = order.orderName;

    /**
     * 
     *   订单数量
     */
    public static final SqlColumn<Integer> orderSize = order.orderSize;

    /**
     * 
     *   用户ID
     */
    public static final SqlColumn<Integer> userId = order.userId;

    /**
     * 
     *   单价
     */
    public static final SqlColumn<Double> price = order.price;

    /**
     * 
     *   下单时间
     */
    public static final SqlColumn<Date> importTime = order.importTime;

    public static final class Order extends SqlTable {

        public final SqlColumn<String> orderId = column("order_id", JDBCType.VARCHAR);

        public final SqlColumn<String> orderName = column("order_name", JDBCType.VARCHAR);

        public final SqlColumn<Integer> orderSize = column("order_size", JDBCType.INTEGER);

        public final SqlColumn<Integer> userId = column("user_id", JDBCType.INTEGER);

        public final SqlColumn<Double> price = column("price", JDBCType.DOUBLE);

        public final SqlColumn<Date> importTime = column("import_time", JDBCType.TIMESTAMP);

        public Order() {
            super("\"order\"");
        }
    }
}