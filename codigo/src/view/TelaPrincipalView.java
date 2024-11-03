package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.*;

public class TelaPrincipalView extends JFrame {
    private EstacionamentoController estacionamentoController;
    private ClienteController clienteController;

    public TelaPrincipalView(EstacionamentoController estacionamentoController, ClienteController clienteController) {
        this.estacionamentoController = estacionamentoController;
        this.clienteController = clienteController;

        setTitle("Sistema de Estacionamento");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton btnCriarEstacionamento = new JButton("Criar Estacionamento");
        btnCriarEstacionamento.setBounds(100, 30, 200, 30);
        add(btnCriarEstacionamento);
        btnCriarEstacionamento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CriarEstacionamentoView(estacionamentoController);
            }
        });

        JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
        btnCadastrarCliente.setBounds(100, 70, 200, 30);
        add(btnCadastrarCliente);
        btnCadastrarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CadastrarClienteView();
            }
        });

        JButton btnCadastrarVeiculo = new JButton("Cadastrar Veículo");
        btnCadastrarVeiculo.setBounds(100, 110, 200, 30);
        add(btnCadastrarVeiculo);
        btnCadastrarVeiculo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CadastrarVeiculoView(clienteController);
            }
        });

        JButton btnGerenciarEstacionamento = new JButton("Gerenciar Estacionamento");
        btnGerenciarEstacionamento.setBounds(100, 150, 200, 30);
        add(btnGerenciarEstacionamento);
        btnGerenciarEstacionamento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GerenciarEstacionamentoView(estacionamentoController);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        EstacionamentoController estacionamentoController = new EstacionamentoController();
        ClienteController clienteController = new ClienteController();
        
        new TelaPrincipalView(estacionamentoController, clienteController);
    }
}
