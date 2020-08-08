/*
"""
    @author - Waruna Nissanka
    @email - warunanissanka44@gmail.com
    @project - Job Allowcation API Service

    @Description - Security Constants
"""
*/

package org.assignment.empmanage.security;

public class SecurityConstant {
    public static final String SECRET = "secre";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final Long EXPIRATION_TIME = 864_000_000L;
    public static final String SIGN_UP_URL = "/users/sign-up";
}
