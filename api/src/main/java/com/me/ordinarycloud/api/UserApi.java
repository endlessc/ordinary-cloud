package com.me.ordinarycloud.api;

import com.me.ordinarycloud.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface UserApi {

    @RequestMapping(value = "/user/updateUserBalance", method = RequestMethod.POST)
    int updateUserBalance(@RequestBody User user);

}
