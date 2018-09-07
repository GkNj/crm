package com.nuc.sw.crm.controller

import com.nuc.sw.crm.repository.RoleRepository
import com.nuc.sw.crm.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * @author 杨晓辉 2018-09-07 9:23
 * 权限管理控制层
 */
@Controller
@RequestMapping("/permission")
class PermissionController {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var roleRepository: RoleRepository


//    @RequestMapping("/add")
//    fun addUser(): String {
//
//        val role = Role()
//        role.permission = Permission.ADMIN
//        roleRepository.save(role)
//
//        val user = User()
//        user.name = "zs"
//        user.position = "高管"
//        val roleList = listOf<Role>(role)
//        user.roles = roleList
//        user.password = "1234"
//        userRepository.save(user)
//        return "index"
//    }

}