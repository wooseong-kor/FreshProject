package com.min.fresh.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.min.fresh.model.ICouponMileageDao;

public class CouponDelete {

	private Logger logger = LoggerFactory.getLogger(CouponDelete.class);
	
	@Autowired
	private ICouponMileageDao dao;
	
	public void couponDelete() {
		logger.info("가입지급 쿠폰 이외에 쿠폰 상태 변경");
		int cnt = dao.updateCouponUseflaghistory();
		System.out.println("반환된 값 : "+cnt);
	}
	
}
