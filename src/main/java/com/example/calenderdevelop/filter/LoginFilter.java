package com.example.calenderdevelop.filter;

import com.example.calenderdevelop.common.Const;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;


@Slf4j
public class LoginFilter implements Filter {
    // 인증을 하지 않아도될 URL Path 배열
    private static final String[] WHITE_LIST = {"/","/api/users/signup","/api/users/login"};

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {


        // 다양한 기능을 위해 다운캐스팅
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String requestURI = httpServletRequest.getRequestURI();
        HttpServletResponse httpServletResponse =(HttpServletResponse) servletResponse;

        log.info("request URI={}",requestURI);

        // 로그인을 체크 해야하는 URL인지 검사
        // whiteListURL에 포함된 경우 true 반환 -> !true = false
        if (!isWhiteList(requestURI)){
            // 로그인 확인 -> 로그인하면 session에 값이 저장되어 있다는 가정.
            // 세션이 존재하면 가져온다. 세션이 없으면 session = null
            HttpSession session = httpServletRequest.getSession(false);

            // 로그인하지 않은 사용자인 경우
            if (session==null || session.getAttribute(Const.Login_User)==null){
                httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                httpServletResponse.setContentType("application/json");
                httpServletResponse.getWriter().write("{\"message\": \"로그인 해주세요\"}");
                return;
//                throw new RuntimeException("로그인 해주세요");
            }
            log.info("로그인에 성공했습니다.");
        }

        filterChain.doFilter(servletRequest,servletResponse);

    }

    // 로그인 여부를 확인하는 URL인지 체크하는 메서드
    private boolean isWhiteList(String requestURI){
        return PatternMatchUtils.simpleMatch(WHITE_LIST,requestURI);
    }



}
