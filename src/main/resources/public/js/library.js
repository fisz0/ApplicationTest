function redirectToLoginPage() {
    document.getElementsByTagName("head")[0].innerHTML += '<meta HTTP-EQUIV="REFRESH" content="0; /login">';
}
