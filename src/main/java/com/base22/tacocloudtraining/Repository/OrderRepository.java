package com.base22.tacocloudtraining.Repository;

import com.base22.tacocloudtraining.Model.Order;
import org.springframework.data.repository.CrudRepository;


public interface OrderRepository
        extends CrudRepository<Order, Long> {
}