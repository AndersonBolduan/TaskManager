package com.example.taskmanager.gestor;

import com.example.taskmanager.dao.TaskDAO;
import com.example.taskmanager.model.Category;
import com.example.taskmanager.model.Task;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Classe principal JavaFX que inicia a aplicação de gerenciamento de tarefas.
 */
public class Gestor extends Application {

    private TaskDAO taskDAO = new TaskDAO();

    /**
     * Ponto de entrada da aplicação.
     *
     * @param args argumentos de linha de comando
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Método chamado ao iniciar a aplicação JavaFX.
     */
    @Override
    public void start(Stage stage) {
        TableView<Task> table = new TableView<>();
        Button addBtn = new Button("Add Task");
        addBtn.setOnAction(e -> showAddDialog());

        VBox root = new VBox(table, addBtn);
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Task Manager");
        stage.setScene(scene);
        stage.show();
        table.getItems().setAll(taskDAO.findAll());
    }

    /**
     * Exibe um diálogo para criar nova tarefa e a persiste via DAO.
     */
    private void showAddDialog() {
        Dialog<Task> dialog = new Dialog<>();
        dialog.setTitle("New Task");
        TextField titleField = new TextField();
        TextArea descField = new TextArea();
        Spinner<Integer> prioritySpinner = new Spinner<>(1, 5, 3);
        dialog.getDialogPane().setContent(new VBox(
                new Label("Title:"), titleField,
                new Label("Description:"), descField,
                new Label("Priority:"), prioritySpinner
        ));
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        dialog.setResultConverter(btn -> {
            if (btn == ButtonType.OK) {
                return new Task(titleField.getText(), descField.getText(), prioritySpinner.getValue(), new Category("General"));
            }
            return null;
        });
        dialog.showAndWait().ifPresent(task -> taskDAO.save(task));
    }
}
