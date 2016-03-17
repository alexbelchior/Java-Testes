public class TesteServico {

	/**
	 * @param args
	 */
	 //Precisa gerar os stubs para a realizacao do teste
	public static void main(String[] args) {
		PropostaWebService simulacaoDentalWS = new PropostaWebServiceService().getPropostaWebServicePort();
		try {
			PlanoVO plano = simulacaoDentalWS.obterPlanoPorCodigo(SimulacaoDentalConstantes.PLANO_XXX_XXX);
			System.out.println("valor" + plano.getValorPlanoVO().getValorAnualTitular());
		} catch (BusinessException_Exception e) {
			// TODO Bloco catch gerado automaticamente
			e.printStackTrace();
		} catch (IntegrationException_Exception e) {
			// TODO Bloco catch gerado automaticamente
			e.printStackTrace();
		}
	}

}
