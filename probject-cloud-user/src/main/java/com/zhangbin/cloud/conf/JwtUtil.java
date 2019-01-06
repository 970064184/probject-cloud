package com.zhangbin.cloud.conf;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

/**登录Token的生成和解析
 * @author admin
 *
 */
public class JwtUtil {
	
	/** token 秘钥，请勿泄露，请勿随便修改*/
	public static final String SECRET = "52DTHVwS8YYP7ay0";
	
	/** token 过期时间：30秒*/
	public static final int calendarField = Calendar.HOUR;
	public static final int calendarInterval = 1;
	
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
			throw new RuntimeException("登录凭证已过期，请重新登录");
		}
		return jwt.getClaims();
	}
	
	/**
	 * 根据Token获取userId
	 * @param token
	 * @return
	 */
	public static Long getAppUID(String token) {
		Map<String, Claim> claims = verifyToken(token);
		Claim userIdClaim = claims.get("userId");
		if(null == userIdClaim || StringUtils.isEmpty(userIdClaim.asString())) {
			//token校验失败，抛出Token验证非法异常
			System.out.println("token校验失败");
		}
		return Long.valueOf(userIdClaim.asString());
	}
	
	public static void main(String[] args) throws Exception {
		//获取token
		/*Long userId = 1111L;
		String createToken = createToken(userId);
		System.out.println("获取token:"+createToken);*/
		//解析token
		String token1 = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJBUFAiLCJpc3MiOiJTZXJ2aWNlIiwiZXhwIjoxNTQ2NzY0MDE3LCJ1c2VySWQiOiIxIiwiaWF0IjoxNTQ2NzYwNDE3fQ.0YCTRX1tE_7h4YseKAgqlttrbA8w2iPt3ooZ6V95n_8";
		Map<String, Claim> verifyToken1 = verifyToken(token1);
		System.out.println("解析token:"+verifyToken1);
		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJBUFAiLCJpc3MiOiJTZXJ2aWNlIiwiZXhwIjoxNTQ2NTA1NzEyLCJ1c2VySWQiOiIxMTExIiwiaWF0IjoxNTQ2NTA1NjgyfQ.NVSo4OkUm2K8q8XuoljLVxuuOzymTMDiurzGfVuoL9o";
		Map<String, Claim> verifyToken = verifyToken(token);
		System.out.println("解析token:"+verifyToken);
		//根据token获取userId
		Long appUID = getAppUID(token);
		System.out.println("根据token获取userId:"+appUID);
		/**
		 * 	获取token:eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJBUFAiLCJpc3MiOiJTZXJ2aWNlIiwiZXhwIjoxNTQ3MzY5MDAxLCJ1c2VySWQiOiIxMTExIiwiaWF0IjoxNTQ2NTA1MDAxfQ.DWye2Yhdbi5ufeK6Z9ukxcghWiQF6k2uJA9YlcGDLo8
			解析token:{aud=com.auth0.jwt.impl.JsonNodeClaim@70ed52de, iss=com.auth0.jwt.impl.JsonNodeClaim@496bc455, exp=com.auth0.jwt.impl.JsonNodeClaim@59402b8f, userId=com.auth0.jwt.impl.JsonNodeClaim@7188af83, iat=com.auth0.jwt.impl.JsonNodeClaim@6be968ce}
			根据token获取userId:1111
			
			获取token:eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJBUFAiLCJpc3MiOiJTZXJ2aWNlIiwiZXhwIjoxNTQ3MzY5MDM3LCJ1c2VySWQiOiIxMTEyIiwiaWF0IjoxNTQ2NTA1MDM3fQ.NBxyu0j7HiaBrm10nQLKz5cVFGpYo2mJORlFHIZLoKM
			解析token:{aud=com.auth0.jwt.impl.JsonNodeClaim@5ddeb7cb, iss=com.auth0.jwt.impl.JsonNodeClaim@70ed52de, exp=com.auth0.jwt.impl.JsonNodeClaim@496bc455, userId=com.auth0.jwt.impl.JsonNodeClaim@59402b8f, iat=com.auth0.jwt.impl.JsonNodeClaim@7188af83}
			根据token获取userId:1112
		 */
	}
}
