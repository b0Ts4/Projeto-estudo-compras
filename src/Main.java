import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o limite do cartão: ");
        double limite = scanner.nextDouble();

        CartaoDeCredito cartao = new CartaoDeCredito(limite);
        int condicao = 1;

        while (condicao == 1) {

            System.out.println("Digite a descrição da compra: ");
            String descricao = scanner.next();

            System.out.println("Digite o valor da compra: ");
            double valor = scanner.nextDouble();

            Compra compra = new Compra(descricao, valor);

            if(cartao.lancaCompra(compra)) {
                System.out.println("Compra realizada com sucesso!");
                System.out.println("Digite 0 para sair ou 1 para continuar: ");
                condicao = scanner.nextInt();
            } else {
                System.out.println("Saldo insuficiente!");
                System.out.println("Digite 0 para sair ou 1 para tentar novamente: ");
                condicao = scanner.nextInt();
            }
        }
        Collections.sort(cartao.getCompras());
        System.out.println("""
                *******************************************
                COMPRAS REALIZADAS:
                """);
        for(Compra compra : cartao.getCompras()) {
            System.out.println(compra.getDescricao() + " - " + compra.getValor());
        }
        System.out.println("*******************************************");

        System.out.println("Saldo cartão: " + cartao.getSaldo());

    }
}
