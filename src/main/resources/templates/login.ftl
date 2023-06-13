<#import "macros/common.ftl" as c>
<#include "macros/security.ftl">

<@c.page>
    <style>
        body {
            background: rgb(195,205,219);
            background: linear-gradient(90deg, rgba(195,205,219,1) 0%, rgba(179,198,207,1) 100%);
            font-family: "Montserrat", "Arial", sans-serif !important;
        }

        .login-box {
            margin-top: 10px;
            height: auto;
            border-radius: 8px;
            background: #eeeeee;
            text-align: center;
            box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);
        }

        .login-key {
            height: 100px;
            font-size: 80px;
            background: -webkit-linear-gradient(#ff4800, #e24400);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
        }

        .login-title {
            margin-top: 15px;
            text-align: center;
            font-size: 30px;
            letter-spacing: 2px;
            font-weight: bold;
            color: #000000;
        }

        .login-form {
            margin-top: 25px;
            text-align: left;
        }

        input[type=text] {
            background-color: #eeeeee;
            border: none;
            border-bottom: 2px solid #000000;
            border-top: 0px;
            border-radius: 0px;
            font-weight: bold;
            outline: 0;
            margin-bottom: 20px;
            padding-left: 0px;
            /*color: #eeeeee;*/
        }

        input[type=password] {
            background-color: #eeeeee;
            border: none;
            border-bottom: 2px solid #000000;
            border-top: 0px;
            border-radius: 0px;
            font-weight: bold;
            outline: 0;
            padding-left: 0px;
            margin-bottom: 20px;
            /*color: #eeeeee;*/
        }

        .form-group {
            margin-bottom: 40px;
            outline: 0px;
        }

        .form-control:focus {
            border-color: inherit;
            -webkit-box-shadow: none;
            box-shadow: none;
            border-bottom: 2px solid #ff4800;
            outline: 0;
            background-color: #eeeeee;
            color: #000000;
        }

        input:focus {
            outline: none;
            box-shadow: 0 0 0;
        }

        label {
            margin-bottom: 0px;
        }

        .form-control-label {
            font-size: 10px;
            color: #000000;
            font-weight: bold;
            letter-spacing: 1px;
        }

        .btn-outline-primary {
            border-color: #000000;
            color: #000000;
            border-radius: 8px;
            font-weight: bold;
            letter-spacing: 2px;
            box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
        }

        .btn-outline-primary:hover {
            background-color: #000000;
        }

        .login-button {
            padding-left: 158px;
            text-align: center;
            margin-bottom: 25px;
        }

        .login-text {
            text-align: left;
            padding-left: 0px;
            color: #A2A4A4;
        }
    </style>
    <form action="/login" method="post">
        <div class="container py-5 h-100">
            <div class="card-body p-5 shadow-5 text-center">
                <div class="row g-0">
                    <div class="col-lg-3 col-md-2"></div>
                    <div class="col-lg-6 col-md-8 login-box">
                        <div class="col-lg-12 login-key">
                            <i class="fa fa-crop" aria-hidden="true"></i>
                        </div>
                        <div class="col-lg-12 login-title">
                            CON-CALC
                        </div>

                        <div class="col-lg-12 login-form">
                            <div class="col-lg-12 login-form">
                                <form>
                                    <div class="form-group">
                                        <label class="form-control-label">ЛОГИН</label>
                                        <input type="text" name="username"
                                               class="form-control ${(usernameError??)?string('is-invalid', '')}"/>
                                    </div>
                                    <div class="form-group">
                                        <label class="form-control-label">ПАРОЛЬ</label>
                                        <input type="password" name="password"
                                               class="form-control ${(passwordError??)?string('is-invalid', '')}"/>
                                    </div>

                                    <div class="form-group login-btm login-text">
                                        <#if Session?? && Session.SPRING_SECURITY_LAST_EXCEPTION??>
                                            <div class="alert alert-danger d-flex align-items-center" role="alert">
                                                <div>
                                                    Неверный логин или пароль
                                                </div>
                                            </div>
                                        </#if>
                                        <#if message??>
                                            <div class="alert alert-${messageType}" role="alert">
                                                Некорректные данные
                                            </div>
                                        </#if>
                                    </div>

                                    <div class="col-lg-12 loginbttm">
                                        <div class="col-lg-6 login-btm login-button">
                                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                            <button type="submit" class="btn btn-outline-primary">ВОЙТИ</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-2"></div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</@c.page>