package com.estacionamento.carros.repository;

import com.estacionamento.carros.domain.Carro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Lazy
@Repository
public class CarroRepositoryImpl implements CarroRepositoryCustom {

    private MongoOperations mongoOperations;

    @Autowired
    public CarroRepositoryImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public List<Carro> searchWithFilters(Map<String, String> params) {
        Query query = new Query();

        for (String key : params.keySet()) {
            Criteria criteria = Criteria.where(key).is(params.get(key));
            query.addCriteria(criteria);
        }

        List<Carro> carro = mongoOperations.find(query, Carro.class);

        return carro;
    }
}
