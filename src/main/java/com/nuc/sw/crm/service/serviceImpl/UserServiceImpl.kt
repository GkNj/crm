package com.nuc.sw.crm.service.serviceImpl

import com.nuc.sw.crm.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

/**
 * @author 杨晓辉 2018-09-07 9:43
 * 用户service
 */
@Service
class UserServiceImpl : UserDetailsService {

    @Autowired
    private lateinit var userRepository: UserRepository


    /**
     * 加载用户密码判断数据库密码和输入密码是否正确
     * @param username 登录用户名
     */
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findUserByUsername(username)
        println("user is $user")

        return user
    }
}
