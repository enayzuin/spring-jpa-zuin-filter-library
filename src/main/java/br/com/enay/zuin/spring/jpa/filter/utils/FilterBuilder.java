package br.com.enay.zuin.spring.jpa.filter.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import br.com.enay.zuin.spring.jpa.filter.filter.GenericSpecification;
import br.com.enay.zuin.spring.jpa.filter.filter.query.Query;
import br.com.enay.zuin.spring.jpa.filter.filter.query.QueryConditions;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FilterBuilder<Z> {

	private Specification<Z> where;
	private Specification<Z> expressionSpecification;

	public Specification<Z> buildFilter(Query query) throws Exception {
		log.info("buildFilter");
		this.buildExpressions(query);
		return where;

//		query.getFilters().stream().forEach(filter -> {
//			if (filter.getKey().equalsIgnoreCase("allotmentDate")) {
//				FilterCriteria filterCriteria = new FilterCriteria();
//				filterCriteria.setKey("createdAt");
//				filterCriteria.setMin(filter.getValues().get(0));
//				filterCriteria.setMax(filter.getValues().get(1));
//				where = buildAndCondition(filterCriteria, where);
//			} else {
//				//
//				if (filter.getValues() != null && !filter.getValues().isEmpty()) {
//					orValues = null;
//					filter.getValues().stream().forEach(value -> {
//						FilterCriteria filterCriteria = new FilterCriteria();
//						filterCriteria.setKey(convertDtoKeyToEntityKey(filter.getKey()));
//						filterCriteria.setEqual(value);
//						orValues = buildOrCondition(filterCriteria, orValues);
//					});;;///
//					where = buildAndCondition(orValues, where);
//				}
//				if (StringUtils.isNotBlank(filter.getLike())) {
//					FilterCriteria filterCriteria = new FilterCriteria();
//					filterCriteria.setKey(convertDtoKeyToEntityKey(filter.getKey()));
//					filterCriteria.setLike(filter.getLike());
//					where = buildAndCondition(filterCriteria, where);
//				}
//			}
//		});

	}

	private void buildExpressions(Query query) {
		where = null;
		expressionSpecification = null;
		
		query.getExpressions().forEach(expression -> {
			expressionSpecification = null;
			expression.getConditions().forEach(condition -> {
				switch (expression.getOperation()) {
				case AND:
					expressionSpecification = buildAndOperation(condition, expressionSpecification);
					break;
				case OR:
					expressionSpecification = buildOrOperation(condition, expressionSpecification);
					break;
				}
			});
			where = buildAndOperation(expressionSpecification, where);
		});
	}

	private Specification<Z> buildAndOperation(Specification<Z> newWhere, Specification<Z> where) {
		return where == null ? newWhere : where.and(newWhere);
	}

	private Specification<Z> buildAndOperation(QueryConditions condition, Specification<Z> where) {

		GenericSpecification<Z> specification = new GenericSpecification<Z>(condition);

		return where == null ? specification : where.and(specification);
	}

	private Specification<Z> buildOrOperation(QueryConditions filterCriteria, Specification<Z> where) {
		GenericSpecification<Z> specification = new GenericSpecification<Z>(filterCriteria);

		return where == null ? specification : where.or(specification);
	}

	public String convertDateToString(Date convertDate) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(convertDate);
	}

//	private  String convertDtoKeyToEntityKey(String dtoKey) {
//
//		if (dtoKey.equalsIgnoreCase("etv")) {
//			return "etvEntity.referenceId";
//		}
//		if (dtoKey.equalsIgnoreCase("currency")) {
//			return "currency.id";
//		}
//		if (dtoKey.equalsIgnoreCase("allotment")) {
//			return "id";
//		}
//		if (dtoKey.equalsIgnoreCase("allotment.status")) {
//			return "status";
//		}
//		if (dtoKey.equalsIgnoreCase("retainedNotes.etvEntity.name.etvName")) {
//			return "etvEntity.name.etvName";
//		}
//		if (dtoKey.equalsIgnoreCase("retainedNotes.etvEntity.branch.etvBranch")) {
//			return "etvEntity.branch.etvBranch";
//		}
//		return dtoKey;
//	}

}
