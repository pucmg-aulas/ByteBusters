package controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dao.CobrancaDAO;
import model.*;

public class CobrancaController {
    private static List<Cobranca> cobrancasAtivas = new ArrayList<>();
    private static CobrancaDAO cobrancaDAO = new CobrancaDAO();

    public static void adicionarCobranca(Cobranca cobranca) {
        cobrancasAtivas.add(cobranca);
    }

    public static Cobranca buscarCobrancaAtivaPorPlaca(String placa) {
        return cobrancasAtivas.stream()
                .filter(c -> c.getVeiculo().getPlaca().equals(placa) && c.getHoraSaida() == null)
                .findFirst()
                .orElse(null);
    }

    public static double calcularValorCobranca(String placa, LocalDateTime horaSaida) {
        Cobranca cobranca = buscarCobrancaAtivaPorPlaca(placa);
        if (cobranca != null) {
            cobranca.registrarSaida(horaSaida);
            double valor = cobranca.calcularValor();

            // Salvar a cobrança no arquivo
            cobrancaDAO.salvarCobranca(cobranca);

            return valor;
        }
        return 0;
    }
}
