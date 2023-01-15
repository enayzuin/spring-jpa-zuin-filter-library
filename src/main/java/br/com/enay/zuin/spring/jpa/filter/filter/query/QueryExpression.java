package br.com.enay.zuin.spring.jpa.filter.filter.query;

import java.util.List;

import br.com.enay.zuin.spring.jpa.filter.filter.query.enums.QueryOperations;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QueryExpression  {
	private List<QueryConditions> conditions;
	private QueryOperations operation;
}
