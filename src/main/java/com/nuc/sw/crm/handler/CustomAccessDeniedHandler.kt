package com.nuc.sw.crm.handler;

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.access.AccessDeniedHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class CustomAccessDeniedHandler : AccessDeniedHandler {

    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    /**
     * Handles an access denied failure.
     *
     * @param request that resulted in an `AccessDeniedException`
     * @param response so that the user agent can be advised of the failure
     * @param accessDeniedException that caused the invocation
     *
     * @throws IOException in the event of an IOException
     * @throws ServletException in the event of a ServletException
     */
    override fun handle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        accessDeniedException: AccessDeniedException
    ) {

        val auth = SecurityContextHolder.getContext().authentication;
        if (auth != null) {
            logger.info(" ${auth.name} 登录  ${request.requestURI}")
        }
        response.sendRedirect(request.contextPath + "/403")
    }

}
