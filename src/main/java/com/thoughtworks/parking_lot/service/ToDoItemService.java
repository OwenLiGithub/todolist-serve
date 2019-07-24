package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.dao.ToDoItemResposity;
import com.thoughtworks.parking_lot.entity.ToDoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoItemService {
    @Autowired
    private ToDoItemResposity toDoItemResposity;

    public Boolean addItem(ToDoItem toDoItem) {
        ToDoItem toDoItemByItem1 = toDoItemResposity.findToDoItemByItem(toDoItem.getItem());
        if(toDoItemByItem1!=null){
            return false;
        }
        toDoItemResposity.save(toDoItem);
        return true;
    }

    public void delItem(ToDoItem toDoItem) {
        ToDoItem toDoItem1 = toDoItemResposity.findToDoItemByItem(toDoItem.getItem());
        System.out.println(toDoItem1);
        toDoItemResposity.delete(toDoItem1);
    }
}
