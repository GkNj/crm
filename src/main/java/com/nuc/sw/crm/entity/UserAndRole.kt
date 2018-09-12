package com.nuc.sw.crm.entity

import javax.persistence.*

/**
 * @author 杨晓辉 2018-09-10 15:05
 */
@Entity(name = "user_role")
class UserAndRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0L

    @Column(name = "ur_user_id")
    var userId: Long = 0L

    @Column(name = "ur_role_id")
    var roleId: Long = 0L

    override fun toString(): String {
        return "UserAndRole(id=$id, userId=$userId, roleId=$roleId)"
    }


}