/**
 * Created by mokon on 20.02.2017.
 */
$(function () {
    $('#addNoteBtn').click(function () {
        var header = $("meta[name='_csrf_header']").attr("content");
        var token = $("meta[name='_csrf']").attr("content");

        $.confirm({
            title: 'Prompt!',
            content: '' +
            '<form action="" class="formName">' +
            '<div class="form-group">' +
            '<label>Enter something here</label>' +
            '<input type="text" placeholder="Your name" class="note form-control" required />' +
            '</div>' +
            '</form>',
            buttons: {
                formSubmit: {
                    text: 'New Note!',
                    btnClass: 'btn-blue',
                    action: function () {
                        var note = this.$content.find('.name').val();
                        $.ajax({
                            url: "/users/add_note/",
                            type: 'POST',
                            contentType: 'application/json',
                            dataType: 'text',
                            data: note,
                            beforeSend: function (xhr) {
                                xhr.setRequestHeader(header, token);
                            },
                            success: function () {
                                console.info("Note saved. Dynamically reloading users notes content.");
                                loadNotesTable();
                            },
                            error: function (request, message, error) {
                                console.error(request);
                                console.error(message);
                                console.error(error);
                            }
                        });
                    }
                },
                cancel: function () {
                    //close
                },
            },
            onContentReady: function () {
                // bind to events
                var jc = this;
                this.$content.find('form').on('submit', function (e) {
                    // if the user submits the form by pressing enter in the field.
                    e.preventDefault();
                    jc.$$formSubmit.trigger('click'); // reference the button and click it
                });
            }
        });
    })
});

function loadNotesTable() {
    $('#userTableContainer').load("notes_table", function () {
        userDetailsPanelInjectHandler();
    });
}

function userDetailsPanelInjectHandler() {
    var buttons = document.getElementsByClassName("linkBtn");
    for (var i = 0; i < buttons.length; i++) {
        buttons[i].addEventListener('click', function () {
            $('#userNotesTable').load("user_table/" + $(this).attr('name'));
        })
    }
}
