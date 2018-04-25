package edu.buffalo.bmi;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.spec.InvalidParameterSpecException;
import java.sql.SQLException;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import javax.servlet.RequestDispatcher;

public class UserLoginModule implements LoginModule {

	private CallbackHandler callbackHander = null;
	private boolean authenticationSuccessFlag = false;

	@Override
	public boolean abort() throws LoginException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean commit() throws LoginException {
		return authenticationSuccessFlag;
	}

	@Override
	public void initialize(Subject subject, CallbackHandler callbackHander,
			Map<String, ?> sharedState, Map<String, ?> options) {
		this.callbackHander = callbackHander;

	}

	@Override
	public boolean login() throws LoginException {
		Callback[] callbackArray = new Callback[2];
		callbackArray[0] = new NameCallback("User Name:");
		callbackArray[1] = new PasswordCallback("Password:", false);
		try {
			callbackHander.handle(callbackArray);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (UnsupportedCallbackException e) {
			System.out.println(e.getMessage());
		}
		String name = ((NameCallback) callbackArray[0]).getName();
		String password = new String(
				((PasswordCallback) callbackArray[1]).getPassword());
		try {
			int role = DbManager.getRole(name);
			if (role == 1 || role == 2) {
				System.out.println("authentication success");
				authenticationSuccessFlag = true;
				LoginBean loginBean = new LoginBean();
				loginBean.setUsername(name);
				loginBean.setPassword(password);

				try {
					int checkUser = DbManager.checkUser(loginBean);
					if (checkUser == 1) {
						System.out.println("inside checkuser");
						System.out.println("authentication success for user");
						authenticationSuccessFlag = true;
					} else {
						System.out.println("inside else of checkuser");
						authenticationSuccessFlag = false;
					}

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalBlockSizeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BadPaddingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidParameterSpecException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return authenticationSuccessFlag;
	}

	@Override
	public boolean logout() throws LoginException {
		// TODO Auto-generated method stub
		return false;
	}

}
