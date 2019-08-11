<!-- EDIT modal-->

$(document).ready(function(){
    $('.dropdown .eBtn').on('click', function(event){
        //prevents redirection to blank page with JSON-Task-Object
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(task){
            $('.myForm #id').val(task.id);
            $('.myForm #title').val(task.title);
            $('.myForm #content').val(task.content);
            $('.myForm #status').val(task.status);
        });
        $('.myForm #editModal').modal();
    });
});

<!--NEW Task Modal-->

$(document).ready(function(){
    $('.newBtn').on('click', function(event){
        var href = $(this).attr('href');

        $.get(href, function(list){
            for (let i = 0; i < list.size(); i++) {
                $('.myForm #id').val(task.id);
            }
            $('.myForm #id').val(task.id);
            $('.myForm #title').val(task.title);
            $('.myForm #content').val(task.content);
            $('.myForm #status').val(task.status);
        });

        // $('.newTaskForm #id').val('');
        // $('.newTaskForm #title').val('');
        // $('.newTaskForm #content').val('');
        // $('.newTaskForm #status').val('OPEN');
        $('.newTaskForm #newTaskModal').modal();
    });
});

<!--Datatable-->

const dataTable = $('#realtime').DataTable({
    data: actionList,
    columns: [
        { data: 'Услуга' },
        { data: 'Сколько раз в неделю' },
        { data: 'На какой период' },
        { data: 'Удалить услугу' }
    ]
});



var ajaxUrl = "ajax/profile/meals/";
var datatableApi;

function updateTable() {
    $.ajax({
        type: "POST",
        url: ajaxUrl + "filter",
        data: $("#filter").serialize(),
        success: updateTableByData
    });
}

function clearFilter() {
    $("#filter")[0].reset();
    $.get(ajaxUrl, updateTableByData);
}

$(function () {
    datatableApi = $("#datatable").DataTable({
        "paging": false,
        "info": true,
        "columns": [
            {
                "data": "dateTime"
            },
            {
                "data": "description"
            },
            {
                "data": "calories"
            },
            {
                "defaultContent": "Edit",
                "orderable": false
            },
            {
                "defaultContent": "Delete",
                "orderable": false
            }
        ],
        "order": [
            [
                0,
                "desc"
            ]
        ]
    });
    makeEditable();
});

