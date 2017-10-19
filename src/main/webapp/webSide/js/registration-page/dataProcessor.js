$('#sendButton').on('click', function () {
    var request = $.ajax({
        type: "POST",
        url: '/register',
        data: {
            email: $('#regEmail').val(),
            password: $('#regPassword').val(),
            firstName: $('#firstName').val(),
            secondName: $('#lastName').val(),
            learningGroup: $('#group').val()
        },

        success: function (response) {
            handleResponse(response);
        },
        error: function () {
            alert("error");
        }
    });

    function handleResponse(response) {
        console.log(response);
    }

});


$('#button-login').on('click', function () {
    var request = $.ajax({
        type: "POST",
        url: '/signIn',
        data: {
            email: $('#email').val(),
            password: $('#password').val()

        },

        success: function (response) {
            successLogin(response);
        },
        error: function () {
            alert("error");
        }
    });

    function handleResponse(response) {
        console.log(response);
    }

});

function successLogin(response) {
    var request = $.ajax({
        type: "GET",
        url: '/signIn',

        success: function (response) {

        },

        error: function () {
            alert("error");
        }
    });
}