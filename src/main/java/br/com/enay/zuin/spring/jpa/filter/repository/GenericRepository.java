package br.com.enay.zuin.spring.jpa.filter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<Z>
    extends JpaRepository<Z, Long>, JpaSpecificationExecutor<Z> {}
