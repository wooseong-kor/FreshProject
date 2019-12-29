package com.min.fresh.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.fresh.dto.Member_DTO;
import com.min.fresh.model.IMemberService;

@Controller
public class MemberManagement_Controller {

	private Logger log = LoggerFactory.getLogger(MemberManagement_Controller.class);

	@Autowired
	private IMemberService service;

	@RequestMapping(value = "/allMemberList.do", method = RequestMethod.GET)
	public String allMemberList(Model model) {
		log.info("☆☆☆☆☆ 전체 회원 조회 이동 ☆☆☆☆☆");
		List<Member_DTO> lists = service.allMemberListScroll();
		model.addAttribute("AllMemberLists", lists);
		return "AllMemberList";
	}
	
	@RequestMapping(value = "/memberList.do", method = RequestMethod.GET)
	public String memberListScroll(Model model) {
		log.info("☆☆☆☆☆ 전체 회원 조회 이동 ☆☆☆☆☆");
		List<Member_DTO> lists = service.memberListScroll();
		model.addAttribute("MemberLists", lists);
		return "MemberList";
	}
	
	@RequestMapping(value = "/mileageAdd.do", method = RequestMethod.GET)
	public String mileageAdd(Model model, String id) {
		log.info("★★★★★ 관리자 회원 마일리지 적립 창 띄우기 ★★★★★ ID = {}", id);
		Member_DTO dto = service.memberSearchOne(id);
		System.out.println("★★★ 회원검색 확인 ★★★\n" + dto.toString());
		model.addAttribute("id", dto.getId());
		model.addAttribute("name", dto.getName());
		model.addAttribute("mileage", dto.getMileage());
		return "MileageAdd";
	}
	
	@RequestMapping(value = "/mileageAddOK.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> mileageAddOK(Model model, String id, String mileage) {
		log.info("★★★★★ 관리자 회원 마일리지 적립 적용 ★★★★★{}, {}", id, mileage);
		Member_DTO dto = service.memberSearchOne(id);
		if (dto.getId().equals(id)) {
			dto.setMileage(Integer.parseInt(mileage));
		}
		System.out.println("★★★적립 후 마일리지 확인 ★★★\n" + dto.getId() + "/" + dto.getMileage());
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", dto.getId());
		map.put("mileage", dto.getMileage());
		boolean isc = service.updateMileageMemberOne(map); // 마일리지 수정
		System.out.println("★★★ 적립여부 확인 ★★★\n" + isc);
		
		List<Member_DTO> allDto = service.memberListScroll(); // 다시 사용중 회원리스트 가져오기
		map.put("allDto", allDto);
		return map;
	}

}
