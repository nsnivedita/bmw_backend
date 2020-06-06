package com.bmw.invoice.dao.repository;

import com.bmw.invoice.dao.entity.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineItemRepository extends JpaRepository<LineItem,Long> {

}
