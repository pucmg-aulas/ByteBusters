package estacionamento;

import com.sun.source.tree.IfTree;
import java.util.ArrayList;
import java.util.List;

public class Cliente 
{
    // Atributos
    private String nome;
    private int idCliente;
    private List<Veiculo> veiculo;

    //Construtor
    public Cliente(String nome, int idCliente)
    {
        this.nome = nome;
        this.idCliente = idCliente;
        this.veiculo = new ArrayList<>();
    }

    //Registrar o veículo
    public void registrarVeiculo(Veiculo veiculo)
    {
        veiculo.add(veiculo);
        System.out.println("Veiculo com placa " + veiculo.getPlaca() + " registrado para o cliente " + nome);
    }

    //Metodo para calcular o Id do cliente
    public void calcularIdCliente(){
        this.idCliente = nome.hashCode();
        System.out.println("Id do cliente atualizado: " + idCliente);
    }

    //Getters e Setters
    public String getNome()
    {
        return nome;
    }
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public int getIdCliente()
    {
        return idCliente;
    }
    public void setIdCliente(int idCliente)
    {
        this.idCliente = idCliente;
    }

    public List<Veiculo> getVeiculo()
    {
        return veiculos;
    }
    public void setVeiculos(List<Veiculo> veiculo)
    {
        this.veiculo = veiculo;
    }

}
