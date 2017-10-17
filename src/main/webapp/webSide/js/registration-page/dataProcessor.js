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