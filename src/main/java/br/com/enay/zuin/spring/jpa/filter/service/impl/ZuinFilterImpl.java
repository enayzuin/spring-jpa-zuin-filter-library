package br.com.enay.zuin.spring.jpa.filter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.enay.zuin.spring.jpa.filter.filter.query.Query;
import br.com.enay.zuin.spring.jpa.filter.repository.GenericRepository;
import br.com.enay.zuin.spring.jpa.filter.responses.dto.ResponseDTO;
import br.com.enay.zuin.spring.jpa.filter.service.ZuinFilter;
import br.com.enay.zuin.spring.jpa.filter.utils.FilterBuilder;

@Service
public class ZuinFilterImpl<Z> implements ZuinFilter {

	@Autowired
	private FilterBuilder<Z> filterBuilder;

	@Autowired
	private GenericRepository<Z> repository;

	@Override
	public ResponseDTO<Z> filter(Query query) throws Exception {
		ResponseDTO<Z> response = new ResponseDTO<Z>();
		response.setContent(repository.findAll(filterBuilder.buildFilter(query)));
		return response;
	}

}
