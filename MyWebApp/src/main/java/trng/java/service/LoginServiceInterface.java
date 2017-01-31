package trng.java.service;

import trng.java.bean.LoginRequest;

public interface LoginServiceInterface {
	public boolean verifyLogin(LoginRequest request);
}
