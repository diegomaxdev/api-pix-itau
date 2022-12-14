package br.com.itau.adapters.in.controller.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

	private List<String> messagens = new ArrayList<>();
	private String erro;
	private int codigo;
	private Date timestemp;
	private String path;
}
