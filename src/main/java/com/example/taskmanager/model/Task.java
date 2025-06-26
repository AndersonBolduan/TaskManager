package com.example.taskmanager.model;

import jakarta.persistence.*;
import java.util.List;

/**
 * Representa uma tarefa que pode ser cronometrada.
 */
@Entity
@Table(name = "tasks")
public class Task {

    /**
     * Identificador único da tarefa.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Título curto da tarefa.
     */
    @Column(nullable = false)
    private String title;

    /**
     * Descrição detalhada da tarefa.
     */
    @Column(length = 1000)
    private String description;

    /**
     * Prioridade da tarefa (1-5).
     */
    private int priority;

    /**
     * Categoria associada à tarefa.
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "category_id")
    private Category category;

    /**
     * Sessões de tempo associadas a esta tarefa.
     */
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TimeSession> sessions;

    /**
     * Construtor padrão para JPA.
     */
    public Task() {
    }

    /**
     * Cria uma tarefa com os parâmetros fornecidos.
     *
     * @param title título
     * @param description descrição
     * @param priority nível de prioridade
     * @param category categoria associada
     */
    public Task(String title, String description, int priority, Category category) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.category = category;
    }

    /**
     * @return id da tarefa
     */
    public Long getId() {
        return id;
    }

    /**
     * @return título da tarefa
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title define o título
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return descrição
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description define a descrição
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return prioridade
     */
    public int getPriority() {
        return priority;
    }

    /**
     * @param priority define prioridade
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * @return categoria
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category define a categoria
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * @return sessões de tempo
     */
    public List<TimeSession> getSessions() {
        return sessions;
    }

    /**
     * @param sessions define sessões
     */
    public void setSessions(List<TimeSession> sessions) {
        this.sessions = sessions;
    }
}
