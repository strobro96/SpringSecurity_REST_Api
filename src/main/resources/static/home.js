$(document).ready(function () {
    return drawTable();
});

async function drawTable() {
    const response = await fetch('/api/user/', {
        method: 'GET',
        headers: {'Content-Type': 'application/json'}
    });
    const {id, name, surname, age, username, email, roles} = await response.json();

    $('#user-tbody').append(`<tr>
        <td>${id}</td>
        <td>${name}</td>
        <td>${surname}</td>
        <td>${age}</td>
        <td>${username}</td>
        <td>${email}</td>
        <td>${roles.map(({name}) => name)}</td>
      </tr>`);
}
