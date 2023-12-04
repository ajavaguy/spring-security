# spring-security
- When adding spring-security library, it will generate login form for us.
- By default, spring will send form-base authentication, that means spring security will send user and password via a form -> this lead to leak user's information in payload.
- Need to change to httpBasic auth.
- With basic auth you can't log out.

- Authorities are set of roles and permissions.

- CSRF is a merchanism for prevent perpetrator forging a imitation or a copy of a document, signature,...
- Recommending to use CSRF protection for any request that could be processed by a browser by normal users. 
	But for services that is used by non-browser clients, you will likely want to disable CSRF protection.