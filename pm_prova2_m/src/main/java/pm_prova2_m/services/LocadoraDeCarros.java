package pm_prova2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;

public class Academia {
    private final ArrayList<Veiculo> veiculos = new ArrayList<>();
    private final ArrayList<Aluguel> alugueis = new ArrayList<>();

    private final HashMap<Aluguel, ArrayList<veiculo>> veiculosPorAluguel = new HashMap<>();

    public void cadastrarVeiculo(Veiculo veiculo) {
        if (veiculo == null) { throw new IllegalArgumentException("veiculo obrigatoria."); }
        if (veiculos.contains(veiculo)) {
            throw new RegraNegocioException("Esta turma ja esta cadastrada.");
        }
        veiculos.add(veiculo);
    }

    public void cadastrarAluguel(Aluguel aluguel) {
        if (aluguel == null) { throw new IllegalArgumentException("Aluguel obrigatorio."); }
        if (alugueis.contains(aluguel)) { throw new RegraNegocioException("Aluguel ja cadastrado."); }
        alugueis.add(aluguel);
        veiculosPorAluguel.put(aluguel, new ArrayList<veiculo>());
    }

    public void associarveiculo(Aluguel aluguel, veiculo veiculo) {
        if (!alugueis.contains(aluguel) || !veiculos.contains(veiculo)) {
            throw new IllegalArgumentException("Selecione Aluguel e veiculo cadastrados.");
        }
        if (veiculo.veiculoColetiva() && !aluguel.permiteveiculoColetiva()) {
            throw new RegraNegocioException("Este Aluguel nao permite veiculos coletivas.");
        }
        ArrayList<veiculo> associadas = veiculosPorAluguel.get(Aluguel);
        if (associadas.contains(veiculo)) {
            throw new RegraNegocioException("Esta turma ja esta associada ao Aluguel.");
        }
        if (associadas.size() >= Aluguel.getQuantidadeMaximaveiculos()) {
            throw new RegraNegocioException("Limite de veiculos do Aluguel atingido.");
        }
        associadas.add(veiculo);
    }

    public ArrayList<veiculo> listarveiculosDoAluguel(Aluguel Aluguel) {
        if (!alugueis.contains(Aluguel)) { throw new IllegalArgumentException("Aluguel nao cadastrado."); }
        return new ArrayList<>(veiculosPorAluguel.get(Aluguel));
    }

    public ArrayList<veiculo> listarveiculos() { return new ArrayList<>(veiculos); }
    public ArrayList<Aluguel> listaralugueis() { return new ArrayList<>(alugueis); }

    public ArrayList<Aluguel> listaralugueisAtivos() {
        ArrayList<Aluguel> ativos = new ArrayList<>();
        for (Aluguel Aluguel : alugueis) {
            if (Aluguel.getStatus() == StatusAluguel.ATIVO) { ativos.add(Aluguel); }
        }
        return ativos;
    }

    public ArrayList<Certificavel> listarCertificaveis() {
        ArrayList<Certificavel> resultado = new ArrayList<>();
        for (veiculo veiculo : veiculos) {
            if (veiculo instanceof Certificavel) { resultado.add((Certificavel) veiculo); }
        }
        for (Aluguel Aluguel : alugueis) {
            if (Aluguel instanceof Certificavel) { resultado.add((Certificavel) Aluguel); }
        }
        return resultado;
    }

    public ArrayList<veiculo> listarveiculosComPresenca() {
        ArrayList<veiculo> resultado = new ArrayList<>();
        for (veiculo veiculo : veiculos) {
            if (veiculo instanceof ControladorPresenca) { resultado.add(veiculo); }
        }
        return resultado;
    }

    public void registrarPresenca(veiculo veiculo, String nomeParticipante) {
        if (!veiculos.contains(veiculo)) {
            throw new IllegalArgumentException("veiculo nao cadastrada.");
        }
        if (!(veiculo instanceof ControladorPresenca)) {
            throw new RegraNegocioException("Esta veiculo nao controla presenca.");
        }
        ControladorPresenca controlador = (ControladorPresenca) veiculo;
        controlador.registrarPresenca(nomeParticipante);
    }

    public int removerveiculosInativas() {
        int removidas = 0;
        Iterator<veiculo> iterator = veiculos.iterator();
        while (iterator.hasNext()) {
            veiculo veiculo = iterator.next();
            if (veiculo.getStatus() == Statusveiculo.INATIVA) {
                for (Aluguel Aluguel : alugueis) { veiculosPorAluguel.get(Aluguel).remove(veiculo); }
                iterator.remove();
                removidas++;
            }
        }
        return removidas;
    }
}
