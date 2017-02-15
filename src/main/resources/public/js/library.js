function redirectToLoginPage() {
    document.getElementsByTagName("head")[0].innerHTML += '<meta HTTP-EQUIV="REFRESH" content="0; /login">';
}

function deleteUser(id) {
    console.log("Delete user button clicked");

    var header = $("meta[name='_csrf_header']").attr("content");
    var token = $("meta[name='_csrf']").attr("content");

    $.confirm({
        title: 'Warning!',
        content: 'Are you sure you want to delete?',
        buttons: {
            confirm: {
                btnClass: 'btn-danger',
                action: function () {
                    console.log("Delete user action- confirmed.");
                    $.ajax({
                        url: "/delete/" + id,
                        type: 'DELETE',
                        contentType: 'application/json',
                        dataType: 'text',
                        beforeSend: function (xhr) {
                            xhr.setRequestHeader(header, token);
                        },
                        success: function () {
                            console.log("Delete action finished with success. Redirecting to /users page.");
                            window.location.href = "/users";
                        },
                        error: function (request, message, error) {
                            console.log(request);
                            console.log(message);
                            console.log(error);
                        }
                    });
                }
            },
            cancel: {
                btnClass: 'btn-success',
                action: function () {
                    console.log("Delete user action- cancelled.");
                },
            }
        }
    });
}

$(document).ready(function () {
    var buttons = document.getElementsByClassName("linkBtn");
    for (var i = 0; i < buttons.length; i++) {
        buttons[i].addEventListener('click', function () {
            $('#injectContainer').load("user/" + $(this).attr('name'));
        })
    }
});
