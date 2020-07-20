package com.hairo.springbootmybatis_enum.code.handler;

import com.hairo.springbootmybatis_enum.code.enums.*;
import org.apache.ibatis.type.MappedTypes;

/**
 * @author ： Hairo
 * @date : 2020/6/13 20:18
 */

@MappedTypes(value = { City.class, SceneType.class,AreaType.class,CellType.class,Vendor.class,Architecture.class})
public class EnumTypeHandler<E extends Enum<E>> extends BaseEnumTypeHandler<E> {
    public EnumTypeHandler(Class<E> type) {
        super(type);
    }
}
