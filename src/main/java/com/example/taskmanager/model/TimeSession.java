package com.example.taskmanager.model;

import jakarta.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Representa uma sessão de tempo associada a uma tarefa.
 */
@Entity
@Table(name = "time_sessions")
public class TimeSession {

    /**
     * Identificador da sessão.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Início da sessão.
     */
    private LocalDateTime startTime;
    /**
     * Fim da sessão.
     */
    private LocalDateTime endTime;

    /**
     * Tarefa à qual esta sessão pertence.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task task;

    /**
     * Construtor padrão.
     */
    public TimeSession() {
    }

    /**
     * Inicia uma sessão para a tarefa.
     *
     * @param task tarefa associada
     */
    public TimeSession(Task task) {
        this.task = task;
        this.startTime = LocalDateTime.now();
    }

    /**
     * Encerra a sessão, marcando o tempo de fim.
     */
    public void end() {
        this.endTime = LocalDateTime.now();
    }

    /**
     * Calcula a duração da sessão.
     *
     * @return duração como Duration
     */
    public Duration getDuration() {
        return endTime != null ? Duration.between(startTime, endTime) : Duration.ZERO;
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return início
     */
    public LocalDateTime getStartTime() {
        return startTime;
    }

    /**
     * @return fim
     */
    public LocalDateTime getEndTime() {
        return endTime;
    }

    /**
     * @return tarefa
     */
    public Task getTask() {
        return task;
    }
}
