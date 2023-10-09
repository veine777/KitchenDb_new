package org.top.kitchendb;

import jakarta.persistence.*;


@Entity
@Table(name = "menu_t")
public class Menu {


//класс описывает объект товара
//соответствует таблице menu_t

//поля соответсвуют столбцам (атрибутам) таблицы в БД

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title_f", nullable = false)
    private String title;

    @Column(name = "proteins_f", nullable = false)
    private Double proteins;

    @Column(name = "fats_f", nullable = false)
    private Double fats;

    @Column(name = "carbohydrates_f", nullable = false)
    private Double carbohydrates;

    @Column(name = "calories_f",  nullable = false)
    private Integer calories;

    @Column(name = "description_f")
    private String description;



    //constructors
    public Menu(){
        id = 0;
        title = "";
        proteins = 0.00;
        fats = 0.00;
        carbohydrates = 0.00;
        calories = 0;
        description = null;
    }
    //getters & setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getProteins() {
        return proteins;
    }

    public void setProteins(Double proteins) {
        this.proteins = proteins;
    }

    public Double getFats() {
        return fats;
    }

    public void setFats(Double fats) {
        this.fats = fats;
    }

    public Double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return id + "; " + title + "; " + proteins + "; " + fats + "; " + carbohydrates + "; " + calories + "; "+ description;
    }
}
