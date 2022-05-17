<div style="text-align: center">
<div class="fieldcontain">
    <label for="userName">
        Email/UserName*
    </label>
    <g:textField name="userName" value="${userName}"/>
</div><br>
<div class="fieldcontain">
    <label for="password">
        Password*
    </label>
    <g:passwordField name="password" value="${password}"/>
</div>
<div>
    <g:submitButton name="Login" value="Submit"/>
    <g:actionSubmit value="Update"/>
    <g:actionSubmit value="Update" action="reg"/>
</div>
</div>
<div>
    <g:checkBox name="myCheckbox" value="${false}" />
    <label>MALE</label>
</div>
<div>
    <g:checkBox name="myCheckbox" value="${false}" />
    <label>FEMALE</label>
</div>
<div>
    <g:radio name="myGroup" value="1"/>
    <label>MALE</label>
    <g:radio name="myGroup" value="2" checked="true"/>
    <label>FEMALE</label>
</div>
<div>
    <g:select name="user.age" from="${18..65}" value="${age}"
              noSelection="['':'-Choose your age-']"/>
</div>
<div>
    <g:link url="[controllerName: 'login', actionName: 'reg']">Registration</g:link>
</div>
<div>
    <g:createLink url="[actionName: 'log']">Hello</g:createLink>
</div>
<div>
    <g:if test="session.user != null">
        Hello mark
    </g:if>
    <g:if test="session.user == null">
        Hello DAn
    </g:if>
%{--    <g:unless test="${name == 'fred'}">
        Hello ${name}!
    </g:unless>--}%
</div>
<div>
    <g:each in="${[1,2,3]}" var="num">
        <li>Number ${num}</li>
    </g:each>
</div>
<div>
    <g:set var="num" value="${1}" />
    <g:while test="${num < 5 }">
        <li>Number ${num++}</li>
    </g:while>
</div>
<div>
    %{--<g:dateFormat format="dd-MM-yyyy-HH" date="${new Date()}"/>--}%
    %{--<g:simple happy="true">Hello Kashif</g:simple>--}%
    %{--<g:check number="11">Even Number</g:check>--}%
%{--    <g:print number1="10" number2="20">
        <li>${it}</li>
    </g:print>--}%
    <my:example hello="false">THIS IS AWESOME TAG</my:example>
</div>