window.onload = function () {
    let email = sessionStorage.getItem("email");

    if (email !== null) {
        $.ajax({
            url: "/pw/add-attempt",
            headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},
            type: "POST",
            data: email

        })
            .done(function (data, textStatus, xhr) {
                console.log(xhr.status);
            })
            .fail(function () {
                console.log("fail");
            });
    }
};

$("#sign-in-btn").click(function (event) {
    let email = $("#email-lbl").val();
    sessionStorage.setItem("email", email);

    // event.preventDefault();
    //
    //
    //
    // $.ajax({
    //     url: "/pw/add-attempt?email=" + email,
    //     headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},
    //     type: "POST"
    // })
    //     .done(function (data, textStatus, xhr) {
    //         console.log(xhr.status);
    //     })
    //     .fail(function () {
    //         console.log("fail");
    //     });
});