package org.top.kitchendb;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MainController {


    // репозиторий для работы с объектами (использование DI)
    private final MenuRepository menuRepository;

    public MainController (MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    // дефолтные обработчики
    @GetMapping("")
    public String index() {
        return "Server is running";
    }

    @GetMapping("ping")
    public String ping() {
        return "pong";
    }

    // ОБРАБОТЧИКИ, ВЫЗЫВАЮЩИЕ ОПЕРАЦИИ ПО ВЗАИМОДЕЙСТВИЮ С БД
    // 1. получить все записи
    @GetMapping("menu")
    public Iterable<Menu> findAll() {
        return menuRepository.findAllByOrderByTitle();
    }

    // 2. получить запись по id
    @GetMapping("menu/{id}")
    public Optional<Menu> findById(@PathVariable Integer id) {
        return menuRepository.findById(id);
    }

    // 3. добавить новую запись
    @PostMapping("menu/new")
    public Menu addNew(@RequestBody Menu menu) {
        return menuRepository.save(menu);
    }

    // 4. удалить запись по id
    @DeleteMapping("menu/{id}")
    public  Optional<Menu> deleteById(@PathVariable Integer id) {
        Optional<Menu> deleted = menuRepository.findById(id); //найти удаляемый обект
        if (deleted.isPresent()){// если он присутствует:, то удалить его
            menuRepository.deleteById(id);
        }
        return deleted; //вернуть удаленный объект
    }
    // 5. изменить запись
    @PostMapping("menu/update")
    public  Optional<Menu> updateExisting(@RequestBody Menu menu){
        //проверяем есть ли запись
        Optional<Menu> updated = menuRepository.findById(menu.getId());
        //если есть изменяем
        if (updated.isPresent()) {
            menuRepository.save(menu);
            return Optional.of(menu);
        }
        //вернуть пустое значение
        return Optional.empty();
    }
}