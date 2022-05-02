public abstract class  Conta implements iconta {
    private static final int AGENCIA_PADRAO= 1;
    private static int SEQUENCIAL=1;
    protected int agencia;
    protected int numero;
    protected double saldo=0;
    protected Cliente cliente;


    public Conta(Cliente cliente){
        this.agencia= Conta.AGENCIA_PADRAO;
        this.numero= SEQUENCIAL++;
        this.cliente=cliente;
    }

    @Override
    public void depositar(double valor) {
    saldo+=valor;
    }

    @Override
    public void sacar(double valor) {
        if(saldo>=valor) {	saldo-=valor;}
        else { System.out.println(String.format("!!!!! Saldo insulficiente !!!!! \n Saldo: %.2f \n",this.saldo));}
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
    	if(saldo>=valor) {
    		this.sacar(valor);
    		contaDestino.depositar(valor);
        }
        else { System.out.println(String.format("!!!!! Saldo insulficiente !!!!! \n Saldo: %.2f \n",this.saldo));}

    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }
    
	protected void imprimirInfoComuns(String tipoConta) {
        System.out.println(String.format("Titular: %s",this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d",this.agencia));
        System.out.println(String.format(tipoConta+": 0000%d",this.numero));
        System.out.println(String.format("Saldo: %.2f \n",this.saldo));
        
	}
    
}
