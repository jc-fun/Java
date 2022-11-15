package com.urain.securitydemo1.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.urain.securitydemo1.entity.Users;
import com.urain.securitydemo1.mapper.UserMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: urain
 * @Date: 2022/5/14 22:43
 * @Description:
 * @Version: 1.0
 */
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 调用userMapper中的方法，根据用户名查询数据库
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        Users user = userMapper.selectOne(wrapper);
        if(user == null) {
            throw new UsernameNotFoundException("用户名不存在!");
        }

        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("admins, ROLE_sale");
        return new User(user.getUsername(), new BCryptPasswordEncoder().encode(user.getPassword()), auths);
    }
}
