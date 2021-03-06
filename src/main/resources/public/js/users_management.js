window.onresize = function () {
    removeUserButtonsResize();
}

window.onload = function () {
    loadUsersTable();
}

function deleteUser(event) {
    console.info("Delete user button clicked");
    var buttonClicked = event.target;
    var header = $("meta[name='_csrf_header']").attr("content");
    var token = $("meta[name='_csrf']").attr("content");

    $.confirm({
        title: 'Warning!',
        content: 'Are you sure you want to delete?',
        buttons: {
            confirm: {
                btnClass: 'btn-danger',
                action: function () {
                    console.info("Delete user action- confirmed.");
                    $.ajax({
                        url: "/users/delete/" + $(buttonClicked).attr("id"),
                        type: 'DELETE',
                        contentType: 'application/json',
                        dataType: 'text',
                        beforeSend: function (xhr) {
                            xhr.setRequestHeader(header, token);
                        },
                        success: function () {
                            console.info("Delete action finished with success. Dynamically reloading users table content.");
                            loadUsersTable();
                        },
                        error: function (request, message, error) {
                            console.error(request);
                            console.error(message);
                            console.error(error);
                        }
                    });
                }
            },
            cancel: {
                btnClass: 'btn-success',
                action: function () {
                    console.info("Delete user action- cancelled.");
                },
            }
        }
    });
}

function loadUsersTable() {
    $('#userTableContainer').load("users_table", function () {
        removeUserButtonsResize();
        userDetailsPanelInjectHandler();
        removeUserHandler();
    });
}

function userDetailsPanelInjectHandler() {
    var buttons = document.getElementsByClassName("linkBtn");
    for (var i = 0; i < buttons.length; i++) {
        buttons[i].addEventListener('click', function () {
            $('#userDetailsPanel').load("user/" + $(this).attr('name'));
        })
    }
}
function removeUserButtonsResize() {
    var buttons = document.getElementsByClassName("deleteUserBtn")
    for (var i = 0; i < buttons.length; i++) {
        $('#' + $(buttons[i]).attr('id')).css("height", $(buttons[i].parentNode).height());
    }
}

function removeUserHandler() {
    var buttons = document.getElementsByClassName("deleteUserBtn")
    for (var i = 0; i < buttons.length; i++) {
        buttons[i].addEventListener('click', deleteUser);
    }
}
