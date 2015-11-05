<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>

<@security.authorize access="!isAnonymous()">
    <@security.authentication property="principal.username" var="username"/>
</@security.authorize>

<header>
    <div class="col-lg-3 col-lg-offset-9 userside">
    <#if username?? && principal??>
        <a href="/profile"><p>${username}</a><a href="/profile/all_users">Friends</a> <a href="/logout">Log out</a> </p>
    <#else>
        <p><a href="/registration">Sign up </a> or <a href="/login"> Sign in</a></p>
    </#if>
    </div>
</header>