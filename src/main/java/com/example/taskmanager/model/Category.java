package com.example.taskmanager.model;

import jakarta.persistence.*;
import java.util.List;

/**
 * Representa uma categoria de tarefas. Cada categoria pode conter múltiplas
 * tarefas.
 */
@Entity
@Table(name = "categories")
public class Category {

    /**
     * Identificador único da categoria.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome descritivo da categoria.
     */
    @Column(nullable = false, unique = true)
    private String name;

    /**
     * Tarefas associadas a esta categoria.
     */
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks;

    /**
     * Construtor padrão para JPA.
     */
    public Category() {
    }

    /**
     * Cria uma categoria com o nome especificado.
     *
     * @param name nome da categoria
     */
    public Category(String name) {
        this.name = name;
    }

    /**
     * @return id da categoria
     */
    public Long getId() {
        return id;
    }

    /**
     * @return nome da categoria
     */
    public String getName() {
        return name;
    }

    /**
     * @param name define o nome da categoria
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return lista de tarefas da categoria
     */
    public List<Task> getTasks() {
        return tasks;
    }

    /**
     * @param tasks define a lista de tarefas
     */
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
