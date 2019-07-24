package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.dao.ToDoItemResposity;
import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.entity.ToDoItem;
import com.thoughtworks.parking_lot.service.ToDoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/todolists")
public class ToDoListController {

    @Autowired
    private ToDoItemResposity toDoItemResposity;

    @Autowired
    private ToDoItemService toDoItemService;
    @GetMapping()
    public ResponseEntity getallItem() {
        return ResponseEntity.status(HttpStatus.OK).body(toDoItemResposity.findAll());
    }
    @PostMapping()
    public ResponseEntity addItem(@RequestBody ToDoItem toDoItem) {
        Boolean result = toDoItemService.addItem(toDoItem);
        if(result){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("不能重复添加");
        }
    }
    @DeleteMapping()
    public ResponseEntity dellItem(@RequestBody ToDoItem toDoItem){
        toDoItemService.delItem(toDoItem);
       return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PutMapping()
    public ResponseEntity updateItem(@RequestBody ToDoItem toDoItem){
        toDoItemResposity.saveAndFlush(toDoItem);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
