public class Veiculo {
    private int id;
    private String placa;
    private String modelo;
    private String marca;
    private Cliente proprietario;

    public Veiculo(int id, String placa, String modelo, String marca, Cliente proprietario) {
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.proprietario = proprietario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Cliente getProprietario() {
        return proprietario;
    }

    public void setProprietario(Cliente proprietario) {
        this.proprietario = proprietario;
    }

    public void exibirDados() {
        System.out.println("ID: " + id + " | Placa: " + placa + " | Modelo: " + modelo + " | Proprietário: " + proprietario.getNome());
    }
}