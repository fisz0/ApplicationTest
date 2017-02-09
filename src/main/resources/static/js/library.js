function testFunction(){
    var button = document.getElementById('btn');
    button.addEventListener('click', function(){
        alert('This is my first JS function ever!');
    });
}

document.addEventListener("DOMContentLoaded",testFunction);
