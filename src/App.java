import java.util.ArrayList;

public class App {

    public static final ArrayList<Double> tokens;

    //Gerando/Adicionando todas as moedas/cédulas disponíveis
    static {
        tokens = new ArrayList<>();
        tokens.add(200.00);
        tokens.add(100.00);
        tokens.add(50.00);
        tokens.add(20.00);
        tokens.add(10.00);
        tokens.add(5.00);
        tokens.add(2.00);
        tokens.add(1.00);
        tokens.add(0.50);
        tokens.add(0.25);
        tokens.add(0.10);
        tokens.add(0.05);
        tokens.add(0.01);
    }

    public static void main(String[] args) throws Exception {
    
        System.out.println("Digite o valor total do pedido:");

        Double orderTotal = Double.parseDouble(System.console().readLine());

        System.out.println("Digite o valor pago:");

        Double paymentValue = Double.parseDouble(System.console().readLine());

        //Limpar a tela para mostrar o resultado
        clear();

        System.out.println("Total do pedido: " + orderTotal);

        System.out.println("Valor pago: " + paymentValue);

        Double changeValue = paymentValue - orderTotal;

        System.out.println("Troco: " + changeValue);

        System.out.println();

        //Obter a lista de moedas/cédulas
        ArrayList<Double> tokens = App.tokens;

        while (changeValue != 0) {

            //Obter a primeira moeda disponível inicia com 200 e termina 1 centavo
            Double money = tokens.getFirst();

            if(changeValue >= money) {

                //Se o troco for maior que a moeda atual, entregar a moeda atual
                System.out.println("Entregar " + money);
                
                //Subtrair o valor da moeda
                changeValue -= money;

            } else {
                //Se o troco for menor que a moeda atual, entregar o troco
                tokens.removeFirst();
            }
        }        
    }

    public static void clear() {
        System.out.print("\033[H\033[2J");
    }
}