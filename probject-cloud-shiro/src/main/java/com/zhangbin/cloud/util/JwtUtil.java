package com.zhangbin.cloud.util;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.springframework.util.StringUtils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

/**登录Token的生成和解析
 * @author zb
 *
 */
public class JwtUtil {
	
	/** token 秘钥，请勿泄露，请勿随便修改*/
	public static final String SECRET = "52DTHVwS8YYP7ay0";
	
	/** token 过期时间：30分钟*/
	public static final int calendarField = Calendar.MINUTE;
	public static final int calendarInterval = 60;
	
	/**
	 * JWT生成Token
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public static String createToken(Long userId) throws Exception {
		Date iatDate = new Date();
		Calendar nowTime  = Calendar.getInstance();
		nowTime.add(calendarField, calendarInterval);
		Date expiresDate = nowTime.getTime();
		/**
		 * JWT三部分：
		 * 头部 header
		 * 载荷 payload
		 * 签名signature
		 */
		//header Map
		Map<String, Object> map = new HashMap<>();
		map.put("alg", "HS256");//签名算法，默认值是HS256
		map.put("typ", "JWT");
		
		//build token
		String token = JWT.create().withHeader(map)
			.withClaim("iss", "Service")//payload,发行者
			.withClaim("aud", "APP")//观众
			.withClaim("userId", null == userId? null:userId.toString())
			.withIssuedAt(iatDate)//sign time
			.withExpiresAt(expiresDate)//expire time
			.sign(Algorithm.HMAC256(SECRET));//signature
			
		return token;
	}
	
	/**
	 * 解密Token
	 * @param token
	 * @return
	 */
	public static Map<String, Claim> verifyToken(String token){
		DecodedJWT jwt = null;
		try {
			JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
			jwt = verifier.verify(token);
		} catch (Exception e) {
			e.printStackTrace();
//			throw new RuntimeException("登录凭证已过期，请重新登录");
			throw new ExpiredCredentialsException("登录凭证已过期，请重新登录");
		}
		return jwt.getClaims();
	}
	
	/**
	 * 根据Token获取userId，带解析token是否正确
	 * @param token
	 * @return
	 */
	public static Long getAppUID(String token) {
		Map<String, Claim> claims = verifyToken(token);
		Claim userIdClaim = claims.get("userId");
		if(null == userIdClaim || StringUtils.isEmpty(userIdClaim.asString())) {
			//token校验失败，抛出Token验证非法异常
			throw new UnsupportedTokenException("token校验失败");
		}
		return Long.valueOf(userIdClaim.asString());
	}
	/**
	 * 根据Token获取userId
	 * @param token
	 * @return
	 */
	public static Long getUserId(String token) {
		DecodedJWT jwt = JWT.decode(token);
		Claim userIdClaim = jwt.getClaim("userId");
		return Long.valueOf(userIdClaim.asString());
	}
	
}
