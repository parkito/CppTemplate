$(document).ready(function () {
    //Login validation
    $('#email').on('input', function () {
        var input = $('#email').val();
        var re = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)+[a-z]*$/;
        var is_email = re.test(input);
        setBorderStyle(is_email, 'email')
    });
    //password validation
    $('#password').on('input', function () {
        var input = $('#password').val();
        var re = /^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
        var is_correct_password = re.test(input);
        setBorderStyle(is_correct_password, 'password')
    });

    //Text fields validation
    $('#firstName').on('input', function () {
        var input = $('#firstName').val();
        setBorderStyle(validTestField(), 'firstName')
    });

    $('#lastName').on('input', function () {
        var input = $('#lastName').val();
        setBorderStyle(validTestField(), 'lastName')
    });

    $('#group').on('input', function () {
        var input = $('#group').val();
        setBorderStyle(validTestField(), 'group')
    });

    function validTestField(field) {
        return field.length() > 4 && field.length() < 32;
    }

    function setBorderStyle(isCorrect, field) {
        if (isCorrect) {
            $('#' + field).css('border-width', '3px');
            $('#' + field).css('border-color', 'green');
        }
        else {
            $('#' + field).css('border-width', '3px');
            $('#' + field).css('border-color', 'red');
        }
    }
})