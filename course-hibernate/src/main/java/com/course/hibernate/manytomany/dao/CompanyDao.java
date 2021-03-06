package com.course.hibernate.manytomany.dao;

import com.course.hibernate.manytomany.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {
    List<Company> findCompanyByThreeLetters(@Param("COMPANYNAME") String name);
}
