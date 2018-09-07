package com.nuc.sw.crm.repository

import com.nuc.sw.crm.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * @author 杨晓辉 2018-09-07 9:33
 */
@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findUserByUsername(username: String): User

}
