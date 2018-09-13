package com.nuc.sw.crm.service

import com.nuc.sw.crm.entity.Role
import com.nuc.sw.crm.entity.User

/**
 * @author 杨晓辉 2018-09-10 14:11
 */
interface UserService {

    /**
     * 添加用户
     * @param user 用户
     * @param role 角色
     */
    fun saveUser(user: User, role: Role): User


    /**
     * 获取所有用户
     * @return 所有用户
     */
    fun findAllUsers(): List<User>

    /**
     * 删除用户
     * @param user 用户
     */
    fun deleteUser(user: User)

    /**
     * 检查是否重名
     * @param username 用户名
     */
    fun checkUsername(username: String): String

    /**
     * 更新user
     * @param user 用户
     */
    fun updateUserInfo(user: User)
}