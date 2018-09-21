package com.winxuan.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author leitao.
 * @category
 * @time: 2018/9/18 0018-10:11
 * @version: 1.0
 * @description:
 **/
@Component
public class IPFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return -1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println("=============IP Filter================"+request.getRemoteHost());
        System.out.println(parameterMap.toString());
        return null;
    }
}
