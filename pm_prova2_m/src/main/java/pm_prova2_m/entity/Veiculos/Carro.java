public class Carro extends Veiculo implements Avaliavel {
    private final int portas;
    private final Avaliavel avaliacao;

    public Carro(String placa, String modelo, int anoFabricacao, double valorDiaria,double quilometragem, StatusVeiculo status, int portas, int avaliacao) {
        this.placa = placa;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.valorDiaria = valorDiaria;
        this.quilometragem = quilometragem;
        this.status = status;
        this.portas = portas;
        this.avaliacao = avaliacao;
    }

    public int getPortas() {
        return portas;
    }

    public void setPortas(int portas) {
        this.portas = portas;
    }

    public getAvaliacao() {
        return avaliacao;
    }

    public void avaliar(int avaliacao) {
        this.avaliacao = avaliacao;
    }
}
