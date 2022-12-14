package br.com.itau.application.core.domain.enums;

public enum TipoExcecao {

	TIPO_CHAVE_INVALIDA {
		@Override
		public String getMensagemErro() {
			return "Este tipo de chave inválido.";
		}
	},

	TIPO_CHAVE_JA_CADASTRADA {
		@Override
		public String getMensagemErro() {
			return "Esta chave já está cadastrada em nosso Banco de dados.";
		}
	},

	LIMITE_DE_CHAVE_FISICA_JA_CADASTRADA {
		@Override
		public String getMensagemErro() {
			return "Não é possível cadastrar esta chave, pois o limite de chaves foi atingido (Até 5 chaves)";
		}
	},

	LIMITE_DE_CHAVE_JURIDICA_JA_CADASTRADA {
		@Override
		public String getMensagemErro() {
			return "Não é possível cadastrar esta chave, pois o limite de chaves foi atingido (Até 20 chaves)";
		}
	},

	CHAVE_NAO_LOCALIZADA {
		@Override
		public String getMensagemErro() {
			return "A chave informada não foi localizada ou não existe.";
		}
	},

	CHAVE_DESATIVADA {
		@Override
		public String getMensagemErro() {
			return "A chave informada já se encontra desativada.";
		}
	},
	
	CONTA_SEM_CADASTRO {
		@Override
		public String getMensagemErro() {
			return "Esta conta não possui cadastro em nosso estabelecimento, favor verificar";
		}
	},
	

	EMAIL_TAMANHO {
		@Override
		public String getMensagemErro() {
			return "O tamanho máximo de caracteres para email foi excedido (Máximo de 77 caracteres).";
		}
	},

	EMAIL_INCORRETO {
		@Override
		public String getMensagemErro() {
			return "O email informado não possui o caractere @.";
		}
	},

	EMAIL_INVALIDO {
		@Override
		public String getMensagemErro() {
			return "O email informado não é um endereço válido.";
		}
	},

	CELULAR_INICIO_INVALIDO {
		@Override
		public String getMensagemErro() {
			return "A Chave informada para Celular não Inicia com +";
		}
	},

	CELULAR_TAMANHO {
		@Override
		public String getMensagemErro() {
			return "A quantidade de caracteres informada não corresponde a uma chave Celular - (12 e 15 - Caracteres)";
		}
	},

	CELULAR_NAO_NUMERICO {
		@Override
		public String getMensagemErro() {
			return "Foram informados caracteres diferentes dos numéricos na chave Celular.";
		}
	},

	CELULAR_INVALIDO {
		@Override
		public String getMensagemErro() {
			return "O numero de celular informado não é um numero válido.";
		}
	},

	ALEATORIA_TAMANHO {
		@Override
		public String getMensagemErro() {
			return "A quantidade de caracteres informada não corresponde a uma chave Aleatoria - (36 - Caracteres)";
		}
	},

	ALEATORIA_INVALIDA {
		@Override
		public String getMensagemErro() {
			return "A Chave informada para Aleatória é inválida ou possui caracteres diferentes dos alfanuméricos";
		}
	},

	CPF_TAMANHO {
		@Override
		public String getMensagemErro() {
			return "A quantidade de caracteres informada não corresponde a uma chave Cpf - (11 - Caracteres)";
		}
	},

	CPF_NAO_NUMERICO {
		@Override
		public String getMensagemErro() {
			return "Foram informados caracteres diferentes dos numéricos na chave Cpf.";
		}
	},

	CPF_INVALIDO {
		@Override
		public String getMensagemErro() {
			return "A Chave informada para CPF é inválida ou possui caracteres diferentes dos numéricos";
		}
	},

	CPF_NUMERO_INVALIDO {
		@Override
		public String getMensagemErro() {
			return "O Número informado não corresponde a um CPF válido.";
		}
	},

	CNPJ_TAMANHO {
		@Override
		public String getMensagemErro() {
			return "A quantidade de caracteres informada não corresponde a uma chave CNPJ - (14 - Caracteres)";
		}
	},

	CNPJ_NAO_NUMERICO {
		@Override
		public String getMensagemErro() {
			return "Foram informados caracteres diferentes dos numéricos na chave CNPJ.";
		}
	},

	CNPJ_INVALIDO {
		@Override
		public String getMensagemErro() {
			return "A Chave informada para CNPJ é inválida ou possui caracteres diferentes dos numéricos";
		}
	},

	CNPJ_NUMERO_INVALIDO {
		@Override
		public String getMensagemErro() {
			return "O Número informado não corresponde a um CNPJ válido.";
		}
	},

	CONSULTA_INVALIDA {
		@Override
		public String getMensagemErro() {
			return "O Número do ID não pode ser consultado juntamento com outro valor.";
		}
	},

	CONSULTA_DATAS_INVALIDAS {
		@Override
		public String getMensagemErro() {
			return "Esta consulta não Permite consultar a Data de inclusão da chave e Data da inativação da chave. Somente um ou outro.";
		}
	};

	public abstract String getMensagemErro();
}
