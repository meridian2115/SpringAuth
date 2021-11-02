package com.example.demoauth.controllers;

import com.example.demoauth.models.Menu;
import com.example.demoauth.models.MenuItem;
import com.example.demoauth.pojo.MenuItemRequest;
import com.example.demoauth.pojo.MessageResponse;
import com.example.demoauth.repository.MenuItemRepository;
import com.example.demoauth.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Fedor Danilov 01.11.2021
 */
@RestController
@RequestMapping("/menu-item")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MenuItemController {
    @Autowired
    MenuItemRepository menuItemRepository;

    @Autowired
    MenuRepository menuRepository;

    @GetMapping("/all")
    public List<MenuItem> getAll(){
        return menuItemRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addMenuItem(@RequestBody MenuItemRequest request){

        MenuItem menuItem = new MenuItem(request.getName(),request.getLink(), request.getDescription(), request.getSvg(), request.getSorter());

        String menuReq = request.getMenu();
        String parentMenuItemReq = request.getParentMenuItem();

        Menu menu = new Menu();
        MenuItem parentMenuItem = new MenuItem();

        if (menuReq != null){
            try{
                Long id = Long.parseLong(menuReq);
                menu = menuRepository.getById(id);
                if (menu.getId() == null){
                    return ResponseEntity
                            .badRequest()
                            .body(new MessageResponse("Ошибка: Меню с таким Id не существует"));
                }
                menuItem.setMenu(menu);
            } catch (NumberFormatException e){
                return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse("Ошибка: " + e.getMessage()));
            }
        } else{
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Ошибка: В запросе не указано меню"));
        }
        if (parentMenuItemReq != null){
            try{
                Long id = Long.parseLong(parentMenuItemReq);
                parentMenuItem = menuItemRepository.getById(id);
                if (parentMenuItem.getId() == null){
                    return ResponseEntity
                            .badRequest()
                            .body(new MessageResponse("Ошибка: Элемент меню с таким Id не существует"));
                }
                menuItem.setParentMenuItem(parentMenuItem);
            } catch (NumberFormatException e){
                return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse("Ошибка: " + e.getMessage()));
            }
        }
        menuItemRepository.save(menuItem);
        return ResponseEntity.ok(new MessageResponse("Элемент меню создан"));
    }
}
