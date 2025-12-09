package negocio;

import java.text.DecimalFormat;

public class FolhaDePagamento {
	public static String calcular() throws Exception {
		String retorno = "";
		retorno = "Folha de Pagamento da Empresa \n\n";
		retorno += "Nome\tSalário Bruto\tDescontos\tSalário Líquido\n";
		DecimalFormat formatador = new DecimalFormat("#.00");
		for (Colaborador objColaborador : Colaborador.getTodos()) {
			double desconto = 0;
			double salarioBruto = objColaborador.getObjCargo().getSalario();
			//INSS
			if (salarioBruto < 1518) {
				desconto = salarioBruto * 0.075;
			} else if (salarioBruto < 2783.88) {
				desconto = salarioBruto * 0.09;
			} else if (salarioBruto < 4190.83) {
				desconto = salarioBruto * 0.12;
			} else if (salarioBruto < 8157.41) {
				desconto = salarioBruto * 0.14;
			}  else {
				desconto = salarioBruto * 0.17;
			}
				
			//IRPF
			if (salarioBruto < 2259.20) {
				desconto += 0;
			} else if (salarioBruto < 2826.65) {
				desconto += salarioBruto * 0.075;
			} else if (salarioBruto < 3751.05) {
				desconto += salarioBruto * 0.15;
			} else if (salarioBruto < 4464.83) {
				desconto += salarioBruto * 0.225;
			}  else {
				desconto += salarioBruto * 0.275;
			}
			retorno += objColaborador.getNome() + "\t" + salarioBruto + "\t" + (desconto) + "\t" + formatador.format(salarioBruto - desconto) + "\n";
			
		}
		return retorno;
	}
}
