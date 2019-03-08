package com.zhangbin.cloud.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.util.CollectionUtils;

public class PageBeanUtils {
	
	/**
	 * 不排序分页查询
	 * @param page
	 * @param size
	 * @return
	 */
	public static PageRequest pageRequest(int page,int size) {
		page = page -1 >=0 ? page-1 : 0;//避免出现负数
		return new PageRequest(page, size);
	}
	
	/**
	 * 带排序分页查询
	 * @param page
	 * @param size
	 * @param map
	 * @return
	 */
	public static PageRequest pageRequest(int page, int size,Map<String, Direction> map) {
		page = page -1 >=0 ? page-1 : 0;//避免出现负数
		if(CollectionUtils.isEmpty(map)) {
			return new PageRequest(page, size);
		}else {
			List<Order> orders = new ArrayList<>();
			for(Map.Entry<String, Direction> entry : map.entrySet()) {
				Order order = new Order(entry.getValue(), entry.getKey());
				orders.add(order);
			}
			Sort sort = new Sort(orders);
			return new PageRequest(page, size, sort);
		}
	}
}
