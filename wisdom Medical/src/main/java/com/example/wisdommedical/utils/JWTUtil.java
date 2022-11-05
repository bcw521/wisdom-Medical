package com.example.wisdommedical.utils;

import com.example.wisdommedical.common.Result;
import com.example.wisdommedical.controller.dto.ResponseDto;
import io.jsonwebtoken.*;

import java.util.Date;
import java.util.UUID;

public class JWTUtil {
    private static long time= 1000*60*60*60*24;
    private static String signature="ying5201314";
    public static String createToken(String account){
        JwtBuilder jwtBuilder = Jwts.builder();
        String token=jwtBuilder.setId(UUID.randomUUID().toString())
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
                .claim("account",account)
                .setExpiration(new Date(System.currentTimeMillis()+time))
                .signWith(SignatureAlgorithm.HS256,signature)
                .compact();
        return token;
    }
    public static Result verifyToken(String token){
        if (token==null){
            return new Result(false,null,"token不存在",null);
        }else {
            try {
                JwtParser jwtParser = Jwts.parser();
                Jws<Claims> claimsJws = jwtParser.setSigningKey(signature).parseClaimsJws(token);
                Claims body = claimsJws.getBody();
                System.out.println(body.get("account"));
                return new Result(true, ResponseDto.SUCCESS,null,null);
            }catch (ExpiredJwtException e) {
                // 登录过期
                return new Result(false, ResponseDto.ERROR_REQUEST,"登录过期", null);
            } catch (UnsupportedJwtException e) {
                return new Result(false, ResponseDto.ERROR_UNAUTHORIZED,"token不合法", null);
            } catch (MalformedJwtException e) {
                return new Result(false,ResponseDto.ERROR_FORBID, "token格式错误", null);
            } catch (SignatureException e) {
                return new Result(false, ResponseDto.ERROR_UNAUTHORIZED,"token签名错误", null);
            }
        }
    }
}
