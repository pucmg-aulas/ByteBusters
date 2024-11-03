package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.*;

public class TelaPrincipalView extends JFrame {
    private EstacionamentoController estacionamentoController = new EstacionamentoController();

    public TelaPrincipalView() {
        setTitle("Sistema de Estacionamento");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton btnCriarEstacionamento = new JButton("Criar Estacionamento");
        btnCriarEstacionamento.setBounds(100, 30, 200, 30);
        add(btnCriarEstacionamento);

        JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
        btnCadastrarCliente.setBounds(100, 70, 200, 30);
        add(btnCadastrarCliente);

        JButton btnCadastrarVeiculo = new JButton("Cadastrar Veículo");
        btnCadastrarVeiculo.setBounds(100, 110, 200, 30);
        add(btnCadastrarVeiculo);

        JButton btnGerenciarEstacionamento = new JButton("Gerenciar Estacionamento");
        btnGerenciarEstacionamento.setBounds(100, 150, 200, 30);
        add(btnGerenciarEstacionamento);

        btnCriarEstacionamento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CriarEstacionamentoView(estacionamentoController);
            }
        });

        btnCadastrarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CadastrarClienteView();
            }
        });

        btnCadastrarVeiculo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CadastrarVeiculoView();
            }
        });

        btnGerenciarEstacionamento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GerenciarEstacionamentoView(estacionamentoController);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaPrincipalView();
    }
}
