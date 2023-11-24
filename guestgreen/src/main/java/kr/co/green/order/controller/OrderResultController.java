package kr.co.green.order.controller;







//@WebServlet("/orderResult.do")
//public class OrderResultController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    public OrderResultController() {
//        super();
//    }
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		StringBuffer jb = new StringBuffer();
//		String line = null;
//		try {
//		   BufferedReader reader = request.getReader();
//		   while ((line = reader.readLine()) != null) {
//			   jb.append(line);
//		      }
//		} catch (Exception e) {
//			System.out.println("결제정보를 불러오는데 실패했습니다");
//			e.printStackTrace();
//			}
//		            
//		JsonParser parser = new JsonParser();
//		JsonElement element = parser.parse(jb.toString());
//		String imp_uid = element.getAsJsonObject().get("imp_uid").getAsString();
//		String merchant_uid = element.getAsJsonObject().get("merchant_uid").getAsString();
//		System.out.println(imp_uid);
//		System.out.println(merchant_uid);
//	}
//
//}
