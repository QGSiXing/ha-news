package com.hengan.news.dao.impl;

import com.hengan.news.dao.UserDAO;
import com.hengan.news.mapper.NewsMapper;
import com.hengan.news.mapper.UserAuthKeyMapper;
import com.hengan.news.mapper.UserMapper;
import com.hengan.news.model.po.NewsPO;
import com.hengan.news.model.po.UserAuthKeyPO;
import com.hengan.news.model.po.UserPO;
import com.hengan.news.model.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author Cyq
 * @Date 2019/4/26 14:17
 **/
@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserAuthKeyMapper userAuthKeyMapper;

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public UserPO findByWorkCode(String workCode) {
        UserPO user = new UserPO();
        user.setWorkCode(workCode);
        UserPO userPO = userMapper.selectOne(user);
        return userPO;
    }

    @Override
    public NewsPO getNew(String code) {
        System.out.println(22222);
        return newsMapper.selectByPrimaryKey("25040");
    }

    @Override
    public UserVO wxLogin(String code) {
        return null;
    }

    @Override
    public UserAuthKeyPO selectUserInfoByAuthKey(String authkey) {
        UserAuthKeyPO userAuthKeyPO = new UserAuthKeyPO();
        userAuthKeyPO.setAuthKey(authkey);
        UserAuthKeyPO userAuthKey = userAuthKeyMapper.selectOne(userAuthKeyPO);
        return userAuthKey;
    }
}
