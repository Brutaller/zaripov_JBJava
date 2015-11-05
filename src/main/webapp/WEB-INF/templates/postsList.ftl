<#list posts as post>
<h2><p>${post.text}</p></h2>
    by ${post.user.username}
<p>Date: ${post.date}</p>
<p>Time: ${post.time}</p>
<hr>
</#list>

