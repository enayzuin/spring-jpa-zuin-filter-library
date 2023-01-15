package br.com.enay.zuin.spring.jpa.filter.utils;

import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import br.com.enay.zuin.spring.jpa.filter.filter.DeepRoot;

public class SpecificationUtils {

	public static DeepRoot buildFinalRoot(@SuppressWarnings("rawtypes") Root root, CriteriaBuilder criteriaBuilder,
			String key) {
		DeepRoot finalRoot;
		if (key.contains(".")) {
			finalRoot = getDeepRoot(root, criteriaBuilder, key);
		} else {
			finalRoot = getSimpleRoot(root, criteriaBuilder, key);
		}
		return finalRoot;
	}

	private static Path<Object> path;

	@SuppressWarnings("unchecked")
	private static DeepRoot getDeepRoot(@SuppressWarnings("rawtypes") Root root, CriteriaBuilder criteriaBuilder,
			String key) {
		DeepRoot finalRoot = new DeepRoot();
		path = null;

		List<String> keyList = Arrays.asList(key.split("\\."));
		String firstKey = keyList.get(0);
		String lastKey = findLastKey(keyList);

		if (root.get(firstKey).getJavaType().equals(List.class)) {
			path = root.join(firstKey);
		} else {
			path = root.get(firstKey);
		}
		keyList.forEach(kl -> {
			if (!kl.equalsIgnoreCase(firstKey) && !kl.equalsIgnoreCase(lastKey)) {
				path = path.get(kl);
			}
		});

		finalRoot.setPath(path);
		finalRoot.setLastKey(lastKey);
		return finalRoot;
	}

	private static DeepRoot getSimpleRoot(@SuppressWarnings("rawtypes") Root root, CriteriaBuilder criteriaBuilder,
			String key) {
		DeepRoot finalRoot = new DeepRoot();
		finalRoot.setLastKey(key);
		return finalRoot;
	}

	private static String findLastKey(List<String> keyList) {
		if (keyList.stream().reduce((first, last) -> last).isPresent()) {
			return keyList.stream().reduce((first, last) -> last).get();
		} else {
			return null;
		}
	}

}
