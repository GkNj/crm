package com.nuc.sw.crm.controller

import com.nuc.sw.crm.entity.Role
import com.nuc.sw.crm.entity.User
import com.nuc.sw.crm.repository.UserRepository
import com.nuc.sw.crm.service.UserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

/**
 * @author 杨晓辉 2018-09-07 9:23
 * 权限管理控制层
 */
@Controller
@RequestMapping("/permission")
class PermissionController {

    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    private val baseUrl = "permission/"

    private val permission = "permission"

    @Autowired
    private lateinit var userService: UserService

    @RequestMapping("/{path}")
    fun toHtml(@PathVariable("path") path: String): String {
        return "permission/$path"
    }

    /**
     * 添加用户
     */
    @RequestMapping("/add")
    fun addUser(user: User, map: ModelMap): String {

        logger.info("user is " + user.toString())
        var roleId: Long
        logger.info("user position ${user.position}")
        roleId = when (user.position) {
            "ROOT" -> {
                1L
            }
            "ADMIN" -> {
                2L
            }
            "AM" -> 3L
            "SA" -> 4L
            "SM" -> 5L
            else -> {
                0
            }
        }
        logger.info("user role id is $roleId")
        val role = Role()
        role.id = roleId
        userService.saveUser(user, role)

        return "forward:/${baseUrl}list"

    }

    /**
     * 获取所有用户
     */
    @RequestMapping("/list")
    fun listUsers(map: ModelMap): String {
        val users = userService.findAllUsers()
        logger.info(users.toString())
        map["users"] = users
        return baseUrl + permission
    }


    @RequestMapping("/update")
    fun updateUser(user: User): String {
        logger.info("update user is $user")

        userService.updateUserInfo(user)

        return "forward:/${baseUrl}list"
    }
}