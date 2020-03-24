package com.tanvir.forex;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForexRepository extends CrudRepository<ExchangeValue, Integer> {
    public ExchangeValue findByFromAndTo(String from, String to);
}
