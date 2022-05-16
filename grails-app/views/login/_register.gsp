<div style="text-align: center">
    <div class="fieldcontain">
        <label>
            FirstName*
        </label>
        <g:textField name="firstName" value="${firstName}"/>
    </div>
    <div class="fieldcontain">
        <label>
            LastName*
        </label>
        <g:textField name="lastName" value="${lastName}"/>
    </div>
    <div class="fieldcontain">
        <label>
            Email
        </label>
        <g:textField name="email" value="${email}"/>
    </div>
    <div class="fieldcontain">
        <label>
            userName
        </label>
        <g:textField name="userName" value="${userName}"/>
    </div>
<div class="fieldcontain">
    <label for="password">
        Password*
    </label>
    <g:passwordField name="password" value="${password}"/>
</div>
    <div class="fieldcontain">
        <label for="password">
            Password*
        </label>
        <g:passwordField name="password" value="${password}"/>
    </div>
<div>
    <div class="fieldcontain">
        <label>
            Photo Upload
        </label>
        <g:textField name="photo" value="${photo}"/>
        <g:uploadForm name="myUpload">
            <input type="file" name="myFile" />
        </g:uploadForm>
    </div>
</div>
    <div>
        <g:submitButton name="SignUp" value="Submit"/>
    </div>
</div>