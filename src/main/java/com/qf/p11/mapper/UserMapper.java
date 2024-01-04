package com.qf.p11.mapper;

import com.qf.p11.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 12709
* @description 针对表【user(用户模块的用户实体)】的数据库操作Mapper
* @createDate 2023-12-26 15:01:02
* @Entity com.qf.p11.pojo.User
*/

@Mapper
public interface UserMapper {
    List<User> selectAllUser();

    int insertSingleUser(User user);

    User selectCountByUsername(String username);

    User selectUserByNameAndPwd(@Param("uName") String uName, @Param("uPassword") String uPassword);

    int deleteByUId(int uid);

    List<User> selectUserByNameAndSex(@Param("uName") String uName,@Param("uSex") String uSex);

    int updateUStatusByUId(int uId);

    User selectUserById(int uId);

    User selectUserByName(String uName);
}




