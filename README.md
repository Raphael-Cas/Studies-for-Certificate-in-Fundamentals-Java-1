# Studies-for-Fundamentals-Certificate-in-Java

## Java Fundamentals RocketSeat

# Employee Management System

A Java console application for registering employees, viewing their information, and calculating salary and job-related details.

## Requirements

- JDK 15 or later (the project uses text blocks introduced in Java 15).

## Project structure

- `src/App.java`: application menu and operations.
- `src/Funcionario.java`: represents an employee with a name, salary, and job title.
- `src/Cargo.java`: defines job titles and their bonus percentages.

## Job titles and bonuses

| Code | Job title | Bonus |
|---|---|---:|
| `DEV` | Developer | 10% |
| `PM` | Product Manager | 20% |
| `DEVOPS` | DevOps | 15% |

When registering an employee, enter the job code exactly as shown in the table.

## Menu options

1. Register an employee.
2. List employees.
3. Display final salaries.
4. Display the employee with the highest final salary.
5. Display the number of employees per job title.
6. Search for an employee by name.
7. Exit.

**Notes:** Option 6 appears in the menu, but searching by name has not been implemented yet. Also, `exibirSalarioFinal()` passes `0` to the bonus calculation, so it currently displays the base salary without a bonus.

## Functions

### `App`

- `main()`: repeats the menu and dispatches options 1 through 5.
- `exibirMenu()`: displays the available options.
- `cadastrarFuncionario()`: reads the name, salary, and job title, then adds the employee to the list.
- `ListarFuncionario()`: iterates over the list and displays each employee's name and job title description.
- `exibirSalarioFinal()`: iterates over employees and displays their salary; currently, no bonus is added because the bonus calculation receives `0`.
- `exibirFuncionarioComMaiorSalario()`: finds and displays the employee with the highest final salary, or reports that the list is empty.
- `exibirQuantidadeFuncionarioPorCargo()`: counts and displays employees for each job title, including titles with no employees.

### `Funcionario`

- `Funcionario(String nome, double salario, Cargo cargo)`: constructor that initializes the employee's data.
- `getNome()`, `getSalario()`, and `getCargo()`: access the employee's data.

### `Cargo`

- `calcularBonus(double salario)`: calculates the bonus for the job title.
- `getDescricao()`: returns a readable description of the job title.

## Running the application

The `App` class currently declares `main()` without the `String[] args` parameter. To run the application with the standard Java launcher, change its signature to:

```java
public static void main(String[] args) {
```

Then, from the project directory in PowerShell, compile and run:

```powershell
javac -d bin src\*.java
java -cp bin App
```
