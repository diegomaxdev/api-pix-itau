package br.com.itau.application.core.domain.enums;

public enum TipoChave {
	
	CPF("CPF","^[0-9]{11}$"),
	CNPJ("CNPJ","^[0-9]{14}$"),
	CELULAR("CELULAR", "^\\+[1-9][0-9]\\d{1,14}$"),
	EMAIL("EMAIL", "^[a-z0-9.!#$&'*+\\/=?^_`{|}~-]+@[a-z0-9](?:[a-z0-9-]{0,61}[a-z0-9])?(?:\\.[a-z0-9](?:[a-z0-9-]{0,61}[a-z0-9])?)*$"),
	ALEATORIA("ALEATORIA", "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}");
	
    public final String regex;
    public final String value;

    TipoChave(String value, String regex) {
        this.value = value;
        this.regex = regex;
    }
}
