package com.min.fresh.utils;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.min.fresh.dto.Member_DTO;
import com.min.fresh.model.ICouponMileageDao;
import com.min.fresh.model.IMemberDao;


public class CouponManagement {
	
	private Logger logger = LoggerFactory.getLogger(CouponManagement.class);

	@Autowired
	private IMemberDao dao;
	
	@Autowired
	private ICouponMileageDao cdao;
	
	/**
	 * 가입축하쿠폰 제외 나머지 쿠폰 지급 등급에따라 다르게 지급한다.
	 */
	public void memberTakeCoupon() {
		logger.info("쿠폰지급시작");
		List<Member_DTO> lists = dao.allMemberListScroll();
		for(Member_DTO dto : lists) {
			if(dto.getDelflag().equalsIgnoreCase("N")) {
				if(dto.getGcode().equalsIgnoreCase("B")) {
					int insertB = cdao.insertCouponhistoryB(dto.getId());
					System.out.println(insertB);
				}else if(dto.getGcode().equalsIgnoreCase("S")) {
					int insertB = cdao.insertCouponhistoryB(dto.getId());
					int insertS = cdao.insertCouponhistoryS(dto.getId());
					System.out.println(insertB+"&"+insertS);
				}else if(dto.getGcode().equalsIgnoreCase("V")) {
					int insertB = cdao.insertCouponhistoryB(dto.getId());
					int insertS = cdao.insertCouponhistoryS(dto.getId());
					int insertV = cdao.insertCouponhistoryV(dto.getId());
					System.out.println(insertB+"&"+insertS+"&"+insertV);
				}else {
					System.out.println("nothing");
				}
			}
		}
	}
	
}
