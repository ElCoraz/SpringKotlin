package com.application.execute.model

import lombok.*
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
class Authorities {
    /******************************************************************************************************************/
    @Id
    @Column(nullable = false, unique = true, length = 50)
    private var username: String? = null
    /******************************************************************************************************************/
    @Column(nullable = false, length = 50)
    private var authority: String? = null
    /******************************************************************************************************************/
    fun setValues(username: String?, authority: String?) {
        this.username = username
        this.authority = authority
    }
}