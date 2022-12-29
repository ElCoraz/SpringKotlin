package com.application.execute.model

import lombok.*
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
/**********************************************************************************************************************/
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Users {
    /******************************************************************************************************************/
    @Id
    @Column(nullable = false)
    var id: String? = null
    /******************************************************************************************************************/
    @Column(nullable = false, length = 40)
    var token: String? = null
    /******************************************************************************************************************/
    @Column(nullable = false, length = 40)
    var name: String? = null
    /******************************************************************************************************************/
    @Column(nullable = false, length = 40)
    var username: String? = null
    /******************************************************************************************************************/
    @Column(nullable = false, length = 40)
    var password: String? = null
    /******************************************************************************************************************/
    @Column(nullable = false)
    var enabled = false
    /******************************************************************************************************************/
    @Column(nullable = false)
    var description: String? = null
    /******************************************************************************************************************/
    @Column(nullable = false)
    var role: String? = null
    /******************************************************************************************************************/
    @Column(nullable = false, columnDefinition = "LONGTEXT")
    var rules: String? = null
    /******************************************************************************************************************/
    @Column(nullable = false, columnDefinition = "LONGTEXT")
    var bases: String? = null
    /******************************************************************************************************************/
    @Column(nullable = false, name = "CREATEDAT")
    var createdDateTime: LocalDateTime? = null
    /******************************************************************************************************************/
    @Column(nullable = false, name = "UPDATEDAT")
    var updated_at: LocalDateTime? = null
    /******************************************************************************************************************/
    fun create() {
        id = UUID.randomUUID().toString()
        name = ""
        token = UUID.randomUUID().toString()
        password = ""
    }
    /******************************************************************************************************************/
    fun setEditDateTime() {
        updated_at = LocalDateTime.now()
    }
    /******************************************************************************************************************/
    fun setPassword() {
        password = BCryptPasswordEncoder().encode(password)
    }
    /******************************************************************************************************************/
    fun checked(id: String): Boolean {
        if (bases == null) {
            return false
        }
        val bases = bases!!.split("\\;".toRegex()).toTypedArray()
        for (base in bases) {
            if (base == id) {
                return true
            }
        }
        return false
    }
}