public class Van extends Veiculo implements Avaliavel, Inspecionavel {
    private final int portas;
    private final int avaliacao;
    private final String inspecao;


    public Van(String placa, String modelo, int anoFabricacao, double valorDiaria,double quilometragem, StatusVeiculo status, int passageiroMax, int avaliacao, String inspecao) {
        this.passageiroMax = passageiroMax;
        this.avaliacao = avaliacao;
        this.inspecao = inspecao;
    }

    public int getPassageirosMax() {
        return passageiroMax;
    }

    public void setPassageirosMax(int max) {
        this.passageiroMax = max;
    }

    public getAvaliacao() {
        return avaliacao;
    }

    public void avaliar(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getInspecao() {
        return inspecao;
    }

    public void realizarInspecao(String inspec) {
        system.out.println(inspec);
        this.inspecao = inspec;
    }
}
