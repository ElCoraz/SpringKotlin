package com.application.execute.repository

import com.application.execute.model.Users
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

/**********************************************************************************************************************/
@Repository
interface UsersRepository : PagingAndSortingRepository<Users?, String?> {
    fun findByUsername(name: String?): Users?
    fun findByToken(token: String?): Users?
}