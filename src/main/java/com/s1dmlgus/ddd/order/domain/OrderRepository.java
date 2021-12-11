package com.s1dmlgus.ddd.order.domain;

import com.s1dmlgus.ddd.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {



}
