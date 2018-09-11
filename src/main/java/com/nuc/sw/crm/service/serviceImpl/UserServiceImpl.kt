package com.nuc.sw.crm.service.serviceImpl

import com.nuc.sw.crm.entity.Role
import com.nuc.sw.crm.entity.User
import com.nuc.sw.crm.entity.UserAndRole
import com.nuc.sw.crm.repository.RoleRepository
import com.nuc.sw.crm.repository.UserAndRoleRepository
import com.nuc.sw.crm.repository.UserRepository
import com.nuc.sw.crm.service.UserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * @author 杨晓辉 2018-09-07 9:43
 * 用户service
 */
@Service
class UserServiceImpl : UserDetailsService, UserService {
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)


    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var roleRepository: RoleRepository

    @Autowired
    private lateinit var userAndRoleRepository: UserAndRoleRepository

    /**
     * 加载用户密码判断数据库密码和输入密码是否正确
     * @param username 登录用户名
     */
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findUserByUsername(username)?.get(0)
        logger.info("user is $user")
        return user!!
    }


    /**
     * 添加用户
     * @param user 用户
     * @param role 角色
     */
    @Transactional
    override fun saveUser(user: User, role: Role): User {


        val encoder = BCryptPasswordEncoder()
        user.password = encoder.encode(user.password.trim())
        val userDB = userRepository.save(user)
        val userAndRole = UserAndRole()
        userAndRole.roleId = role.id
        userAndRole.userId = userDB.id
        userAndRoleRepository.save(userAndRole)
        return user
    }


    /**
     * 获取所有用户
     */
    override fun findAllUsers(): List<User> {
        val users = userRepository.findAll()
        users.map {
            val userAndRoles = userAndRoleRepository.findUserAndRoleByUserId(it.id)
            it.roles = userAndRoles.map { userAndRole ->
                roleRepository.getOne(userAndRole.roleId)
            }

//            it.roles.add(roleRepository.getOne(roleId.roleId))

        }

        logger.info(users.toString())
        return users
    }


    /**
     * 根据用户删除用户角色表里的关联关系
     */
    @Transactional
    override fun deleteUser(user: User) {
        userRepository.delete(user)
        userAndRoleRepository.deleteByUserId(user.id)
    }


    override fun checkUsername(username: String): String {
        val result: String

        val user = userRepository.findUserByUsername(username)

        if (user?.size == 0) {
            result = "200"
        } else {
            result = "201"
        }
        return result


    }
}