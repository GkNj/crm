package com.nuc.sw.crm.controller

import com.nuc.sw.crm.entity.User
import com.nuc.sw.crm.service.UserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author 杨晓辉 2018-09-11 8:48
 */
@RestController
@RequestMapping("/permission")
class PermissionRestController {

    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)


    @Autowired
    private lateinit var userService: UserService


    /**
     * 检查用户名是否重复
     */
    @RequestMapping("/checkUsername")
    fun checkUsername(username: String): String {
        logger.info("username is $username")
        return userService.checkUsername(username)
    }


    /**
     * 删除指定用户
     */
    @RequestMapping("/del")
    fun deleteUser(userId: Long): String {
        val user = User()
        user.id = userId
        logger.info("user is $user")
        userService.deleteUser(user)
        return "200"
    }
}