**Task Manager**

**Descrição**

Aplicação desktop em Java para gerenciar tarefas com cronômetro, permitindo:

Cadastro e edição de tarefas (título, descrição, prioridade).

Agrupamento de tarefas por categorias.

Início/pausa de cronômetro para cada tarefa e histórico de sessões.

Persistência de dados com Hibernate/JPA e banco H2 embarcado.

Interface gráfica responsiva em JavaFX.

Motivação e Problemas Resolvidos

Durante o desenvolvimento, enfrentamos desafios de configuração de ambiente e execução:

Gerenciamento de dependências JavaFX: resolvido usando javafx-maven-plugin versão 0.0.8 e Maven Central.

Configuração no NetBeans 17: ajustes em Actions → Run Project para usar clean compile javafx:run e desabilitar "Compile on Save".

Erros ClassNotFoundException: corrigidos garantindo a estrutura de pacotes e nome de classe principal (com.example.taskmanager.Gestor).

TransientObjectException no Hibernate: resolvido adicionando cascade = {PERSIST, MERGE} em @ManyToOne de Task para persistir Category automaticamente.

**Como instalar e executar**

**Clone o repositório:**

git clone https://github.com/AndersonBolduan/TaskManager.git
cd TaskManager

**Compile e execute via Maven:**

mvn clean compile javafx:run

Se usar **NetBeans 17**, configure em **Project Properties → Actions → Run Project:**

**Goals:** clean compile javafx:run

**Limpe campos de VM Options e Set Properties.**

**Desabilite Compile on Save em Build → Compilação.**

**Funcionalidades Implementadas**

- Criação, listagem, edição e remoção de tarefas.

- Associação de tarefas a categorias.

- Cronômetro integrado com histórico de sessões.

- Persistência automática de categorias e tarefas.

- GUI em JavaFX com diálogo de criação rápida.

**Funcionalidades Desejadas (ToDo)**

- Edição de tarefas via diálogo separado.

- Geração de relatórios em PDF (JasperReports ou iText).

- Gráficos de tempo por categoria.

- Internacionalização (ResourceBundle com pt_BR, en_US, es_ES).

- Autenticação de múltiplos usuários.
