package com.zhangbin.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.zhangbin.cloud.domain.test.Test;
import java.lang.Long;
import java.util.List;

@Repository
public interface TestDao extends JpaRepository<Test, Long>, JpaSpecificationExecutor<Long> {
	
	List<Test> findById(Long id);
}
