package br.com.enay.zuin.spring.jpa.filter.service;

import br.com.enay.zuin.spring.jpa.filter.filter.query.Query;
import br.com.enay.zuin.spring.jpa.filter.responses.dto.ResponseDTO;

public interface ZuinFilter {

	public ResponseDTO filter(Query query) throws Exception;

}
