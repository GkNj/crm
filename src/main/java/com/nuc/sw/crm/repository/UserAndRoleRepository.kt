package com.nuc.sw.crm.repository

import com.nuc.sw.crm.entity.UserAndRole
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * @author 杨晓辉 2018-09-10 15:07
 */
@Repository
interface UserAndRoleRepository : JpaRepository<UserAndRole, Long> {

    /**
     * 通过userId查找role id
     * @param userId 用户id
     * @return UserAndRole 对象
     */
    fun findUserAndRoleByUserId(userId: Long): MutableList<UserAndRole>


    fun deleteByUserId(userId: Long)
}