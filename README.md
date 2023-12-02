# spring-security
- When adding spring-security library, it will generate login form for us.
- By default, spring will send form-base authentication, that means spring security will send user and password via a form -> this lead to leak user's information in payload.
- Need to change to httpBasic auth.
- With basic auth you can't log out.