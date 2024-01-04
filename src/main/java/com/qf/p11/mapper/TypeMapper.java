package com.qf.p11.mapper;

import com.qf.p11.pojo.Type;

import java.util.List;

/**
* @author 12709
* @description 针对表【type(商品模块的类别实体)】的数据库操作Mapper
* @createDate 2023-12-26 15:01:02
* @Entity com.qf.p11.pojo.Type
*/
public interface TypeMapper {
    List<Type> selectAllType();
}




