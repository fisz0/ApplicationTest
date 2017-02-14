function redirectToLoginPage() {
    document.getElementsByTagName("head")[0].innerHTML += '<meta HTTP-EQUIV="REFRESH" content="0; /login">';
}

function deleteUser(id) {
    var header = $("meta[name='_csrf_header']").attr("content");
    var token = $("meta[name='_csrf']").attr("content");
    $.ajax({
        url: "/delete/" + id,
        type: 'DELETE',
        contentType: 'application/json',
        dataType: 'text',
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function () {
            window.location.href = "/users";
        },
        error: function (request, message, error) {
            console.log(request);
            console.log(message);
            console.log(error);
        }
    });
}



