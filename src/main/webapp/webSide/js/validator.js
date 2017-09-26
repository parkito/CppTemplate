$(document).ready(function () {
    $('#name').on('input', function () {
        var input = $('#name').val();
        var re = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
        var is_email = re.test(input);
        if (is_email) {
            $('#name').removeClass("invalid").addClass("valid");
            console.log(input)
        }
        else {
            $('#name').removeClass("valid").addClass("invalid");
        }
    });
})