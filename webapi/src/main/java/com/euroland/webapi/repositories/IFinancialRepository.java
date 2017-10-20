package com.euroland.webapi.repositories;

import com.euroland.webapi.models.Financial;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFinancialRepository extends MongoRepository<Financial,String>/*, QueryDslPredicateExecutor<Financial>*/{

    Financial findByName(String name);

    @Query(value = "{name:0,financialDetails.year:?0}")
    Financial findByNameAndDateTime(String name, String year);

    @Query(value = "{name:?0,financialDetails.year:?0,company.name:?0}")
    Financial findByNameAndDateCompanyName(String name,String year, String company);

    @Query(value = "{company.name:?0}")
    List<Financial> findByCompany(String name);
}
