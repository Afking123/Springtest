
    function search(method) {
    var id =document.getElementById('bookid').value;
    fetch(('/book/'+id),{method:method})
    .then(response => response.text())
    .then(data => {
    document.getElementById('test-div').innerHTML = data;
})
    .catch(error => {
    console.error('Error:', error);
});
}
    function updated(method) {
    var id = document.getElementById('bookid').value;
    var name = document.getElementById('bookname').value;
    var writer = document.getElementById('bookwriter').value;
    var date = document.getElementById('bookdate').value;

    fetch('/book/' + id, {
    method: method.toUpperCase(),
    headers: {
    'Content-Type': 'application/json'
},
    body: JSON.stringify([{ "bookname": name, "bookwriter": writer, "bookdate": date }])
})
    .then(response => response.text())
    .then(data => {
    document.getElementById('test-div').innerHTML = data;
})
    .catch(error => {
    console.error('Error:', error);
});
}
