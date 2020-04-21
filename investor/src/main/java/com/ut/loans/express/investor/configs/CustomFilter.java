package com.ut.loans.express.investor.configs;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class CustomFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String path = ((HttpServletRequest) request).getRequestURI();
        if ("OPTIONS".equalsIgnoreCase(((HttpServletRequest) request).getMethod())) {
            System.out.println("Code is here");
            httpResponse.setHeader("Access-Control-Allow-Origin", httpRequest.getHeader("Origin"));
            httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
            httpResponse.setHeader("Access-Control-Allow-Headers","Content-Type, Accept, X-Requested-With, remember-me,Authorization");  
            httpResponse.setStatus(HttpServletResponse.SC_OK);
        } 
        //else if(path.endsWith("/login")||path.endsWith("/test")||path.endsWith("/insertApprovedLoanRecord")||path.endsWith("/getAvailableLoans")){
          else{
            httpResponse.setHeader("Access-Control-Allow-Origin", httpRequest.getHeader("Origin"));
            httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
            httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
            httpResponse.setHeader("Access-Control-Max-Age", "3600");
            httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");
            chain.doFilter(request, response);

        }
        // else {
        //     System.out.println(httpRequest.getHeader("Origin"));
        //     httpResponse.setHeader("Access-Control-Allow-Origin", httpRequest.getHeader("Origin"));
        //     httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        //     httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        //     httpResponse.setHeader("Access-Control-Max-Age", "3600");
        //     httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");
            
        //     try {
        //         if (httpRequest.getHeader("Authorization").equals(null)) {
        //             throw new Exception();
        //         }
        //         final String baseUrl = "http://localhost:9015/esign/authentication";
        //         RestTemplate restTemplate = new RestTemplate();
        //         String token = httpRequest.getHeader("Authorization");
        //         ResponseEntity<String> responseEntity = restTemplate.postForEntity(baseUrl, token, String.class);

        //                 if(responseEntity.getBody().equals("Failed")){throw new Exception();};
        //                 httpRequest.setAttribute("payload", responseEntity.getBody());
        //             }
        //             catch(Exception e){
        //                 httpResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        //                 httpResponse.getWriter().write("Authentication Failed");
        //                 httpResponse.flushBuffer();
        //                 return;
        //             }

        //                 chain.doFilter(request, response);
        //         }
                // chain.doFilter(request, response);

    }
        
    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }
}
