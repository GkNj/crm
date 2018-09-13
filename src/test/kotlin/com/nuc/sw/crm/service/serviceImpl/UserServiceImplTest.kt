package com.nuc.sw.crm.service.serviceImpl

import com.nuc.sw.crm.entity.Role
import com.nuc.sw.crm.entity.User
import com.nuc.sw.crm.repository.RoleRepository
import com.nuc.sw.crm.repository.UserRepository
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

/**
 * @author 杨晓辉 2018-09-13 14:00
 */
@SpringBootTest
@RunWith(SpringRunner::class)
class UserServiceImplTest {

    @Autowired
    private lateinit var roleRepository: RoleRepository

    @Autowired
    private lateinit var userRepository: UserRepository

    @Test
    fun getRole() {
        val user = User()


        val role = roleRepository.findRoleByName("ROOT")
        val roles = listOf<Role>(role)

        user.roles = roles
        println("user is $user")


    }


}