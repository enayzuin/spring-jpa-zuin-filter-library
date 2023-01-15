package br.com.enay.zuin.spring.jpa.filter.filter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import br.com.enay.zuin.spring.jpa.filter.filter.query.QueryConditions;
import br.com.enay.zuin.spring.jpa.filter.utils.SpecificationUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Slf4j
public class GenericSpecification<T> implements Specification<T> {

	/** */
	private static final long serialVersionUID = -6926891575785834560L;

	private QueryConditions condition;
	private ObjectMapper mapper = new ObjectMapper();
	private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public GenericSpecification(QueryConditions condition) {
		super();
		this.condition = condition;
	}

	@Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		String key = condition.getField();
		DeepRoot finalRoot = SpecificationUtils.buildFinalRoot(root, criteriaBuilder, key);

		switch (condition.getComparator()) {
		case EQUAL:
			String equal = condition.getValues().get(0);
			return this.equal(root, finalRoot, criteriaBuilder, equal);
		case NOT_EQUAL:
			String notEqual = condition.getValues().get(0);
			return this.notEqual(root, finalRoot, criteriaBuilder, notEqual);
		case BETWEEN:
			String min = condition.getValues().get(0);
			String max = condition.getValues().get(1);
			return this.between(root, finalRoot, criteriaBuilder, min, max);
		case NOT_BETWEEN:
			String notMin = condition.getValues().get(0);
			String notMax = condition.getValues().get(1);
			return this.notBetween(root, finalRoot, criteriaBuilder, notMin, notMax);
		case GREATER:
			String greaterThan = condition.getValues().get(0);
			return this.greaterThan(root, finalRoot, criteriaBuilder, greaterThan);
		case GREATER_EQUAL:
			String greaterThanEqual = condition.getValues().get(0);
			return this.greaterThanEqual(root, finalRoot, criteriaBuilder, greaterThanEqual);
		case LIKE:
			String like = condition.getValues().get(0);
			return this.like(root, finalRoot, criteriaBuilder, like);
		case NOT_LIKE:
			String notLike = condition.getValues().get(0);
			return this.notLike(root, finalRoot, criteriaBuilder, notLike);
		case IN:
			List<String> in = condition.getValues();
			return this.in(root, finalRoot, criteriaBuilder, in);
		case NOT_IN:
			List<String> notIn = condition.getValues();
			return this.notIn(root, finalRoot, criteriaBuilder, notIn);
		case LESS:
			String lessThan = condition.getValues().get(0);
			return this.lessThan(root, finalRoot, criteriaBuilder, lessThan);
		case LESS_EQUAL:
			String lessThanEqual = condition.getValues().get(0);
			return this.lessThanEqual(root, finalRoot, criteriaBuilder, lessThanEqual);
		default:
			return null;
		}

	}

	private Predicate between(Root<T> root, DeepRoot finalRoot, CriteriaBuilder criteriaBuilder, String min,
			String max) {

//		Date dateMin = null;
//		Date dateMax = null;
//		try {
//			dateMin = this.dateFormat.parse(min + " 00:00:00");
//			dateMax = this.dateFormat.parse(max + " 23:59:59");
//		} catch (Exception e) {
//			log.error("" + e);
//			log.error("Error {}", e.getMessage());
//			return null;
//		}

		String finalRootLastKey = finalRoot.getLastKey();
		Path<Object> finalRootPath = finalRoot.getPath();

		Expression<? extends Comparable> query = finalRootPath != null ? finalRootPath.get(finalRootLastKey)
				: root.get(finalRootLastKey);
		Object newMin = null;
		Object newMax = null;
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			if (query.getJavaType().equals(Date.class)) {
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				Date minDate = df.parse(min);
				Date maxDate = df.parse(max);
				return criteriaBuilder.between(query, (Comparable) minDate, (Comparable) maxDate);
			} else {
				newMin = mapper.readValue(min, query.getJavaType());
				newMax = mapper.readValue(max, query.getJavaType());
				return criteriaBuilder.between(query, (Comparable) newMin, (Comparable) newMax);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	private Predicate notBetween(Root<T> root, DeepRoot finalRoot, CriteriaBuilder criteriaBuilder, String min,
			String max) {

		Date dateMin = null;
		Date dateMax = null;
		try {
			dateMin = this.dateFormat.parse(min + " 00:00:00");
			dateMax = this.dateFormat.parse(max + " 23:59:59");
		} catch (Exception e) {
			log.error("" + e);
			log.error("Error {}", e.getMessage());
			return null;
		}
		String finalRootLastKey = finalRoot.getLastKey();
		Path<Object> finalRootPath = finalRoot.getPath();

		Expression<? extends Comparable> query = finalRootPath != null ? finalRootPath.get(finalRootLastKey)
				: root.get(finalRootLastKey);

		return criteriaBuilder.not(criteriaBuilder.between(query, (Comparable) dateMin, (Comparable) dateMax));
	}

	private Predicate like(Root<T> root, DeepRoot finalRoot, CriteriaBuilder criteriaBuilder, Object like) {

		Path<Object> finalRootPath = finalRoot.getPath();
		String finalRootLastKey = finalRoot.getLastKey();
		String filterValueAsString = mapper.convertValue(like, String.class);

		Expression<?> query = finalRoot.getPath() != null ? finalRootPath.get(finalRootLastKey)
				: root.get(finalRootLastKey);

		return criteriaBuilder.like(query.as(String.class), filterValueAsString + "%");
	}

	private Predicate equal(Root<T> root, DeepRoot finalRoot, CriteriaBuilder criteriaBuilder, Object equal) {
		Path<Object> finalRootPath = finalRoot.getPath();
		String finalRootLastKey = finalRoot.getLastKey();

		Expression<?> query = finalRootPath != null ? finalRootPath.get(finalRootLastKey) : root.get(finalRootLastKey);
		return criteriaBuilder.equal(query, equal);
	}

	private Predicate notEqual(Root<T> root, DeepRoot finalRoot, CriteriaBuilder criteriaBuilder, Object notEqual) {
		Path<Object> finalRootPath = finalRoot.getPath();
		String finalRootLastKey = finalRoot.getLastKey();

		Expression<?> query = finalRootPath != null ? finalRootPath.get(finalRootLastKey) : root.get(finalRootLastKey);
		return criteriaBuilder.not(criteriaBuilder.equal(query, notEqual));
	}

	private Predicate in(Root<T> root, DeepRoot finalRoot, CriteriaBuilder criteriaBuilder, List<?> in) {
		Path<Object> finalRootPath = finalRoot.getPath();
		String finalRootLastKey = finalRoot.getLastKey();

		Expression<?> query = finalRootPath != null ? finalRootPath.get(finalRootLastKey) : root.get(finalRootLastKey);
		return query.in(in);
	}

	private Predicate notIn(Root<T> root, DeepRoot finalRoot, CriteriaBuilder criteriaBuilder, List<?> in) {
		Path<Object> finalRootPath = finalRoot.getPath();
		String finalRootLastKey = finalRoot.getLastKey();

		Expression<?> query = finalRootPath != null ? finalRootPath.get(finalRootLastKey) : root.get(finalRootLastKey);
		return criteriaBuilder.not(criteriaBuilder.in(query.in(in)));
	}

	private Predicate greaterThan(Root<T> root, DeepRoot finalRoot, CriteriaBuilder criteriaBuilder,
			Object greaterThan) {
		Path<Object> finalRootPath = finalRoot.getPath();
		String finalRootLastKey = finalRoot.getLastKey();

		Expression query = finalRootPath != null ? finalRootPath.get(finalRootLastKey) : root.get(finalRootLastKey);

		return criteriaBuilder.greaterThan(query, (Date) greaterThan);
	}

	private Predicate greaterThanEqual(Root<T> root, DeepRoot finalRoot, CriteriaBuilder criteriaBuilder,
			Object greaterThan) {
		Path<Object> finalRootPath = finalRoot.getPath();
		String finalRootLastKey = finalRoot.getLastKey();

		Expression<Date> query = finalRootPath != null ? finalRootPath.get(finalRootLastKey)
				: root.get(finalRootLastKey);
		return criteriaBuilder.greaterThanOrEqualTo(query, (Date) greaterThan);
	}

	private Predicate lessThan(Root<T> root, DeepRoot finalRoot, CriteriaBuilder criteriaBuilder, Object greaterThan) {
		Path<Object> finalRootPath = finalRoot.getPath();
		String finalRootLastKey = finalRoot.getLastKey();

		Expression<Date> query = finalRootPath != null ? finalRootPath.get(finalRootLastKey)
				: root.get(finalRootLastKey);
		return criteriaBuilder.lessThan(query, (Date) greaterThan);
	}

	private Predicate lessThanEqual(Root<T> root, DeepRoot finalRoot, CriteriaBuilder criteriaBuilder,
			Object greaterThan) {
		Path<Object> finalRootPath = finalRoot.getPath();
		String finalRootLastKey = finalRoot.getLastKey();

		Expression<Date> query = finalRootPath != null ? finalRootPath.get(finalRootLastKey)
				: root.get(finalRootLastKey);
		return criteriaBuilder.lessThanOrEqualTo(query, (Date) greaterThan);
	}

	private Predicate notLike(Root<T> root, DeepRoot finalRoot, CriteriaBuilder criteriaBuilder, Object notLike) {

		Path<Object> finalRootPath = finalRoot.getPath();
		String finalRootLastKey = finalRoot.getLastKey();
		String filterValueAsString = mapper.convertValue(notLike, String.class);

		Expression<?> query = finalRoot.getPath() != null ? finalRootPath.get(finalRootLastKey)
				: root.get(finalRootLastKey);

		return criteriaBuilder.not(criteriaBuilder.like(query.as(String.class), filterValueAsString + "%"));
	}

}
