package com.noirix.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "CharsetFilter")
public class CharsetFilter implements Filter {

    public static final String IN_CHARSET_FILTER = "In charset filter!";
    public static final String UTF_8 = "utf-8";

    @Override
    public void init(FilterConfig filterConfig){

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        System.out.println(IN_CHARSET_FILTER);
        request.setCharacterEncoding(UTF_8);
        response.setCharacterEncoding(UTF_8);

        chain.doFilter(request, response);

    }

}
