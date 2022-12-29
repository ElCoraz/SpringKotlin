package com.application.execute.repository

import com.application.execute.model.Authorities
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

/**********************************************************************************************************************/
@Repository
interface AuthoritiesRepository : PagingAndSortingRepository<Authorities?, String?>