$(document).ready(function () {
    //Email validation
    $('#email').on('input', function () {
        emailValidation('email');
    });

    $('#regEmail').on('input', function () {
        emailValidation('regEmail');
    });

    //password validation
    $('#password').on('input', function () {
        passwordValidation('password')
    });

    $('#regPassword').on('input', function () {
        passwordValidation('regPassword');
    });

    $('#regRepeatedPassword').on('input', function () {
        var regPassword = $('#regPassword').val();
        var regRepeatedPassword = $('#regRepeatedPassword').val();
        passwordValidation('regRepeatedPassword');
        if (isPasswordCorrect(regPassword) && isPasswordCorrect(regRepeatedPassword)) {
            if (regPassword == regRepeatedPassword) {
                $('#regRepeatedPassword').css('border-width', '3px');
                $('#regRepeatedPassword').css('border-color', 'green');
            }
        }
        else {
            $('#regRepeatedPassword').css('border-width', '3px');
            $('#regRepeatedPassword').css('border-color', 'red');
        }
    });

//Text fields validation
    $('#firstName').on('input', function () {
        var input = $('#firstName').val();
        setBorderStyle(validTextField(), 'firstName')
    });

    $('#lastName').on('input', function () {
        var input = $('#lastName').val();
        setBorderStyle(validTextField(), 'lastName')
    });

    $('#group').on('input', function () {
        var input = $('#group').val();
        setBorderStyle(validTextField(), 'group')
    });

    function emailValidation(fieldName) {
        var input = $('#' + fieldName).val();
        var re = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)+[a-z]*$/;
        var is_email = re.test(input);
        setBorderStyle(is_email, fieldName)
    }

    function passwordValidation(fieldName) {
        var input = $('#' + fieldName).val();
        setBorderStyle(isPasswordCorrect(input), fieldName)
    }

    function isPasswordCorrect(password) {
        var re = /^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
        return re.test(password);
    }

    function validTextField(field) {
        return field.length > 4 && field.length < 32;
    }

    function setBorderStyle(isCorrect, fieldName) {
        if (isCorrect) {
            $('#' + fieldName).css('border-width', '3px');
            $('#' + fieldName).css('border-color', 'green');
        }
        else {
            $('#' + fieldName).css('border-width', '3px');
            $('#' + fieldName).css('border-color', 'red');
        }
    }
})
;