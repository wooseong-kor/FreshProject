package com.min.fresh.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.fresh.dto.Couponhistory_DTO;
import com.min.fresh.dto.RowNum_DTO;

@Service
public class CouponMileageService_Impl implements ICouponMileageService {

	@Autowired
	private ICouponMileageDao dao;
	
	@Override
	public boolean updateMileageRMember(Map<String, Object> map) {
		return (dao.updateMileageRMember(map)>0)?true:false;
	}

	@Override
	public boolean updateMileageBMember(Map<String, Object> map) {
		return (dao.updateMileageBMember(map)>0)?true:false;
	}

	@Override
	public boolean updateMileageSMember(Map<String, Object> map) {
		return (dao.updateMileageSMember(map)>0)?true:false;
	}

	@Override
	public boolean updateMileageVMember(Map<String, Object> map) {
		return (dao.updateMileageVMember(map)>0)?true:false;
	}

	@Override
	public boolean updateMileageOneMember(Map<String, Object> map) {
		return (dao.updateMileageOneMember(map)>0)?true:false;
	}

	@Override
	public boolean updatePaymoneyMOne(String jumunnum) {
		return (dao.updatePaymoneyMOne(jumunnum)>0)?true:false;
	}

	@Override
	public boolean updateUseflagOne(int couseq) {
		return (dao.updateUseflagOne(couseq)>0)?true:false;
	}

	@Override
	public boolean insertCouponhistoryG(String id) {
		return (dao.insertCouponhistoryG(id)>0)?true:false;
	}

	@Override
	public boolean insertCouponhistoryB(String id) {
		return (dao.insertCouponhistoryB(id)>0)?true:false;
	}

	@Override
	public boolean insertCouponhistoryS(String id) {
		return (dao.insertCouponhistoryS(id)>0)?true:false;
	}

	@Override
	public boolean insertCouponhistoryV(String id) {
		return (dao.insertCouponhistoryV(id)>0)?true:false;
	}

	@Override
	public boolean updatePaymoneyGOne(Map<String, Object> map) {
		return (dao.updatePaymoneyGOne(map)>0)?true:false;
	}

	@Override
	public boolean updatePaymoneyBOne(Map<String, Object> map) {
		return (dao.updatePaymoneyBOne(map)>0)?true:false;
	}

	@Override
	public boolean updatePaymoneySOne(Map<String, Object> map) {
		return (dao.updatePaymoneySOne(map)>0)?true:false;
	}

	@Override
	public boolean updatePaymoneyVOne(Map<String, Object> map) {
		return (dao.updatePaymoneyVOne(map)>0)?true:false;
	}

	@Override
	public boolean updateUseflagAutoOne(String id) {
		return (dao.updateUseflagAutoOne(id)>0)?true:false;
	}

	@Override
	public boolean updateCouponUseflaghistory() {
		return (dao.updateCouponUseflaghistory()>0)?true:false;
	}

	@Override
	public int countMemberCouponHistory(String id) {
		return dao.countMemberCouponHistory(id);
	}

	@Override
	public List<Couponhistory_DTO> memberCounponHistoryList(Map<String, Object> map) {
		return dao.memberCounponHistoryList(map);
	}

	@Override
	public int countAllCouponHistory() {
		return dao.countAllCouponHistory();
	}

	@Override
	public List<Couponhistory_DTO> allCounponHistoryList(RowNum_DTO dto) {
		return dao.allCounponHistoryList(dto);
	}

	@Override
	public List<Couponhistory_DTO> memberUseMineCou(String id) {
		return dao.memberUseMineCou(id);
	}

}
