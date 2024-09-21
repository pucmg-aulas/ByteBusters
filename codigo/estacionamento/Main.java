package estacionamento;

public class Main {

    public static void main(String[] args) {
        
        Estacionamento a = new Estacionamento("Estacionamento A", "Rua A");
        a.mostrarEstacionamento();
        a.mostrarVagas();
        
        a.adicionarVaga("A", 1);
        a.adicionarVaga("A", 2);
        a.adicionarVaga("B", 1);
        a.adicionarVaga("B", 2);
        a.mostrarVagas();
        
        a.getVagas().get(0).ocupaVaga();
        a.mostrarEstacionamento();
        a.mostrarVagas();
        
    }
    
}
