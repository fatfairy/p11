package com.qf.p11.mapper;

import com.qf.p11.dto.ItemDTO;
import com.qf.p11.pojo.Item;
import com.qf.p11.vo.CartVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 12709
* @description 针对表【item(订单内部的具体商品展示项)】的数据库操作Mapper
* @createDate 2023-12-26 15:01:02
* @Entity com.qf.p11.pojo.Item
*/
public interface ItemMapper {
    int insertBatch(@Param("itemDTOS") List<ItemDTO> itemDTOS,@Param("oId") int oId);

    List<ItemDTO> selectProductForInsert(int uId);
}




