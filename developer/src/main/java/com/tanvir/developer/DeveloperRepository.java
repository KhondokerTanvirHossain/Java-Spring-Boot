package com.tanvir.developer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends CrudRepository<Developer, Long> {

}
