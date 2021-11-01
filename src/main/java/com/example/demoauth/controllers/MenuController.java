package com.example.demoauth.controllers;

import com.example.demoauth.models.*;
import com.example.demoauth.pojo.MenuRequest;
import com.example.demoauth.pojo.MessageResponse;
import com.example.demoauth.repository.MenuPositionRepository;
import com.example.demoauth.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Fedor Danilov 01.11.2021
 */
@RestController
@RequestMapping("/menu")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MenuController {

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    MenuPositionRepository positionRepository;

    @GetMapping("/all")
    public List<Menu> getAll(){
        return menuRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addMenu(@RequestBody MenuRequest menuRequest){
        if (menuRepository.existsByName(menuRequest.getName())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Ошибка: Меню с таким наименованием существует"));
        }
        Menu menu = new Menu(menuRequest.getName());
        String reqPosition = menuRequest.getPosition();
        MenuPosition menuPosition = new MenuPosition();

        if (reqPosition != null){
            switch (reqPosition) {
                case "main":
                    menuPosition = positionRepository
                            .findByName(EMenu.MENU_MAIN)
                            .orElseThrow(() -> new RuntimeException("Ошибка: позиция не найдена"));
                    break;
                default:
                    menuPosition = positionRepository
                            .findByName(EMenu.MENU_NOPOSITION)
                            .orElseThrow(() -> new RuntimeException("Ошибка: позиция не найдена"));
            }
        }
        else {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Ошибка: Необходимо указать позицию"));
        }
        menu.setPosition(menuPosition);
        menuRepository.save(menu);
        return ResponseEntity.ok(new MessageResponse("Меню создано"));
    }
}
