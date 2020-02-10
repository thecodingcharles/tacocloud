package com.base22.tacocloudtraining.Repository;

import com.base22.tacocloudtraining.Model.Taco;


import org.springframework.data.repository.CrudRepository;
public interface TacoRepository
        extends CrudRepository<Taco, Long> {
}
