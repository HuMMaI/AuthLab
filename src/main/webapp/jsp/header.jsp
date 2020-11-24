<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="d-flex justify-content-between w-100">
        <div class="d-flex flex-row">
            <a class="navbar-brand" href="/">Lab 1</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <security:authorize access="hasAuthority('USER')">
                        <li class="nav-item">
                            <a class="nav-link" href="/notes">Notes</a>
                        </li>
                    </security:authorize>
                    <security:authorize access="hasAuthority('ADMIN')">
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/api">User list</a>
                        </li>
                    </security:authorize>
                </ul>
            </div>
        </div>
        <div class="d-flex flex-row w-25 justify-content-end">
            <security:authorize access="isAnonymous()">
                <a href="/login" class="btn btn-outline-warning">Sign in</a>
                <a href="/registration" class="btn btn-outline-success">Sign up</a>
            </security:authorize>
            <security:authorize access="isAuthenticated()">
                <form action="/logout" method="post">
                    <button type="submit" class="btn btn-outline-primary">Logout</button>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </security:authorize>
        </div>
    </div>
</nav>
