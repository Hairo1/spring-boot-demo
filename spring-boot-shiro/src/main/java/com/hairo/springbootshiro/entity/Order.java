package com.hairo.springbootshiro.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *@author ： Hairo
 *@date   ：2020/07/20 14:26
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
    /**
     * 
     *   订单ID
     */
    private String orderId;

    /**
     * 
     *   订单名称
     */
    private String orderName;

    /**
     * 
     *   订单数量
     */
    private Integer orderSize;

    /**
     * 
     *   用户ID
     */
    private Integer userId;

    /**
     * 
     *   单价
     */
    private Double price;

    /**
     * 
     *   下单时间
     */
    private Date importTime;

    private static final long serialVersionUID = 1L;
}