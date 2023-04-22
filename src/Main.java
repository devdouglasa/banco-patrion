import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String nomeCliente = "Douglas Alisson";
        String tipoConta = "Corrente";
        double saldo = 2500;
        double deposito = 0;
        double saque = 0;
        int selecaoUsuario = 0;

        System.out.println(DadosDoCliente(nomeCliente, tipoConta, saldo));


        while (selecaoUsuario != 4) {
            System.out.println(textoDeOperacoes());
            selecaoUsuario = input.nextInt();
            if (selecaoUsuario >= 1 && selecaoUsuario <= 4){
                switch (selecaoUsuario) {
                    case 1 -> {
                        System.out.println(ConsultarSaldo(saldo));
                    }
                    case 2 -> {
                        saldo = OperacaoDeposito(input, deposito, saldo);
                    }
                    case 3 -> {
                        saldo = OperacaoTransferencia(input, saque, saldo);
                    }
                    case 4 -> {
                        System.out.println("O Banco Patrion Agradece sua Visita!");
                        break;
                    }
                }
            } else {
                System.out.println("OPÇÃO INVÁLIDA! Tente Novamente!");
                continue;
            }

        }

    }

    public static String DadosDoCliente(String nomeCliente, String tipoConta, double saldo) {
        return String.format("""
                               *************************************
                               Dados Iniciais do Cliente:
                               
                               
                               Nome:             %s
                               Tipo conta:       %s
                               Saldo Inicial:    R$ %.2f
                               *************************************
                               """, nomeCliente.toUpperCase(), tipoConta.toUpperCase(), saldo);
    }

    public static String textoDeOperacoes() {
        return """
               
               
               Operações
               
               1 - Consultar saldos
               2 - Receber valor
               3 - Transferir valor
               4 - Sair
               
               Digite a opção desejada:
               """;
    }

    public static double OperacaoDeposito(Scanner input, double deposito, double saldo) {
        System.out.println("Quanto deseja depositar?");
        deposito = input.nextDouble();
        saldo += deposito;
        System.out.printf("""
                            Depósito realizado com SUCESSO!
                            Seu Saldo Atualizado é %.2f
                           """, saldo);
        return saldo;
    }

    public static double OperacaoTransferencia(Scanner input, double saque, double saldo) {
        System.out.println("Quanto deseja transferir?");
        saque = input.nextDouble();
        if (saldo >= saque) {
            saldo -= saque;
            System.out.printf("""
                           Transferência realizada com SUCESSO!
                           Seu Saldo Atualizado é %.2f
                           """, saldo);
            return saldo;
        } else {
            System.out.println("Operação Não Realizada. Você não possui saldo suficiente!");
            return saldo;
        }
    }

    public static String ConsultarSaldo(double saldo) {
        return String.format("O seu saldo atual é %.2f", saldo);
    }
}
