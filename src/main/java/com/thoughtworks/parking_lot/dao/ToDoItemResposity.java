package com.thoughtworks.parking_lot.dao;

import com.thoughtworks.parking_lot.entity.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ToDoItemResposity extends JpaRepository<ToDoItem,String> {
    @Query(value = "select * from  TO_DO_ITEM   where ITEM = ?1",nativeQuery = true)
    ToDoItem findToDoItemByItem(String item);
}
