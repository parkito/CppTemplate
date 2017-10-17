<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create a Flat Login/Sign up Page with Validator jQuery Plugin</title>
    <link href="css/style.css" media="screen" rel="stylesheet">
    <link href="css/reset.css" media="screen" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,600italic,700italic,800italic,400,300,600,800'
          rel='stylesheet' type='text/css'>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <div class="flat-design-form">
        <ul class="tabs">
            <li><a class="active" href="#login" id="login-tab"><span id="login_icon"></span> Login</a></li>
            <li><a href="#register" id="register-tab"><span id="signup_icon"></span> Register</a></li>
        </ul>

        <div class="form-display show" id="login">
            <h1>Login</h1>

            <form action="" name="signIn">
                <fieldset>
                    <ul>
                        <li>
                            <div class="item">
                                <input data-validate-length-range="6" id="email" placeholder="E-mail"
                                       required="required" type="text">
                            </div>
                        </li>

                        <li>
                            <div class="item">
                                <input data-validate-length-range="6" id="password" placeholder="Password" required=
                                        'required' type="password">
                            </div>
                        </li>

                        <li><input class="button-login" type="submit" value="Login"></li>
                    </ul>
                </fieldset>
            </form>
        </div>

        <div class="form-display hide" id="register">
            <h1>Register</h1>

            <form action="" method="post" novalidate="">
                <fieldset>
                    <ul>
                        <li>
                            <div class="item">
                                <input id="regEmail" placeholder="E-mail" required="required" type="email">
                            </div>
                        </li>

                        <li>
                            <div class="item">
                                <input id="regPassword" placeholder="Password" required='required' type="password">
                            </div>
                        </li>

                        <li>
                            <div class="item">
                                <input id="regRepeatedPassword" placeholder="Password" required='required'
                                       type="password">
                            </div>
                        </li>

                        <li>
                            <div class="item">
                                <input class='firstName' id="firstName" placeholder="First name" required="required"
                                       type="text">
                            </div>
                        </li>

                        <li>
                            <div class="item">
                                <label><input id="lastName" placeholder="Last name" required="required"
                                              type="text"></label>
                            </div>
                        </li>

                        <li>
                            <div class="item">
                                <label><input id="group" placeholder="Group" required="required" type="text"></label>
                            </div>
                        </li>

                        <li><input class="button-register" id='sendButton' type="" value="Sign Up"></li>
                    </ul>
                </fieldset>
            </form>
        </div>
    </div>
</div>

<script src="js/registration-page/registerValidation.js"></script>
<script src="js/registration-page/tabs.js"></script>
<script src="js/registration-page/dataProcessor.js"></script>



</script>

</body>
</html>


