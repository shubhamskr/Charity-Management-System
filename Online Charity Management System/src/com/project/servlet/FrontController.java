package com.project.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.BookingDao;
import com.project.dao.DaoFactory;
import com.project.dao.LoginDao;
import com.project.dao.PaymentDao;
import com.project.entity.BookingDetails;
import com.project.entity.PaymentDetails;
import com.project.entity.User;
import com.project.exception.DaoException;


/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String ADD_USER_ACCOUNT = "addUser.action";

	private static final String LOGIN_FORM = "login.action";

	private static final String LOGIN_ADMIN_FORM = "loginAdmin.action";

	private static final String ADD_BOOKING = "addBooking.action";

	private static final String ADD_PAYMENT = "addPayment.action";

	private static final String SHOW_REGISTERATION = "showRegistration.action";

	private static final String SHOW_ADMIN_FORM = "showAdmin.action";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			try {
				doProcess(request, response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			try {
				doProcess(request, response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws DaoException
	 * @throws ParseException
	 */
	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, DaoException, ParseException {
		String target = "";
		String uri = request.getRequestURI();
		if (uri != null) {
			target = "login.jsp";
			if (uri.endsWith(ADD_USER_ACCOUNT)) {
				try {
					LoginDao loginDao = DaoFactory.getLoginDao();
					User user = populateUserDetails(request);
					user.setAdmin("No");
					loginDao.registerUser(user);
					request.setAttribute("message", "User " + user.getEmail() + " registered successfully");
					target = "WEB-INF/pages/AfterRegistration.jsp";
				} catch (DaoException e) {
					request.setAttribute("errorMessage", e.getMessage());
					target = "WEB-INF/pages/RegistrationError.jsp";

				}
			} else if (uri.endsWith(LOGIN_FORM)) {
				boolean isLogin = false;
				try {
					LoginDao loginDao = DaoFactory.getLoginDao();
					User user = populateUserDetails(request);
					user.setAdmin("No");
					isLogin = loginDao.checkValidUser(user);
					if (!isLogin) {
						request.setAttribute("message", "Invalid email or password");
						target = "WEB-INF/pages/InvalidLogin.jsp";
					} else {
						request.getSession().setAttribute("user", user.getEmail());
						target = "WEB-INF/pages/booking.jsp";
					}
				} catch (DaoException e) {
					request.setAttribute("errorMessage", e.getMessage());
					target = "login.jsp";
				}
			} else if (uri.endsWith(LOGIN_ADMIN_FORM)) {
				boolean isLogin = false;
				try {
					LoginDao loginDao = DaoFactory.getLoginDao();
					User user = populateUserDetails(request);
					user.setAdmin("Yes");
					isLogin = loginDao.checkValidUser(user);
					if (!isLogin) {
						request.setAttribute("message", "Invalid email or password");
						target = "WEB-INF/pages/admin.jsp";
					} else {
						request.getSession().setAttribute("user", user.getEmail());
						target = "WEB-INF/pages/AdminLogin.jsp";
					}
				} catch (DaoException e) {
					request.setAttribute("errorMessage", e.getMessage());
					target = "WEB-INF/pages/admin.jsp";
				}
			}
			else if (uri.endsWith(ADD_BOOKING)) {
				BookingDetails bookingDetails = populateBookingDetails(request);
				request.getSession().setAttribute("bookingDetails", bookingDetails);
				target = "WEB-INF/pages/Payment.jsp";
			}

			else if (uri.endsWith(ADD_PAYMENT)) {
				try {
					PaymentDetails paymentDetails = populatePaymentDetails(request);
					PaymentDao paymentDao = DaoFactory.getPaymentDao();
					paymentDao.addPayment(paymentDetails);
					BookingDao bookingDao = DaoFactory.getBookingDao();
					BookingDetails bookingDetails = (BookingDetails) request.getSession()
							.getAttribute("bookingDetails");
					bookingDetails.setPAYMENTID(paymentDetails.getPAYMENTID());
					bookingDao.addBooking(bookingDetails);
					request.setAttribute("message", "Succesfully Booked");
					target = "WEB-INF/pages/AfterPayment.jsp";
				} catch (DaoException e) {
					request.setAttribute("errorMessage", e.getMessage());
					target = "WEB-INF/pages/Payment.jsp";
				}
			}

			else if (uri.endsWith(SHOW_REGISTERATION)) {
				target = "WEB-INF/pages/registration.jsp";

			} else if (uri.endsWith(SHOW_ADMIN_FORM)) {
				target = "WEB-INF/pages/admin.jsp";

			}

		}

		request.getRequestDispatcher(target).forward(request, response);

	}

	/**
	 * 
	 * @param request
	 * @return Booking
	 * @throws ParseException
	 */

	private BookingDetails populateBookingDetails(HttpServletRequest request) throws ParseException {
		BookingDetails bookingDetails = new BookingDetails();
		String email = (String) request.getSession().getAttribute("user");
		bookingDetails.setEmail(email);
		bookingDetails.setBookingId(UUID.randomUUID().toString());
		bookingDetails.setCharity(request.getParameter("charity"));
		bookingDetails.setBookedDate(request.getParameter("bookedDate"));
		bookingDetails.setAMOUNT(request.getParameter("Amount"));
		bookingDetails.setFULLNAME(request.getParameter("fullName"));
		return bookingDetails;
	}

	private PaymentDetails populatePaymentDetails(HttpServletRequest request) throws ParseException {
		PaymentDetails paymentDetails = new PaymentDetails();
		paymentDetails.setPAYMENTID(UUID.randomUUID().toString());
		paymentDetails.setNAME(request.getParameter("name"));
		paymentDetails.setNUMBER(request.getParameter("number"));
		paymentDetails.setMONTH(request.getParameter("month"));
		paymentDetails.setYEAR(request.getParameter("year"));
		paymentDetails.setCVV(request.getParameter("cvv"));
		return paymentDetails;

	}

	/**
	 * 
	 * @param request
	 * @return User
	 */

	private User populateUserDetails(HttpServletRequest request) {
		User user = new User();
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setGender(request.getParameter("gender"));
		
		return user;
	}
}
