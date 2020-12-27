/**   
 * @公司   青软实训QST
 * @作者 zhaokl
 */
package com.hs_vae.Experiment.Demo2.Demo2.entity;

import java.io.Serializable;
import java.util.Date;

//匹配日志记录，"登录登出对" 类型

public class MatchedLogRec implements  Serializable{

	private LogRec login;
	private LogRec logout;

	// user用户登录名
	public String getUser() {
		return login.getUser();
	}

	// 登入时刻
	public Date getLogInTime() {
		return login.getTime();
	}

	// 登出时刻
	public Date getLogoutTime() {
		return logout.getTime();
	}

	// 登入记录
	public LogRec getLogin() {
		return login;
	}

	// 登出记录
	public LogRec getLogout() {
		return logout;
	}

	public MatchedLogRec() {
	}

	public MatchedLogRec(LogRec login, LogRec logout) {
		if (login.getLogType() != LogRec.LOG_IN) {
			throw new RuntimeException("不是登录记录!");
		}
		if (logout.getLogType() != LogRec.LOG_OUT) {
			throw new RuntimeException("不是登出记录");
		}
		if (!login.getUser().equals(logout.getUser())) {
			throw new RuntimeException("登录登出必须是同一个用户!");
		}
		if (!login.getIp().equals(logout.getIp())) {
			throw new RuntimeException("登录登出必须是同一个IP地址!");
		}
		this.login = login;
		this.logout = logout;
	}
	public String toString() {
		return login.toString() + " | " + logout.toString();
	}
}
