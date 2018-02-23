/**
 * 
 */
package com.meikai.shop.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TShopMemberDao;
import com.meikai.shop.entity.TShopMember;
import com.meikai.shop.service.MemberService;

/**
 * 用户
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("memberServiceImpl")
public class MemberServiceImpl extends BaseServiceImpl<TShopMember, Long> implements MemberService {

	
	@Autowired
	private TShopMemberDao memberDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(memberDao);
	}
	
	
}
