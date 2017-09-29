package com.francesco.progDataBase.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;



@Repository
public interface StudenteRepo extends CrudRepository<StudenteEntity,Long> {

}
