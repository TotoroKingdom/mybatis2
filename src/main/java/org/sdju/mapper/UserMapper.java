package org.sdju.mapper;

import org.apache.ibatis.annotations.Param;
import org.sdju.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> getAllUsers();

    List<Map<String, Object>> getAllUsers2();

    List<User> getUserOrderBy(String orderby);

    List<User> getUserNameContains(String name);

    Integer updateUsernameById(@Param("username") String username, @Param("id") Integer id);

    Integer addUser(User user);

    Integer addUser2(HashMap<String,Object> map);

    User getUserById(Integer id);


}
