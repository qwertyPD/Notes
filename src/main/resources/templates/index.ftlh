<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Organizer</title>
    <link rel="stylesheet" type="text/css" href="/static/css/style.css"/>
</head>
<body>
    <h2>Добавить</h2>

    <form action="/add" method="post">
        <table>
            <tr>
                <td>
                    <label>Заметка</label>
                    <label>
                        <input type="text" name="noteBody">
                    </label>
                </td>
                <td>
                    <label>Дата</label>
                    <label>
                        <input type="date" name="noteDate">
                    </label>
                </td>
                <td>
                    <input type="submit" value="Add">
                </td>
            </tr>
        </table>
    </form>

    <br>

    <h2>Заметки (${noteListSize})</h2>
    <table>
        <tr>
            <td>Заметка</td>
            <td>Дата</td>
        </tr>
        <#list noteList as note>
            <tr>
                <td>${note.noteBody}</td>
                <td>${note.noteDate}</td>
                <td><a href="${'/delete/'+note.id}">Удалить</a></td>
            </tr>
        </#list>
    </table>
</body>
</html>