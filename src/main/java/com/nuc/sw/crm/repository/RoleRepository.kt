package com.nuc.sw.crm.repository

import com.nuc.sw.crm.entity.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * @author 杨晓辉 2018-09-07 9:24
 */
@Repository
interface RoleRepository : JpaRepository<Role, Long> {
}