public class Moto extends Veiculo implements Inspecionavel {
    private final int cilindradas;
    private final String inspecao;

    public Moto(String placa, String modelo, int anoFabricacao, double valorDiaria,double quilometragem, StatusVeiculo status, int cilindradas, String inspecao) {
        this.placa = placa;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.valorDiaria = valorDiaria;
        this.quilometragem = quilometragem;
        this.status = status;
        this.cilindradas = cilindradas;
        this.inspecao = inspecao;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    public String getInspecao() {
        return inspecao
    }

    public void realizarInspecao(String inspec) {
        system.out.println(inspec);
        this.inspecao = inspec
    }

}
