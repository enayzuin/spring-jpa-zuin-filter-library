package br.com.enay.zuin.spring.jpa.filter.filter.query;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Query {
	
	private String  table;
	private List<QueryExpression> expressions;
}
