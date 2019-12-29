package com.min.fresh.ctrl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.min.fresh.dto.AddrList_DTO;
import com.min.fresh.dto.Hoogi_DTO;
import com.min.fresh.dto.Jaego_DTO;
import com.min.fresh.dto.Jumun_DTO;
import com.min.fresh.dto.Jumunpage_DTO;
import com.min.fresh.dto.Member_DTO;
import com.min.fresh.dto.Payhistory_DTO;
import com.min.fresh.dto.ProductImg_DTO;
import com.min.fresh.dto.QA_GO_DTO;
import com.min.fresh.dto.RowNum_DTO;
import com.min.fresh.model.IBoardServiceDao;
import com.min.fresh.model.IJumun_PaymentService;
import com.min.fresh.model.IMemberService;
import com.min.fresh.model.IPagingService;
import com.min.fresh.utils.FileUpload;

@Controller
public class board_Controller {
	// 마이페이지,게시판 컨트롤러
	private Logger log = LoggerFactory.getLogger(board_Controller.class);

	@Autowired
	private IBoardServiceDao service;

	@Autowired
	private IJumun_PaymentService jservice;

	@Autowired
	private IPagingService pservice;

	// 배송지 관리
	// 배송지 추가하기(배송지 이름,연락처,주소 )
	@RequestMapping(value = "/insertAddrlist.do", method = RequestMethod.GET)
	public String insertAddrlist(Model model, AddrList_DTO dto) {
		log.info("insertAddrlist 배송지 등록폼 이동", new Date());
		model.addAttribute("dto", dto);
		return "insertAddrlist";
	}

	// 배송지 추가 입력 폼
	@RequestMapping(value = "/insertAddrlistForm.do", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String insertAddrlistForm(AddrList_DTO aDto) {
		log.info("insertAddrlistForm 배송지 등록", aDto);
		String id = aDto.getId();
		log.info("countMemberAddrList 배송지 갯수", id);
		int n = service.countMemberAddrList(id);
		System.out.println("countmemberaddlist=" + n);
		if (n < 3) {
			boolean isc = service.insertAddrlist(aDto);
			System.out.println("배송지 3개 이하. 등록됨");
			return "배송지 3개 이하. 등록됨";
		} else {
			System.out.println("배송지 3개 이상. 등록안됨");
			return "배송지 3개 이상. 등록안됨";
		}
	}

	// 배송지 수정 폼
	@RequestMapping(value = "/updateAddrlist.do", method = RequestMethod.GET)
	public String updateAddrlist(AddrList_DTO aDto, Model model) {
		log.info("updateAddrlist 배송지 수정");
		model.addAttribute("dto", aDto);
		return "updateAddrlist";
	}

	// 배송지 수정
	@RequestMapping(value = "/updateAddrlistForm.do", method = RequestMethod.POST)
	public String updateAddrlistForm(AddrList_DTO aDto, Model model) {
		log.info("updateAddrlistForm 배송지 수정");
		boolean isc = service.updateAddrlist(aDto);
		return isc ? "redirect:/addrListOne.do?id=" + aDto.getId() + "bsgcode" + aDto.getBsgcode()
				: "redirect:/updateAddrlist.do";
	}

	// 배송지 삭제
	@RequestMapping(value = "/deleteAddrlist.do", method = RequestMethod.POST)
	public String deleteAddrlist(String id, String bsgcode) {
		log.info("deleteAddrlist 배송지 삭제", id, bsgcode);
		boolean isc = service.deleteAddrlist(bsgcode, id);
		return "redirect:/insertAddlist.do";
	}

	// 배송지 조회
	@RequestMapping(value = "/addrlistIdList.do", method = RequestMethod.GET)
	public String addrlistIdList(String id, Model model) {
		log.info("addrlistIdList 배송지 목록 조회", id);
		List<AddrList_DTO> aDto = service.addrlistIdList(id);
		model.addAttribute("aDto", aDto);
		return "addrlistIdList";
	}

	// 배송지 상세조회
	@RequestMapping(value = "/addrListOne.do", method = RequestMethod.GET)
	public String addrListOne(Model model, HttpServletRequest req) {
		log.info("addrListOne 배송지 상세 조회");
		String id = req.getParameter("id");
		String bsgcode = req.getParameter("bsgcode");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("bsgcode", bsgcode);
		log.info(id, bsgcode);
		AddrList_DTO aDto = service.addrListOne(map);
		System.out.println(aDto);
		model.addAttribute("aDto", aDto);
		return "addrListOne";
	}

	// QnA
	// QnA 글 작성
	@RequestMapping(value = "/insertQago.do", method = RequestMethod.GET)
	public String insertQago(Model model, QA_GO_DTO dto) {
		log.info("insertQago 글 작성 이동");
		model.addAttribute("dto", dto);
		return "insertQago";
	}

	// QnA 글 작성 에디터
	@RequestMapping(value = "/insertQagoImg.do", method = RequestMethod.POST)
	public void insertQagoImg(HttpServletRequest req, HttpServletResponse resp, @RequestParam MultipartFile upload)
			throws IOException {
		log.info("insertQagoImg 이미지 업로드");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		OutputStream out = null;// 파일의 데이터를 저장할 경로에 바이트 형태로 보내주는 스트림
		PrintWriter printWriter = null;// 출력을 지원해주는 스트림
		JsonObject json = new JsonObject();// json으로 사용하기 위해.
		FileUpload fu = new FileUpload();

		String filename = upload.getOriginalFilename();// 화면에서 등록한 파일을 담은 파라미터

		try {
			byte[] bytes = upload.getBytes();// byte를 사용하기 때문
			// 상대경로(was에 저장되는 경로
			String attachPath = "C:\\eclipse_fresh\\eclipse-jee-2019-09-R-win32-x86_64\\eclipse\\workspace_fresh\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Project_Fresh\\image\\";
			// 파일이 업로드 되는 경로(상대
			String uploadPath = attachPath.replace("/", "\\") + filename;
			String realPath = "C:\\Users\\user\\git\\FreshProject\\Project_Fresh\\src\\main\\webapp\\image/";

			System.out.println(filename);

			out = new FileOutputStream(new File(uploadPath));
			out.write(bytes);
			fu.fileCopy(attachPath + "\\" + filename, realPath + "\\" + filename);

			System.out.println(out);

			printWriter = resp.getWriter();
			String fileUrl = "http://localhost:8099/Project_Fresh/image/" + filename;
			System.out.println(fileUrl);

			json.addProperty("uploaded", 1);
			json.addProperty("fileName", filename);
			json.addProperty("url", fileUrl);

			printWriter.println(json);
			req.setAttribute("fileUrl", fileUrl);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
			if (printWriter != null) {
				printWriter.close();
			}
		}

	}

	@RequestMapping(value = "/QagoWrite.do", method = RequestMethod.POST)
	public String QagoWrite(QA_GO_DTO dto) {
		log.info("QagoWrite");
		boolean isc = service.insertQago(dto);
		return isc ? "redirect:/QagoOne.do?id=" + dto.getId() + "&seq=" + dto.getSeq() : "insertQago";
	}

	// QnA 글 수정 입력
	@RequestMapping(value = "/updateQago.do", method = RequestMethod.GET)
	public String updateQago(@RequestParam("seq") int seq, Model model) {
		log.info("updateQago 글 작성 폼 입력");
		QA_GO_DTO dto = service.qagoOne(seq);
		model.addAttribute("dto", dto);
		return "updateQagoForm";
	}

	// QnA 글 수정 등록
	@RequestMapping(value = "/updateQagoForm.do", method = RequestMethod.POST)
	public String updateQagoForm(QA_GO_DTO dto) {
		log.info("updateQagoForm 글 작성 등록");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", dto.getTitle());
		map.put("content", dto.getContent());
		map.put("seq", dto.getSeq());
		boolean isc = service.updateQago(dto);
		return isc ? "redirect:/QagoOne.do?seq=" + dto.getSeq() : "updateQagoForm";
	}

	// QnA,공지사항 글 삭제
	@RequestMapping(value = "/deleteQago.do", method = RequestMethod.GET)
	public String deleteQago(int seq) {
		log.info("deleteQago 글 삭제", seq);
		boolean isc = service.deleteQago(seq);
		return isc ? "redirect:/updateQago.do" : "redirect:/updateQago.do";
	}

	// QnA,공지 글 상세 조회
	@RequestMapping(value = "/QagoOne.do", method = RequestMethod.GET)
	public String qagoOne(@RequestParam("seq") int seq, Model model) {
		log.info("qagoOne 글 상세조회", seq);
		QA_GO_DTO qDto = service.qagoOne(seq);
		model.addAttribute("qDto", qDto);
		return "QagoOne";
	}

	// QnA 답글 작성
	@RequestMapping(value = "/insertAnswer.do", method = RequestMethod.GET)
	public String insertAnswer(QA_GO_DTO dto, Model model) {
		log.info("insertAnswer 답글 등록");
		model.addAttribute("dto", dto);
		return "insertAnswer";
	}

	// QnA 답글 작성
	@RequestMapping(value = "/insertAnswerForm.do", method = RequestMethod.POST)
	public String insertAnswerForm(QA_GO_DTO dto) {
		log.info("insertAnswerForm 답글 등록");
		System.out.println(dto);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq", dto.getSeq());
		map.put("content", dto.getAcontent());
		boolean isc = service.insertAnswer(map);
		return isc ? "redirect:/insertAnswer.do" : "redirect:/insertAnswer.do";
	}

	// QnA 답글 수정
	@RequestMapping(value = "/updateAnswer.do", method = RequestMethod.GET)
	public String updateAnswer(QA_GO_DTO qDto) {
		log.info("updateAnswer 답글 수정", qDto);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq", qDto.getSeq());
		map.put("title", qDto.getTitle());
		map.put("content", qDto.getAcontent());
		boolean isc = service.updateAnswer(map);
		return isc ? "redirect:/updateAnswer.do" : "redirect:/updateAnswer.do";
	}

	// QnA 답변 글 삭제
	@RequestMapping(value = "/deleteAnswer.do", method = RequestMethod.GET)
	public String deleteAnswer(int seq) {
		log.info("deleteAnswer 답글 삭제", seq);
		boolean isc = service.deleteAnswer(seq);
		return isc ? "redirect:/updateAnswer.do" : "redirect:/updateAnswer.do";
	}

	// QnA 답변 글 조회
	@RequestMapping(value = "/answerOne.do", method = RequestMethod.GET)
	public String answerOne(int seq, Model model) {
		log.info("answerOne 상세조회", seq);
		QA_GO_DTO qDto = service.answerOne(seq);
		model.addAttribute("dto", qDto);
		return "answerOne";
	}

	// 페이징(관리자용 qa 글 목록)
	@RequestMapping(value = "/pagingTest.do", method = RequestMethod.GET)
	public String pagingTest(Model model) {
		log.info("paging 조회");
		RowNum_DTO rDto = new RowNum_DTO(); // 페이징 dto
		rDto.setTotal(pservice.countAllQa());// total=>count
		int count = rDto.getCount(); // 페이지 갯수
		System.out.println("페이지 갯수" + count);
		System.out.println(rDto);
		List<QA_GO_DTO> lists = pservice.allQaList(rDto);
		model.addAttribute("lists", lists);
		model.addAttribute("count", count);
		return "pagingTest";
	}

	// 상품 후기
	// 상품 후기 등록
	@RequestMapping(value = "/insertHoogi.do", method = RequestMethod.GET)
	public String insertHoogi() {
		log.info("insertHoogi 후기 입력");
		return "insertHoogi";
	}

	// 상품 후기 등록
	@RequestMapping(value = "/insertHoogiForm.do", method = RequestMethod.POST)
	@ResponseBody
	public String insertHoogiForm(Hoogi_DTO hDto) {
		log.info("insertHoogiForm 후기 입력", hDto);
		boolean isc = service.insertHoogi(hDto);
		return "insertHoogi";
	}

	// 상품 후기 수정
	@RequestMapping(value = "/updateHoogi.do", method = RequestMethod.GET)
	public String updateHoogi(Hoogi_DTO hDto) {
		log.info("updateHoogi 후기 수정", hDto);
		boolean isc = service.updateHoogi(hDto);
		return isc ? "updateHoogi" : "updateHoogi";
	}

	// 상품 후기 상세 조회
	@RequestMapping(value = "/hoogiOne.do", method = RequestMethod.GET)
	public String hoogiOne(Model model, String sangpgnum) {
		log.info("hoogiOne 후기 상세");
		Hoogi_DTO hDto = new Hoogi_DTO();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", hDto.getId());
		map.put("seq", hDto.getSeq());
		return "hoogiOne";
	}

	// 상품 구매페이지 등록
	@RequestMapping(value = "/insertJumunpage.do", method = RequestMethod.GET)
	public String insertJumunpage() {
		log.info("insertJumunpage 구매페이지 등록");
		return "insertJumunpage";
	}

	// 구매페이지 에디터
	@RequestMapping(value = "/insertJumunpageImg.do", method = RequestMethod.POST)
	public void insertJumunpageImg(HttpServletRequest req, HttpServletResponse resp, @RequestParam MultipartFile upload)
			throws IOException {
		log.info("insertJumunpageImg 이미지 업로드");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		OutputStream out = null;// 파일의 데이터를 저장할 경로에 바이트 형태로 보내주는 스트림
		PrintWriter printWriter = null;// 출력을 지원해주는 스트림
		FileUpload fu = new FileUpload();
		JsonObject json = new JsonObject();// json으로 사용하기 위해.

		String filename = upload.getOriginalFilename();// 화면에서 등록한 파일을 담은 파라미터

		try {
			byte[] bytes = upload.getBytes();// byte를 사용하기 때문
			// 상대경로(was에 저장되는 경로
			String attachPath = "C:\\eclipse_fresh\\eclipse-jee-2019-09-R-win32-x86_64\\eclipse\\workspace_fresh\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Project_Fresh\\image\\";
			// 파일이 업로드 되는 경로(상대
			String uploadPath = attachPath.replace("/", "\\") + filename;
			String realPath = "C:\\Users\\user\\git\\FreshProject\\Project_Fresh\\src\\main\\webapp\\image/";

			System.out.println(filename);

			out = new FileOutputStream(new File(uploadPath));
			out.write(bytes);
			fu.fileCopy(attachPath + "\\" + filename, realPath + "\\" + filename);

			System.out.println(out);

			printWriter = resp.getWriter();
			String fileUrl = "http://localhost:8099/Project_Fresh/image/" + filename;
			System.out.println(fileUrl);

			json.addProperty("uploaded", 1);
			json.addProperty("fileName", filename);
			json.addProperty("url", fileUrl);

			printWriter.println(json);
			req.setAttribute("fileUrl", fileUrl);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
			if (printWriter != null) {
				printWriter.close();
			}
		}

	}

	// 상품 구매페이지 등록
	@RequestMapping(value = "/insertJumunpageForm.do", method = RequestMethod.POST)
	public String insertJumunpageForm(Jumunpage_DTO jDto) {
		log.info("insertJumunpage 구매페이지 폼 등록");
		String sangcode = jDto.getSangcode();
		int n = service.selectJaegoCnt(sangcode);
		boolean isc = service.insertJumunpage(jDto);
		return isc ? "redirect:/jumunpageDeepOne.do?sangpgnum=" + jDto.getSangpgnum() : "insertJumunpage";
	}

	// 상품 상세 조회
	@RequestMapping(value = "/jumunpageDeepOne.do", method = RequestMethod.GET)
	public String jumunpageDeepOne(Model model, String sangpgnum) {
		log.info("jumunpageDeepOne 상품 구매 페이지");
		String mileage = "1000"; // 나중에 session에서 회원 mileage가져오는거 수정해욥
		Jumunpage_DTO dto = service.jumunpageDeepOne(sangpgnum);
		System.out.println(sangpgnum);
		System.out.println(dto);
		int n = service.selectJaegoCnt(dto.getSangcode());
		model.addAttribute("dto", dto);
		model.addAttribute("n", n);
		model.addAttribute("mileage", mileage);
		return "jumunpageDeepOne";
	}

	// 카테고리 별 상품 목록 조회
	@RequestMapping(value = "/jumunpageListScroll.do", method = RequestMethod.GET)
	public String jumunpageListScroll(Model model, String sangcode) {
		log.info("jumunpageListScroll 카테고리 별 상품 목록 조회");
		System.out.println(sangcode);
		List<Jumunpage_DTO> lists = service.jumunpageListScroll(sangcode);
		System.out.println(lists);
		model.addAttribute("lists", lists);
		return "jumunpageListScroll";
	}

	// 상품 목록 페이지용 이미지(썸네일) 등록
	@RequestMapping(value = "/insertProductimg.do", method = RequestMethod.GET)
	public String insertProductimg() {
		log.info("insertProductimg 목록 용 이미지 등록");
		return "insertProductimg";
	}

	// 상품 목록 페이지용 이미지(썸네일)
	@RequestMapping(value = "/insertProductImg.do", method = RequestMethod.POST)
	public void insertProductImg(HttpServletRequest req, HttpServletResponse resp, @RequestParam MultipartFile upload)
			throws IOException {
		log.info("insertProductImg 이미지 업로드");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		OutputStream out = null;// 파일의 데이터를 저장할 경로에 바이트 형태로 보내주는 스트림
		PrintWriter printWriter = null;// 출력을 지원해주는 스트림
		JsonObject json = new JsonObject();// json으로 사용하기 위해.
		String filename = upload.getOriginalFilename();// 화면에서 등록한 파일을 담은 파라미터
		FileUpload fu = new FileUpload();

		try {
			byte[] bytes = upload.getBytes();// byte를 사용하기 때문
			// 상대경로(was에 저장되는 경로
			String attachPath = "C:\\eclipse_fresh\\eclipse-jee-2019-09-R-win32-x86_64\\eclipse\\workspace_fresh\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Project_Fresh\\image\\";
			// 파일이 업로드 되는 경로(상대
			String uploadPath = attachPath.replace("/", "\\") + filename;
			String realPath = "C:\\Users\\user\\git\\FreshProject\\Project_Fresh\\src\\main\\webapp\\image/";

			System.out.println(filename);

			out = new FileOutputStream(new File(uploadPath));
			out.write(bytes);
			fu.fileCopy(attachPath + "\\" + filename, realPath + "\\" + filename);

			System.out.println(out);

			printWriter = resp.getWriter();
			String fileUrl = "http://localhost:8099/Project_Fresh/image/" + filename;
			System.out.println(fileUrl);

			json.addProperty("uploaded", 1);
			json.addProperty("fileName", filename);
			json.addProperty("url", fileUrl);

			printWriter.println(json);
			req.setAttribute("fileUrl", fileUrl);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
			if (printWriter != null) {
				printWriter.close();
			}
		}

	}

	// 상품 구매페이지 등록
	@RequestMapping(value = "/insertProductImgForm.do", method = RequestMethod.POST)
	public String insertProductImgForm(ProductImg_DTO pDto) {
		log.info("insertProductImgForm 이미지 등록");
		boolean isc = service.insertProductimg(pDto);
		return isc ? "redirect:/jumunpageDeepOne.do?sangpgnum=" + pDto.getSangpgnum() : "insertProductimg";
	}

	@RequestMapping(value = "/selectJaegoCnt.do", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String jaegocnt(String sangcode, String jumcnt) {
		String cnt = "";
		System.out.println("안녕 나는 상품코드야" + sangcode);
		cnt = String.valueOf(service.selectJaegoCnt(sangcode));
		System.out.println("상품개수" + cnt);
		return cnt;
	}

	@RequestMapping(value = "/memberJumunList.do", method = RequestMethod.GET)
	public String memberJumunList(HttpSession session,Model model) {
		log.info("memberJumunList 주문 리스트");
		Member_DTO mDto = (Member_DTO) session.getAttribute("mem");
		List<Jumun_DTO> lists = null;
		RowNum_DTO rDto = null;
		if (session.getAttribute("rDto")==null) {
			rDto = new RowNum_DTO();
			System.out.println("처음 받은 페이징 디티오 : "+rDto); 
		}
		else{
			rDto = (RowNum_DTO) session.getAttribute("rDto");
			System.out.println("다시 받은 페이징 디티오 : "+rDto); 
		}
		
		int count = rDto.getCount();
		System.out.println("페이지 갯수" + count);
		System.out.println(rDto);
		if (mDto.getGcode().equalsIgnoreCase("A")) {
			rDto.setTotal(jservice.countAllJumun());
			lists = jservice.allJumunList(rDto);
		}else {			
			rDto.setTotal(jservice.countMemberJumun(mDto.getId()));
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", mDto.getId());
			map.put("first", rDto.getFirst());
			map.put("last", rDto.getLast());
			lists = pservice.memberJumunList(map);
		}
		System.out.println("리스트  => "+lists);
		model.addAttribute("lists", lists);
		model.addAttribute("rDto", rDto);
		return "memberJumunList";
	}
	
	@RequestMapping(value = "/memberJumunListpaging.do",method = RequestMethod.POST,
			produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String memberJumunListpaging(Model model,HttpSession session,RowNum_DTO rDto) {
		log.info("주문내역 페이징");
		JsonObject json = new JsonObject();
		Member_DTO mDto = (Member_DTO) session.getAttribute("mem");
		System.out.println("mDto : "+mDto+"// rDto : "+rDto);
		Map<String, Object> map = new HashMap<String, Object>();
		if (mDto.getGcode().equalsIgnoreCase("A")) {
			rDto.setTotal(jservice.countAllJumun());
			json = makeJson(jservice.allJumunList(rDto), rDto, mDto);
		}else {
			rDto.setTotal(jservice.countMemberJumun(mDto.getId()));
			map.put("id", mDto.getId());
			map.put("first", rDto.getFirst());
			map.put("last", rDto.getLast());
			List<Jumun_DTO> mList = jservice.memberJumunList(map);
			json = makeJson(mList, rDto, mDto);
		}
		model.addAttribute("rDto", rDto);
		
		return json.toString();
	}
	
	@RequestMapping(value = "/memberPage.do", method = RequestMethod.GET)
	public String memberPage(String id,Model model) {
		log.info("memberPage");
		System.out.println("아이디"+id);
		Member_DTO dto=service.gradeList(id);
		System.out.println(dto);
		model.addAttribute("dto", dto);
		return "memberPage";
	}

	@SuppressWarnings("unused")
	private JsonObject makeJson(List<Jumun_DTO> lists,RowNum_DTO rDto,Member_DTO mDto) {
		JsonObject json = new JsonObject(); // {}
		JsonArray jlist = new JsonArray(); // []
		JsonObject jdto = null; // [{},{}]
		
		for (Jumun_DTO dto : lists) { // [{dto들},{dto들}] // {"lists":"[{dto들},{dto들}]"}
			jdto = new JsonObject();
			jdto.addProperty("jumunnum", dto.getJumunnum());
			jdto.addProperty("id", dto.getId());
			jdto.addProperty("sangpgnum", dto.getSangpgnum());
			jdto.addProperty("bsgcode", dto.getBsgcode());
			jdto.addProperty("jummoney", dto.getJummoney());
			jdto.addProperty("jumcnt", dto.getJumcnt());
			jdto.addProperty("jumstat", dto.getJumstat());
			jdto.addProperty("jumdate", String.valueOf(dto.getJumdate()));
			jdto.addProperty("id", mDto.getId());
			jlist.add(jdto);
		}
		
		jdto = new JsonObject();
		jdto.addProperty("pageList", rDto.getPageList());
		jdto.addProperty("index", rDto.getIndex());
		jdto.addProperty("pageNum", rDto.getPageNum());
		jdto.addProperty("listNum", rDto.getListNum());
		jdto.addProperty("total", rDto.getTotal());
		jdto.addProperty("count", rDto.getCount());
		
		json.add("lists", jlist);
		json.add("rDto", jdto);
		
		System.out.println(json.toString());
		return json;
	}
	
} 
