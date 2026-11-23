public class Executivo extends Aluguel implements Avaliavel {
    private final double km;
    private final Motorista motorista;
    private final int avaliacao;
    
    public Executivo(String nomeCliente, int quantidadeDias, double valorTotal, StatusAluguel status, double km, Motorista POSSUI,int avaliacao, ArrayList<Veiculo> veiculos) {
        this.nomeCliente = nomeCliente;
        this.quantidadeDias = quantidadeDias;
        this.valorTotal = valorTotal;
        this.status = status;
        this.km = km;
        this.seguro = seguro;
        this.motorista = motorista;
        this.avaliacao = avaliacao;
        this.veiculos = veiculos;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km =km
    }

    public Motorista getMotorista() {
        return motorista
    }

    public getAvaliacao() {
        return avaliacao;
    }

    public void avaliar(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public boolean possuiSeguroIncluso() {
        return true;
    }
}
