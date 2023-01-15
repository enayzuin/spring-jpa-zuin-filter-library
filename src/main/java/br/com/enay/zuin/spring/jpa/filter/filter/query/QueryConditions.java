package br.com.enay.zuin.spring.jpa.filter.filter.query;

import java.util.List;

import br.com.enay.zuin.spring.jpa.filter.filter.query.enums.QueryComparators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QueryConditions  {
	private String field;
	private List<String> values;
	private QueryComparators comparator;
}
