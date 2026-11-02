
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import java.util.Map;

public class App {

    private static final Scanner leitor = new Scanner(System.in);
    private static final List<Funcionario> funcionarios = new ArrayList<>();
    private static final Map<Cargo, Integer> mapQuantidadeFuncionarioPorCargo = new HashMap<>();

    public static void main() {

        int opcao;
        do {
            exibirMenu();
            opcao = leitor.nextInt();
            if (opcao == 1) {
                cadastrarFuncionario();
            }

            if (opcao == 2) {
                ListarFuncionario();
            }

            if (opcao == 3) {
                exibirSalarioFinal();
            }

            if (opcao == 4) {
                exibirFuncionarioComMaiorSalario();
            }

            if (opcao == 5) {
                exibirQuantidadeFuncionarioPorCargo();
            }

            //Se alguem ver esqueci da 6 hahaah.
       
        } while (opcao != 7);
    }

    private static void exibirMenu() {
        System.out.println("""
                1 - Cadastrar Funcionario
                2 - Listar Funcionario
                3 - Exibir salarios finais
                4 - Funcionario com  maior salario
                5 - Quantidade de funcionario por cargo
                6 - Buscar funcionario por nome
                7 - Sair
                """);
    }

    private static void cadastrarFuncionario() {
        System.out.println("Imforme o nome: ");
        String nome = leitor.next();
        System.out.println("Imforme o salario: ");
        double salario = leitor.nextDouble();
        System.out.println("Imforme o cargo: ");
        Cargo cargo = Cargo.valueOf(leitor.next());

        funcionarios.add(new Funcionario(nome, salario, cargo));
    }

    private static void ListarFuncionario() {
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Nome: " + funcionario.getCargo().getDescricao());

        }
    }

    private static void exibirSalarioFinal() {
        for (Funcionario funcionario : funcionarios) {

            String nome = funcionario.getNome();
            double salarioBase = funcionario.getSalario();
            double salarioFinal = salarioBase + funcionario.getCargo().calcularBonus(0);

            System.out.println(nome + "->" + salarioFinal);
        }

    }

    
    private static void exibirFuncionarioComMaiorSalario() {
        Funcionario funcionarioComMaiorSalario = null;
        double maiorSalarioFinal = Double.NEGATIVE_INFINITY;

        for (Funcionario funcionario : funcionarios) {
            double salarioFinal = funcionario.getSalario()
                    + funcionario.getCargo().calcularBonus(funcionario.getSalario());

            if (salarioFinal > maiorSalarioFinal) {
                funcionarioComMaiorSalario = funcionario;
                maiorSalarioFinal = salarioFinal;
            }
        }

        if (funcionarioComMaiorSalario == null) {
            System.out.println("Não há funcionários cadastrados.");
            return;
        }

        System.out.println("Funcionário com maior salário final:");
        System.out.println("Nome: " + funcionarioComMaiorSalario.getNome());
        System.out.println("Cargo: " + funcionarioComMaiorSalario.getCargo().getDescricao());
        System.out.println("Salário final: " + maiorSalarioFinal);
    }

    private static void exibirQuantidadeFuncionarioPorCargo() {
        mapQuantidadeFuncionarioPorCargo.clear();
        for (Cargo cargo : Cargo.values()) {
            mapQuantidadeFuncionarioPorCargo.put(cargo, 0);
        }

        for (Funcionario funcionario : funcionarios) {
            Cargo cargo = funcionario.getCargo();
            mapQuantidadeFuncionarioPorCargo.merge(cargo, 1, Integer::sum);
        }

        for (Cargo cargo : Cargo.values()) {
            System.out.println(cargo.getDescricao() + ": "
                    + mapQuantidadeFuncionarioPorCargo.get(cargo));
        }
    }
}
