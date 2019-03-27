package com.zhangbin.cloud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zhangbin.cloud.domain.system.TbUser;

@Repository
public interface UserRepository extends JpaRepository<TbUser, Long>, JpaSpecificationExecutor<TbUser> {
	/**
	 * 根据用户名查找记录
	 * @param userName
	 * @return
	 */
	public TbUser findByUserName(String userName);
	/**
	 * 根据手机号码查找记录
	 * @param userPhone
	 * @return
	 */
	public TbUser findByUserPhone(String userPhone);
	/**
	 * 根据用户名查询除自身外其它的重复记录
	 * @param userName
	 * @param userId
	 * @return
	 */
	@Query(value="SELECT * FROM tb_user t WHERE t.user_name=?1 AND t.user_id !=?2",nativeQuery = true)
	public TbUser findRepeatByUserName(String userName,Long userId);
	/**
	 * 根据用户手机号码查询除自身外其它的重复记录
	 * @param userPhone
	 * @param userId
	 * @return
	 */
	@Query(value = "SELECT * FROM tb_user t WHERE t.user_phone=?1 AND t.user_id !=?2",nativeQuery=true)
	public TbUser findRepeatByUserPhone(String userPhone, Long userId);
	/**
	 * 查询所有有效用户
	 * @return
	 */
	@Query(value = "select * from tb_user t where t.`status` =1 order by t.`created` desc",nativeQuery = true)
	public List<TbUser> findAllUser();
	/**
	 * 根据用户名查询用户记录
	 * @param userNameList
	 * @return
	 */
	public List<TbUser> findByUserNameIn(List<String> userNameList);
	/**
	 * 根据用户手机号码查询用户记录
	 * @param userPhoneList
	 * @return
	 */
	public List<TbUser> findByUserPhoneIn(List<String> userPhoneList);
	
}
