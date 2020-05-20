package br.com.guedes.servidor;

import java.io.PrintStream;
import java.util.concurrent.*;

public class JuntaResultadosFeatureWSFeatureBanco implements Callable<Void> {

    private Future<String> featureAWS;
    private Future<String> featureBanco;
    private PrintStream saidaCliente;

    public JuntaResultadosFeatureWSFeatureBanco(Future<String> featureAWS, Future<String> featureBanco, PrintStream saidaCliente) {
        this.featureAWS = featureAWS;
        this.featureBanco = featureBanco;
        this.saidaCliente = saidaCliente;
    }

    @Override
    public Void call(){
        System.out.println("Aguardando resultados do feature AWS e Banco");

        try {
            String numeroMagico = this.featureAWS.get(15, TimeUnit.SECONDS);
            String numeroMagico2 = this.featureBanco.get(15, TimeUnit.SECONDS);

            this.saidaCliente.println("Resultado do comando C2 : " + numeroMagico + ", " + numeroMagico2);

        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            System.out.println("Cancelando execução do comando C2");
           this.saidaCliente.println("Timeout: Execução do comando C2");
           this.featureAWS.cancel(true);
           this.featureBanco.cancel(true);
        }

        System.out.println("Finalizou -- JuntaResultadosFeatureWSFeatureBanco");

        return null;
    }
}
